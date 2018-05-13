package com.yqz.service;

import java.util.List;

import com.yqz.common.PageData;
import com.yqz.exception.ServiceException;
import com.yqz.pojo.SubjectComment;
import com.yqz.result.ParseResult;

/**
 * 电影评论处理业务接口
 *
 * @author td
 * @version $Id: SubjectCommentService.java, v 0.1 2018年5月9日 下午10:17:59 td Exp $
 */
public interface SubjectCommentService {
    
    /**
     * 保存爬取后的数据至数据库
     *
     * @param result
     */
    void save(ParseResult<SubjectComment> result) throws ServiceException;
    
    /**
     * 根据电影id查询所有电影评价数据
     *
     * @param page 当前页
     * @param rows 一页记录数
     * @param subjectId 电影id
     * @return
     * @throws ServiceException
     */
    PageData<SubjectComment> findAll(Integer page, Integer rows, Long subjectId) throws ServiceException;
    
    /**
     * 根据电影id按某字段排序后取出数据
     * 并指定返回多少条记录
     *
     * @param sort 排序字段
     * @param order 排序,升序or降序
     * @param size 返回多少条记录数
     * @param subjectId 电影id
     * @return
     * @throws ServiceException
     */
    List<SubjectComment> getCommentsBySortAndLimit(String sort, String order, Integer size, Long subjectId) throws ServiceException;
}
