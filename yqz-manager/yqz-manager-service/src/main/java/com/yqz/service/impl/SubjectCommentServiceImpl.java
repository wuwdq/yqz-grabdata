package com.yqz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqz.common.PageData;
import com.yqz.exception.ServiceException;
import com.yqz.mapper.SubjectCommentMapper;
import com.yqz.pojo.SubjectComment;
import com.yqz.pojo.SubjectCommentExample;
import com.yqz.pojo.SubjectCommentExample.Criteria;
import com.yqz.result.ParseResult;
import com.yqz.service.SubjectCommentService;

/**
 * 电影评价处理业务实现类
 *
 * @author td
 * @version $Id: SubjectCommentServiceImpl.java, v 0.1 2018年5月9日 下午10:23:26 td Exp $
 */
@Service
public  class SubjectCommentServiceImpl implements SubjectCommentService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectCommentServiceImpl.class);
    
    @Autowired
    private SubjectCommentMapper subjectCommentMapper;

    @Override
    public void save(ParseResult<SubjectComment> result) throws ServiceException{
        LOGGER.info("保存采集电影评价字段信息开始");
        try {
            if(result != null){
                List<SubjectComment> dataList = result.getDataList();
                for (SubjectComment subjectComment : dataList) {
                    subjectCommentMapper.insertSelective(subjectComment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("插入采集电影评价字段信息出现异常", e);
            throw new ServiceException("插入采集电影评价字段信息出现异常", e);
        }
        LOGGER.info("保存采集电影评价字段信息结束");
    }

    @Override
    public PageData<SubjectComment> findAll(Integer page, Integer rows, Long subjectId) throws ServiceException {
        LOGGER.info("查询电影评价信息开始, page=" + page + ",rows=" + rows + ",电影id=" + subjectId);
        PageData<SubjectComment> subjectCommentLists = null;
        PageHelper.startPage(page, rows);
        try {
            SubjectCommentExample example = new SubjectCommentExample();
            Criteria criteria = example.createCriteria();
            criteria.andSubjectIdEqualTo(subjectId);
            List<SubjectComment> subjectCommentList = subjectCommentMapper.selectByExampleWithBLOBs(example);
            PageInfo<SubjectComment> pageInfo = new PageInfo<SubjectComment>(subjectCommentList);
            subjectCommentLists = new PageData<SubjectComment>(pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum(), subjectCommentList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("查询电影评价信息出现异常", e);
            throw new ServiceException("查询电影评价信息出现异常", e);
        }
        LOGGER.info("查询电影评价信息结束");
        return subjectCommentLists;
    }

    @Override
    public List<SubjectComment> getCommentsBySortAndLimit(String sort, String order, Integer size, Long subjectId) throws ServiceException {
        LOGGER.info("查询电影评价排序后信息开始,排序字段sort=" + sort + ",顺序order=" + order + ",返回记录数size=" + size + ",电影id=" + subjectId);
        List<SubjectComment> lists = null;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("sort", sort);
            map.put("order", order);
            map.put("size", size);
            map.put("subjectId", subjectId);
            lists = subjectCommentMapper.selectBySortAndLimit(map);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("查询电影评价排序后信息出现异常", e);
            throw new ServiceException("查询电影评价排序后信息出现异常", e);
        }
        LOGGER.info("查询电影评价排序后信息结束");
        return lists;
    }

}
