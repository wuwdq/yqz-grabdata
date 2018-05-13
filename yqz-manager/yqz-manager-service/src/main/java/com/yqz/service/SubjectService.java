package com.yqz.service;


import com.yqz.common.PageData;
import com.yqz.exception.ServiceException;
import com.yqz.pojo.Subject;
import com.yqz.result.ParseResult;

/**
 * 电影处理业务接口
 *
 * @author td
 * @version $Id: SubjectService.java, v 0.1 2018年5月9日 下午10:16:21 td Exp $
 */
public interface SubjectService {
    
    /**
     * 保存爬取后的数据至数据库
     *
     * @param result
     */
    void save(ParseResult<Subject> result) throws ServiceException;
    
    /**
     * 查询所有电影数据
     *
     * @param page 当前页
     * @param rows 一页记录数
     * @return
     * @throws ServiceException
     */
    PageData<Subject> findAll(Integer page, Integer rows) throws ServiceException;
    
    /**
     * 根据电影标签查询电影数据
     *
     * @param page 当前页
     * @param rows 一页记录数
     * @param tag  标签
     * @return
     * @throws ServiceException
     */
    PageData<Subject>  findByTag(Integer page, Integer rows, String tag) throws ServiceException;
    
    
    /**
     * 根据电影id获取电影数据
     * @param subjectId 电影id
     * @return
     * @throws ServiceException
     */
    Subject  findSubjectById(Long subjectId) throws ServiceException;
    
    /**
     * 统计数据库中电影数据量
     * @return
     */
    int getSubjectCount() throws ServiceException;
}
