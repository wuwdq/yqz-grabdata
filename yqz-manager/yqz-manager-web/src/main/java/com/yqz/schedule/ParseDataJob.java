package com.yqz.schedule;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yqz.datatype.DataTyeContants;
import com.yqz.datatype.GrabDataTypeEnum;
import com.yqz.exception.ServiceException;
import com.yqz.factory.HeaderFactory;
import com.yqz.http.impl.HttpClientImpl;
import com.yqz.pojo.Subject;
import com.yqz.pojo.SubjectComment;
import com.yqz.pojo.SubjectDetail;
import com.yqz.request.Method;
import com.yqz.request.Request;
import com.yqz.response.Response;
import com.yqz.result.ParseResult;
import com.yqz.service.GrabDataService;
import com.yqz.service.SubjectCommentService;
import com.yqz.service.SubjectDetailService;
import com.yqz.service.SubjectService;

@SuppressWarnings("all")
public class ParseDataJob {
    private final static Logger LOGGER = LoggerFactory.getLogger(ParseDataJob.class);
    
    //公用url
    private static final String                       URL_COMMON       = "https://movie.douban.com/j/search_subjects?type=movie";
    //种子requests
    private List<Request>                      seedsRequestList = new ArrayList<Request>();
    //存放Reuqest的队列
    private ConcurrentLinkedQueue<Request>     requestQueue     = new ConcurrentLinkedQueue<Request>();
    //去重Request
    private ConcurrentHashMap<String, Boolean> existRequestMap  = new ConcurrentHashMap<String, Boolean>();

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectDetailService subjectDetailService;
    @Autowired
    private SubjectCommentService subjectCommentService;
    
    @Resource(name="subjectParse")
    private GrabDataService<Subject> subjectParse;
    @Resource(name="subjectDetailParse")
    private GrabDataService<SubjectDetail> subjectDetailParse;
    @Resource(name="subjectCommentParse")
    private GrabDataService<SubjectComment> subjectCommentParse;
    
    private HttpClientImpl httpClientimpl = new HttpClientImpl();
    
    public void excute() throws Exception {
    	 LOGGER.info("构建种子请求开始");
    	 long start = System.currentTimeMillis();
    	// 统计数据库中电影数据量，如果已有数据且数据总量超过在200条，则只采集最新的20条电影数据
    	// 如果数据库中无数据或数据总量少于200条 ，则全部采集下来
    	int count = subjectService.getSubjectCount();
    	if(count > 0 && count > 10){
    		LOGGER.info(String.format("数据库中已有电影总数为:【%d】条", count));
    		LOGGER.info("构建种子请求----部分请求");
    		// 只采集不同类型的最新的前20条电影数据
          String urlHotParmater = "&tag="+URLEncoder.encode("热门", "UTF-8") + "&page_limit=2&page_start=50";
          String urlNewParmater = "&tag="+URLEncoder.encode("最新", "UTF-8") + "&page_limit=2&page_start=50";
          Request urlHotReuqest = new Request(GrabDataTypeEnum.SUBJECT.getType(), URL_COMMON + urlHotParmater, Method.get);
          Request urlNewReuqest = new Request(GrabDataTypeEnum.SUBJECT.getType(), URL_COMMON + urlNewParmater, Method.get);
          HeaderFactory.getSubjectHeader(urlHotReuqest);
          HeaderFactory.getSubjectHeader(urlNewReuqest);
          seedsRequestList.add(urlHotReuqest);
          seedsRequestList.add(urlNewReuqest);
    	}else{
    	  LOGGER.info("构建种子请求----全部请求");
		  // 豆瓣采集某一类型的电影，经测试最多只能返回500条记录，可能对方也只保存了不超过500条记录
          // 为降低对方服务器压力,防止反屏蔽，每次只采集100条，循环5次，默认最多采集500条，
          for(int i=0; i<5; i++){
	          String urlHotParmater = "&tag="+URLEncoder.encode("热门", "UTF-8") + "&page_limit=100&page_start=" + (100*i);
	          String urlNewParmater = "&tag="+URLEncoder.encode("最新", "UTF-8") + "&page_limit=100&page_start=" + (100*i);
	          Request urlHotReuqest = new Request(GrabDataTypeEnum.SUBJECT.getType(), URL_COMMON + urlHotParmater, Method.get);
	          Request urlNewReuqest = new Request(GrabDataTypeEnum.SUBJECT.getType(), URL_COMMON + urlNewParmater, Method.get);
	          HeaderFactory.getSubjectHeader(urlHotReuqest);
	          HeaderFactory.getSubjectHeader(urlNewReuqest);
	          seedsRequestList.add(urlHotReuqest);
	          seedsRequestList.add(urlNewReuqest);
          	}   		
    	}
        addRequestList(seedsRequestList, existRequestMap, requestQueue);
        while (!requestQueue.isEmpty()) {
            Request rawRequest = requestQueue.poll();
            LOGGER.info("从队列中取出请求，request="+rawRequest.toString());
            dfsParse(rawRequest);
        }
        long end = System.currentTimeMillis();
        System.out.println("采集及插入数据总共花的时间为：" + (double)(end - start)/(1000*60) + "分钟");
    }

