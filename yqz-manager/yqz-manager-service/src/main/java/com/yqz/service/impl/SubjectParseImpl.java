package com.yqz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yqz.common.JsonUtils;
import com.yqz.datatype.GrabDataTypeEnum;
import com.yqz.exception.DataParseException;
import com.yqz.factory.HeaderFactory;
import com.yqz.pojo.Subject;
import com.yqz.request.Method;
import com.yqz.request.Request;
import com.yqz.response.Response;
import com.yqz.result.ParseResult;
import com.yqz.service.GrabDataService;

/**
 * 采集电影信息
 *
 * @author td
 * @version $Id: SubjectParse.java, v 0.1 2018年5月7日 下午11:49:06 td Exp $
 */
@Service("subjectParse")
public class SubjectParseImpl implements GrabDataService<Subject> {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectParseImpl.class);
    
    private static final String subject_comment_url = "https://movie.douban.com/subject/";

    @Override
    public ParseResult<Subject> parse(Response response) throws DataParseException {
        LOGGER.info("开始解析返回电影内容,response="+response.getContent());
        ParseResult<Subject> result = new ParseResult<Subject>();
        List<Subject> subjectList = new ArrayList<Subject>();
        List<Request> childRequests = new LinkedList<Request>();
        String content = response.getContent();
        try {
            if(StringUtils.isNotBlank(content)){
                Request req = response.getRequest();
                String requestUrl = response.getRequest().getUrl();
                String movieTag = req.getValueFromUrl(requestUrl,"tag");
                JSONObject jsonObject = JSON.parseObject(content);
                JSONArray jsarr = jsonObject.getJSONArray("subjects");
                if(jsarr != null && jsarr.size() > 0){
                    int arrySize = jsarr.size();
                    for(int i = 0; i < arrySize; i++){
                        Subject subject = new Subject();
                        JSONObject dataJson = jsarr.getJSONObject(i);
                        subject.setId(Long.valueOf(dataJson.getString("id")));
                        subject.setSubjectTitle(dataJson.getString("title"));
                        subject.setSubjectCover(dataJson.getString("cover"));
                        subject.setSubjectRate(dataJson.getString("rate"));
                        subject.setSubjectPlayable(dataJson.getBoolean("playable") == true ? 1 : 0);
                        subject.setSubjectIsNew(dataJson.getBoolean("is_new") == true ? 1 : 0);
                        subject.setSubjectType("movie");
                        subject.setSubjectTag(movieTag);
                        subject.setCreateDate(new Date());
                        subject.setUpdateDate(new Date());
                        subjectList.add(subject);
                        
                        //构建电影详情请求
                        Request subjectDetailRequest = new Request(GrabDataTypeEnum.SUBJECT_DETAIL.getType(),dataJson.getString("url"),Method.get);
                        HeaderFactory.getSubjecDetailHeader(subjectDetailRequest);
                        childRequests.add(subjectDetailRequest);
                        
                        //构建电影评价请求
                        //例：https://movie.douban.com/subject/26945085/comments?start=0&limit=20
                        //豆瓣只能查询从start=0-200条评价记录开始,start超过200,就提示没权限了，故此写死循环次数
                        //每页20条记录，当前从第0条记录往后查
                        //为什么每页只采集20条？
                        //原因：豆瓣后台每页返回记录数设置了限制，设置超过每页20条记录也只会返回20条
                        for(int j=0; j<=10; j++){
                            String urlParameter = dataJson.getString("id")+"/comments?start=" + (20*j) + "&limit=20";
                            Request subjectCommentRequest = new Request(GrabDataTypeEnum.SUBJECT_COMMENT.getType(),subject_comment_url + urlParameter,Method.get);
                            HeaderFactory.getSubjecCommentHeader(subjectCommentRequest);
                            childRequests.add(subjectCommentRequest);
                        }
                    }
                    result.setDataList(subjectList);
                    result.setChildRequests(childRequests);
                }
                LOGGER.info(JsonUtils.objectToJson(subjectList));
                LOGGER.info(subjectList.size() + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("解析电影内容出错", e);
            throw new DataParseException("解析电影内容出错", e);
        }
        LOGGER.info("解析返回电影内容结束");
        return result;
    }
}
