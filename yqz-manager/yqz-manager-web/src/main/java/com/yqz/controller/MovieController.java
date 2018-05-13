package com.yqz.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqz.common.PageData;
import com.yqz.common.ResponseUtil;
import com.yqz.exception.ServiceException;
import com.yqz.pojo.Subject;
import com.yqz.pojo.SubjectComment;
import com.yqz.pojo.SubjectDetail;
import com.yqz.service.SubjectCommentService;
import com.yqz.service.SubjectDetailService;
import com.yqz.service.SubjectService;

/**
 * 电影Controller
 *
 * @author td
 * @version $Id: MovieController.java, v 0.1 2018年5月10日 上午12:59:47 td Exp $
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectDetailService subjectDetailService;
    @Autowired
    private SubjectCommentService subjectCommentService;
    
    /**
     * 获取电影信息
     * 包含两种方式
     * 1.获取全部电影信息  (不传参数tag)
     * 2.获取标识后的电影  (传参数tag)
     *
     * @param page 当前页
     * @param rows 一页显示记录数
     * @param tag  电影标识（热门，最新等）
     * @return
     */
    @RequestMapping(value="/subject", method = RequestMethod.GET)
    public Map<String, Object> getMovie(@RequestParam(value="page",defaultValue="1") String page, @RequestParam(value="rows",defaultValue="20")String rows, String tag){
    	if(!page.matches("\\d+") || !rows.matches("\\d+")){
            return ResponseUtil.sendResult(false, "请求参数有误，非数字格式！");
        }
    	PageData<Subject> data = null;
        try {
            if(StringUtils.isNotBlank(tag)){
            	tag = new String(tag.getBytes("ISO-8859-1"),"UTF-8");
                LOGGER.info("根据标签获取获取电影信息，page="+page+",rows="+rows+",tag="+tag);
                data = subjectService.findByTag(Integer.valueOf(page), Integer.valueOf(rows), tag);
            }else{
                LOGGER.info("获取全部电影信息，page="+page+",rows="+rows);
                 data = subjectService.findAll(Integer.valueOf(page), Integer.valueOf(rows));
            }
            return ResponseUtil.sendResult(true, data);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取电影信息出现异常", e);
        }
        return ResponseUtil.sendResult(false, "系统异常！");
    }
    
    /**
     * 获取电影详情
     *
     * @param subjectId 电影id
     * @return
     */
    @RequestMapping(value="/subjectDetail/{subjectId}", method = RequestMethod.GET)
    public Map<String, Object> getMovieDetail(@PathVariable("subjectId") String subjectId){
        LOGGER.info("获取电影详情信息开始,subjectId=" + subjectId);
        if(StringUtils.isBlank(subjectId) || !subjectId.matches("\\d+")){
            return ResponseUtil.sendResult(false, "请求参数有误，非数字格式！");
        }
        try {
            SubjectDetail subjectDetail =  subjectDetailService.findSubjectDetailById(Long.valueOf(subjectId));
            if(subjectDetail == null){
            	return  ResponseUtil.sendResult(true, "无相关信息！");
            }
            return  ResponseUtil.sendResult(true, subjectDetail);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取电影详细内容信息出现异常", e);
        }
        return ResponseUtil.sendResult(false, "系统异常！");
    }
    
    /**
     * 获取所有电影评论
     *
     * @param page 当前页
     * @param rows 一页显示记录数
     * @return
     */
    @RequestMapping(value="/subjectComment", method = RequestMethod.GET)
    public Map<String, Object> getAllComments(@RequestParam(value="page",defaultValue="1") String page, @RequestParam(value="rows",defaultValue="20") String rows, String subjectId){
        LOGGER.info("获取全部电影信息，page="+page+",rows="+rows);
        if(StringUtils.isBlank(subjectId)){
        	return ResponseUtil.sendResult(false, "请求参数有误，缺少参数！");
        }
        if(!page.matches("\\d+") || !rows.matches("\\d+") || !subjectId.matches("\\d+")){
            return ResponseUtil.sendResult(false, "请求参数有误，非数字格式！");
        }
        try {
            PageData<SubjectComment> data = subjectCommentService.findAll(Integer.valueOf(page), Integer.valueOf(rows), Long.valueOf(subjectId));
            return ResponseUtil.sendResult(true, data);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取电影评论信息出现异常", e);
        }
        return ResponseUtil.sendResult(false, "系统异常！");
    }
    
    /**
     * 按某字段排序后取出数据
     * 并指定返回多少条记录
     *
     * @param sort  排序字段,默认按照评价有用数排序
     * @param order 指定升序还是降序，默认降序
     * @param size  限制查询多少条数据 ,默认10条
     * @return
     */
    @RequestMapping(value="/subjectCommentLimit", method = RequestMethod.GET)
    public Map<String, Object> getCommentsLimit(@RequestParam(value="sort",defaultValue="comment_vote") String sort, @RequestParam(value="order",defaultValue="desc") String order,
    		@RequestParam(value="size",defaultValue="10") String size, String subjectId){
        LOGGER.info("排序后取出电影评论信息,sort=" + sort + ",order=" + order + ",size=" + size + ",subjectId=" + subjectId);
        if(StringUtils.isBlank(subjectId)){
        	return ResponseUtil.sendResult(false, "请求参数有误，缺少参数！");
        }
        if(!size.matches("\\d+")){
            return ResponseUtil.sendResult(false, "请求参数有误，非数字格式！");
        }
        try {
            List<SubjectComment> limitDatas = subjectCommentService.getCommentsBySortAndLimit(sort, order, Integer.valueOf(size), Long.valueOf(subjectId));
            if(limitDatas == null || limitDatas.size() == 0){
            	 return ResponseUtil.sendResult(true, "无相关信息");
            }
            return ResponseUtil.sendResult(true, limitDatas);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("排序后取出电影评论信息出现异常", e);
        }
        return ResponseUtil.sendResult(false, "系统异常！");
    }
}