    /**
     * 深度采集
     *
     * @param request
     */
    private void dfsParse(Request request){
        ParseResult parseResult = new ParseResult();
        int count = 0;//重试次数
        while (count <= request.getErrorRetry()) {
            try {
                LOGGER.info("执行下载请求，当前请求为："+request.toString());
                //设置随机休眠，防止请求频率过高
                int num = (int) (Math.random() * 3);
                Thread.sleep(num*1000); //0-3s
                Response response = httpClientimpl.download(request);
                String ReuqestId  = request.getId();
                switch(ReuqestId){
                    case DataTyeContants.SUBJECT:
                        parseResult = subjectParse.parse(response);
                        // 校验去重电影数据
                        parseResult = verifyDuplicateData(parseResult);
                        subjectService.save(parseResult);
                        break;
                    case DataTyeContants.SUBJECT_DETAIL:
                        parseResult = subjectDetailParse.parse(response);
                        subjectDetailService.save(parseResult);
                        break;
                    case DataTyeContants.SUBJECT_COMMENT:
                        parseResult = subjectCommentParse.parse(response);
                        subjectCommentService.save(parseResult);
                        break;
                    default:
                        System.out.println("无法识别的请求类型");
                }
                //以上请求及插入数据正常，停止业务失败重试
                count = request.getErrorRetry() + 1;
            } catch (Exception e) {
                count++;
                if(e instanceof ServiceException){
                    LOGGER.error("数据插入失败", e);
                    //数据插入失败,停止业务失败重试
                    count = request.getErrorRetry() + 1;
                }else{
                    if (count <= request.getErrorRetry()) {
                        LOGGER.warn("Collector页面下载或解析异常,还有机会重试,重试次数=" + count + ",request=" + request, e);
                    } else{
                        LOGGER.warn("Collector页面下载或解析异常,重试次数已耗尽", "request=" + request, e);
                    }
                }
            }
        }
        
        // 处理子链接
        if (parseResult != null && parseResult.getChildRequests() != null) {
            if (parseResult.getChildRequests().size() > 0) {
                List<Request> childReqs = new ArrayList<>();
                childReqs.addAll(parseResult.getChildRequests());
                for (Request req : childReqs) {
                    //执行递归
                    dfsParse(req);
                }
            }
        }
    }

    /**
     * 删除指定集合中在数据库中已有的数据
     * @param parseResult
     * @return
     * @throws ServiceException
     */
    private ParseResult verifyDuplicateData(ParseResult parseResult) throws ServiceException {
    	List<Subject> list = parseResult.getDataList();
    	Iterator<Subject> iterator = list.iterator();
    	while(iterator.hasNext()){
    		Subject subject  = subjectService.findSubjectById(iterator.next().getId());
    		if(subject != null){
    			iterator.remove();
    		}
    	}
		 LOGGER.info("list.size="+list.size());
		 LOGGER.info("parseResult.getDataList().size="+parseResult.getDataList().size());
    	return parseResult;
	}

	/**
     * 将request经过去重后加入到request队列当中
     *
     * @param requestList
     */
    private  void addRequestList(List<Request> requestList, ConcurrentHashMap<String, Boolean> existRequestMap, ConcurrentLinkedQueue<Request> requestQueue) {
        for (Request request : requestList) {
            String requestUrl = request.getUrl();
            if (!existRequestMap.containsKey(requestUrl)) {
                existRequestMap.put(requestUrl, true);
                requestQueue.add(request);
            }
        }
    }
}
