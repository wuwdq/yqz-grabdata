package com.yqz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yqz.common.JsonUtils;
import com.yqz.exception.ServiceException;
import com.yqz.mapper.SubjectDetailMapper;
import com.yqz.pojo.SubjectDetail;
import com.yqz.pojo.SubjectDetailExample;
import com.yqz.pojo.SubjectDetailExample.Criteria;
import com.yqz.result.ParseResult;
import com.yqz.service.SubjectDetailService;

/**
 * 电影详情业务实现类
 *
 * @author td
 * @version $Id: SubjectDetailServiceImpl.java, v 0.1 2018年5月9日 下午10:22:36 td Exp $
 */
@Service
public class SubjectDetailServiceImpl implements SubjectDetailService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectDetailServiceImpl.class);
    
    @Autowired
    private SubjectDetailMapper subjectDetailMapper;

    @Override
    public void save(ParseResult<SubjectDetail> result) throws ServiceException{
        LOGGER.info("保存采集电影详情字段信息开始");
        try {
            if(result != null){
                List<SubjectDetail> dataList = result.getDataList();
                for (SubjectDetail subjectDetail : dataList) {
                    subjectDetailMapper.insertSelective(subjectDetail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("插入采集电影详情字段信息出现异常", e);
            throw new ServiceException("插入采集电影详情字段信息出现异常", e);
        }
        LOGGER.info("保存采集电影详情字段信息结束");
    }

    @Override
    public SubjectDetail findSubjectDetailById(Long id) throws ServiceException {
        LOGGER.info("根据电影id查询电影详情开始,id=" + id);
        SubjectDetail subjectDetail = null;
        try {
            SubjectDetailExample example = new SubjectDetailExample();
            Criteria criteria = example.createCriteria();
            criteria.andSubjectIdEqualTo(id);
            List<SubjectDetail> subjectDetailList = subjectDetailMapper.selectByExampleWithBLOBs(example);
            if(subjectDetailList != null && subjectDetailList.size() > 0){
            	 subjectDetail = subjectDetailList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("查询电影详情出现异常", e);
            throw new ServiceException("查询电影详情出现异常", e);
        }
        LOGGER.info("查询电影详情结束");
        return subjectDetail;
    }

}
