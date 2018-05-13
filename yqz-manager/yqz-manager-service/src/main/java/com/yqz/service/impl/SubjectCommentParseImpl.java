package com.yqz.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yqz.common.DataUtils;
import com.yqz.common.JsonUtils;
import com.yqz.exception.DataParseException;
import com.yqz.pojo.SubjectComment;
import com.yqz.request.Request;
import com.yqz.response.Response;
import com.yqz.result.ParseResult;
import com.yqz.service.GrabDataService;

import us.codecraft.webmagic.selector.Html;

/**
 * 采集电影评价
 *
 * @author td
 * @version $Id: SubjectCommentParse.java, v 0.1 2018年5月7日 下午11:49:44 td Exp $
 */
@Service("subjectCommentParse")
public class SubjectCommentParseImpl implements GrabDataService<SubjectComment> {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectCommentParseImpl.class);

    @Override
    public ParseResult<SubjectComment> parse(Response response) throws DataParseException {
        LOGGER.info("开始解析返回电影评价内容");
        ParseResult<SubjectComment> result = new ParseResult<SubjectComment>();
        List<SubjectComment> commentList = new ArrayList<SubjectComment>();
        List<Request> childRequests = new LinkedList<Request>(); 
        String requestUrl = response.getRequest().getUrl();
        String content = response.getContent();
        if(StringUtils.isNotBlank(content)){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Html html = new Html(content);
                Document document = html.getDocument();
                Element comments = document.select("div#comments").first();
                if(comments != null){
                    String commentsContent = comments.text();
                    if(StringUtils.contains(commentsContent, "还没有人写过短评")){
                        LOGGER.info("已无评价数据，解析返回电影评价内容结束");
                        return result;
                    }
                    Elements items = comments.select("div.comment-item");
                    int itemSize = items.size();
                    for (int i = 0; i < itemSize; i++) {
                        SubjectComment subjectComment = new SubjectComment();
                        Element item = items.get(i);
                        // 评价人头像url
                        String commentPeoplePicture =  DataUtils.removeEmpty(item.select("div.avatar a img").attr("src"));
                        // 评价有用数
                        String commentVote = DataUtils.removeEmpty(item.select("div.comment span.comment-vote span.votes").first() == null ? "" : item.select("div.comment span.comment-vote span.votes").first().text());
                        // 评价人昵称
                        String commentPeople = DataUtils.removeEmpty(item.select("div.comment span.comment-info a").first() == null ? "" : item.select("div.comment span.comment-info a").first().text());
                        commentPeople = filterEmoji(commentPeople);
                        String commentStarStr = DataUtils.removeEmpty(item.select("div.comment span.comment-info span.rating").first() == null ? "" : item.select("div.comment span.comment-info span.rating").first().attr("class"));
                        // 推荐指数，星级
                        String commentStar = getStarNum(commentStarStr);
                        // 评价时间
                        String commentTime = DataUtils.removeEmpty(item.select("div.comment span.comment-info span.comment-time").first().text());
                        // 评价内容
                        String commentInfo = DataUtils.removeEmpty(item.select("div.comment p").first().text());
                        commentInfo =  filterEmoji(commentInfo);
                        // 电影id
                        String url = requestUrl;
                        String subjectId = DataUtils.getStringNum(url);
                        
                        //填充参数
                        subjectComment.setCommentPeople(commentPeople);
                        subjectComment.setCommentPeoplePicture(commentPeoplePicture);
                        subjectComment.setCommentVote(commentVote == "" ? 0:Integer.valueOf(commentVote));
                        subjectComment.setCommentStar(commentStar==""? 0:Integer.valueOf(commentStar));
                        subjectComment.setCommentTime(sdf.parse(commentTime));
                        subjectComment.setCommentInfo(commentInfo);
                        subjectComment.setSubjectId(Long.valueOf(subjectId));
                        subjectComment.setCreateDate(new Date());
                        subjectComment.setUpdateDate(new Date());
                        
                        commentList.add(subjectComment);
                    }
                    result.setDataList(commentList);
                    System.out.println(commentList.size());
                    System.out.println(JsonUtils.objectToJson(commentList));
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("解析电影评价内容出错", e);
                throw new DataParseException("解析电影评价内容出错", e);
            }
        }
        LOGGER.info("解析返回电影评价内容结束");
        return result;
    }

    /**
     * 取星数
     *
     * @param star
     * @return
     */
    private String getStarNum(String star) {
        String starNum = DataUtils.getStringNum(star);
        if(StringUtils.isNotBlank(starNum)){
            starNum = StringUtils.substring(starNum, 0, starNum.length()-1);
        }
        return starNum;
    }
    
    /**
     * 将emoji表情替换成空串
     *  
     * @param source
     * @return 过滤后的字符串
     */
    public String filterEmoji(String source) {
	     if (source != null && source.length() > 0) {
	    	 return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "");
	     } else {
	    	 return source;
	     }
    }
}
