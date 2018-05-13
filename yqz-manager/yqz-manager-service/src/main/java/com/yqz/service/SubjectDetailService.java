package com.yqz.service;

import com.yqz.exception.ServiceException;
import com.yqz.pojo.SubjectDetail;
import com.yqz.result.ParseResult;

/**
 * 电影详情业务处理接口
 *
 * @author td
 * @version $Id: SubjectDetailService.java, v 0.1 2018年5月9日 下午10:17:13 td Exp $
 */
public interface SubjectDetailService {
    
    /**
     * 保存爬取后的数据至数据库
     *
     * @param result
     */
    void save(ParseResult<SubjectDetail> result) throws ServiceException;
    
    /**
     * 根据电影id查询电影详情
     *
     * @param id
     * @return
     */
    SubjectDetail findSubjectDetailById(Long id) throws ServiceException;
}
