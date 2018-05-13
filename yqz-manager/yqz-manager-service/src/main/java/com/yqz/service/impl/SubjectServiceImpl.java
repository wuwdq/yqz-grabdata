package com.yqz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqz.common.PageData;
import com.yqz.exception.ServiceException;
import com.yqz.mapper.SubjectMapper;
import com.yqz.pojo.Subject;
import com.yqz.pojo.SubjectExample;
import com.yqz.pojo.SubjectExample.Criteria;
import com.yqz.result.ParseResult;
import com.yqz.service.SubjectService;

/**
 * 电影业务处理实现类
 *
 * @author td
 * @version $Id: SubjectServiceImpl.java, v 0.1 2018年5月9日 下午10:21:08 td Exp $
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);
    
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void save(ParseResult<Subject> result) throws ServiceException{
        LOGGER.info("保存采集电影字段信息开始");
        try {
            if(result != null){
                List<Subject> dataList = result.getDataList();
                for (Subject subject : dataList) {
                    subjectMapper.insertSelective(subject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("插入采集电影字段信息出现异常", e);
            throw new ServiceException("插入采集电影字段信息出现异常", e);
        }
        LOGGER.info("保存采集电影字段信息结束");
    }

    @Override
    public PageData<Subject> findAll(Integer page, Integer rows) throws ServiceException{
        LOGGER.info("查询所有电影数据开始,page=" + page + ",rows=" + rows);
        PageData<Subject> subjectLists = null;
        PageHelper.startPage(page, rows);
        try {
            SubjectExample example = new SubjectExample();
            List<Subject> subjectList = subjectMapper.selectByExample(example);
            PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjectList);
            subjectLists = new PageData<Subject>(pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum(), subjectList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("查询所有电影数据出现异常", e);
            throw new ServiceException("查询所有电影数据出现异常", e);
        }
        LOGGER.info("查询所有电影数据结束");
        return subjectLists;
    }

    @Override
    public PageData<Subject> findByTag(Integer page, Integer rows, String tag) throws ServiceException {
        LOGGER.info("根据电影标签查询数据开始,page=" + page + ",rows=" + rows + ",tag=" + tag);
        PageData<Subject> subjectLists = null;
        PageHelper.startPage(page, rows);
        try {
            SubjectExample example = new SubjectExample();
            Criteria criteria = example.createCriteria();
            criteria.andSubjectTagEqualTo(tag);
            List<Subject> subjectList = subjectMapper.selectByExample(example);
            PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjectList);
            subjectLists = new PageData<Subject>(pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum(), subjectList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("根据电影标签查询数据出现异常", e);
            throw new ServiceException("根据电影标签查询数据出现异常", e);
        }
        LOGGER.info("根据电影标签查询数据结束");
        return subjectLists;
    }

	@Override
	public Subject findSubjectById(Long subjectId) throws ServiceException {
		LOGGER.info("根据电影id查询对应电影信息,subjectId=" + subjectId);
		Subject subject = null;
		try {
			subject = subjectMapper.selectByPrimaryKey(subjectId);
		} catch (Exception e) {
			e.printStackTrace();
            LOGGER.error("根据电影id查询对应电影信息出现异常", e);
            throw new ServiceException("根据电影id查询对应电影信息出现异常", e);
		}
		LOGGER.info("根据电影id查询数据结束");
		return subject;
	}

	@Override
	public int getSubjectCount() throws ServiceException {
		LOGGER.info("统计电影数据总量开始");
		int count = 0;
		try {
			count = subjectMapper.selectCount();
		} catch (Exception e) {
			e.printStackTrace();
            LOGGER.error("统计电影数据总量出现异常", e);
            throw new ServiceException("统计电影数据总量出现异常", e);
		}
		LOGGER.info("统计电影数据总量结束");
		return count;
	}

}
