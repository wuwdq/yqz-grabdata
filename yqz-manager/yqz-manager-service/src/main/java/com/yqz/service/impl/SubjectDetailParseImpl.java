package com.yqz.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yqz.common.DataUtils;
import com.yqz.common.JsonUtils;
import com.yqz.exception.DataParseException;
import com.yqz.pojo.SubjectDetail;
import com.yqz.response.Response;
import com.yqz.result.ParseResult;
import com.yqz.service.GrabDataService;

import us.codecraft.webmagic.selector.Html;

/**
 * 采集电影详情
 *
 * @author td
 * @version $Id: SubjectDetailParse.java, v 0.1 2018年5月7日 下午11:49:24 td Exp $
 */
@Service("subjectDetailParse")
public class SubjectDetailParseImpl implements GrabDataService<SubjectDetail> {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectDetailParseImpl.class);
    
    @Override
    public ParseResult<SubjectDetail> parse(Response response) throws DataParseException {
        LOGGER.info("开始解析返回电影详情内容");
        ParseResult<SubjectDetail> result = new ParseResult<SubjectDetail>();
        String content = response.getContent();
        if(StringUtils.isNotBlank(content)){
            try {
                SubjectDetail subjectDetail = new SubjectDetail();
                Html html = new Html(content);
                Document document = html.getDocument();
                String detailTitle1 = document.select("h1 span[property]").text();
                String detailTitle2 = document.select("h1 span.year").text();
                String detailTitle = detailTitle1 + detailTitle2;
                String detailDirectors = "";
                String detailWriters = "";
                String detailActors = "";
                String detailTypes = "";
                String detailRegion = "";
                String detailLanguages = "";
                String detailYear = "";
                String detailDuration = "";
                String detailAliasName = "";
                String info = document.select("div#info").first().text();
                if(StringUtils.isNotBlank(info)){
                    // 导演
                    detailDirectors = DataUtils.removeEmpty(StringUtils.substringBetween(info, "导演:", "编剧:"));
                    // 编剧
                    detailWriters = DataUtils.removeEmpty(StringUtils.substringBetween(info, "编剧:", "主演:"));
                    // 主演
                    detailActors = DataUtils.removeEmpty(StringUtils.substringBetween(info, "主演:", "类型:"));
                    if(StringUtils.contains(info, "官方网站")){
                        // 类型
                        detailTypes = DataUtils.removeEmpty(StringUtils.substringBetween(info, "类型:", "官方网站:"));
                    }else{
                        // 类型
                        detailTypes = DataUtils.removeEmpty(StringUtils.substringBetween(info, "类型:", "制片国家/地区:"));  
                    }
                    // 制片国家/地区
                    detailRegion = DataUtils.removeEmpty(StringUtils.substringBetween(info, "制片国家/地区:", "语言:"));
                    // 语言
                    detailLanguages = DataUtils.removeEmpty(StringUtils.substringBetween(info, "语言:", "上映日期:"));
                    // 上映日期
                    detailYear = DataUtils.removeEmpty(StringUtils.substringBetween(info, "上映日期:", "片长:"));
                    // 片长
                    detailDuration = DataUtils.removeEmpty(StringUtils.substringBetween(info, "片长:", "又名:"));
                    // 又名
                    detailAliasName = DataUtils.removeEmpty(StringUtils.substringBetween(info, "又名:", "IMDb链接:"));
                }
                // 简介
                String detailIntroduce = DataUtils.removeEmpty(document.select("div#link-report").first().text());
                // 评价数量
                String detailCommentNum = DataUtils.removeEmpty(document.select("div.rating_sum a span").first().text());
                String star = DataUtils.removeEmpty(document.select("div.rating_right div").first().attr("class"));
                // 平均点星数
                String detailStar = getAverageStarNum(star);
                String rateOnWeightStr = DataUtils.removeEmpty(document.select("div.ratings-on-weight").first().text());
                String rateOnWeight = DataUtils.removeEmpty(rateOnWeightStr).replaceAll("%", "%,");
                // 各星级占比
                String detailStarProportion =  StringUtils.substring(rateOnWeight, 0, rateOnWeight.length()-1);
                Elements aElements = document.select("div.rating_betterthan a");
                // 好于同类型影片占比
                String detailBetterThan = getBetterThan(aElements);
                
                //获取电影id
                String url = response.getRequest().getUrl();
                String subjectId = DataUtils.getStringNum(url);
                
                //填充参数
                subjectDetail.setDetailTitle(detailTitle);
                subjectDetail.setDetailDirectors(detailDirectors);
                subjectDetail.setDetailWriters(detailWriters);
                subjectDetail.setDetailActors(detailActors);
                subjectDetail.setDetailTypes(detailTypes);
                subjectDetail.setDetailRegion(detailRegion);
                subjectDetail.setDetailLanguages(detailLanguages);
                subjectDetail.setDetailReleaseYear(detailYear);
                subjectDetail.setDetailDuration(detailDuration);
                subjectDetail.setDetailAliasName(detailAliasName);
                subjectDetail.setDetailIntroduce(detailIntroduce);
                subjectDetail.setDetailCommentNum(Long.valueOf(detailCommentNum));
                subjectDetail.setDetailStar(Float.valueOf(detailStar));
                subjectDetail.setDetailStarProportion(detailStarProportion);
                subjectDetail.setDetailBetterThan(detailBetterThan);
                subjectDetail.setSubjectId(Long.valueOf(subjectId));
                subjectDetail.setCreateDate(new Date());
                subjectDetail.setUpdateDate(new Date());
                
                result.getDataList().add(subjectDetail);
                
                LOGGER.info(JsonUtils.objectToJson(subjectDetail));
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("解析电影详情内容出错", e);
                throw new DataParseException("解析电影详情内容出错", e);
            }
        }
        LOGGER.info("解析返回电影详情内容结束");
        return result;
    }

    
    /**
     * 获取
     * 好于同类型影片占比
     *
     * @param aElements
     * @return
     */
    private String getBetterThan(Elements aElements) {
        String detailBetterThan = "";
        if(aElements != null){
            for (int i = 0; i < aElements.size(); i++) {
                String betterThans = DataUtils.removeEmpty(aElements.get(i).text());
                detailBetterThan += betterThans + ",";
            }
            if(StringUtils.isNotBlank(detailBetterThan)){
                detailBetterThan = StringUtils.substring(detailBetterThan, 0, detailBetterThan.length()-1);
            }
        }
        return detailBetterThan;
    }

    /**
     * 取平均点星数
     *
     * @param star
     * @return
     */
    private String getAverageStarNum(String star) {
        String starNum =  DataUtils.getStringNum(star);
        if(StringUtils.isNotBlank(starNum)){
            String index1 = StringUtils.substring(starNum, 0, starNum.length()-1);
            String index2 = StringUtils.substring(starNum, starNum.length()-1);
            starNum = index1 + "." + index2;
        }
        return starNum;
    }
}
