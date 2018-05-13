package com.yqz.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqz.pojo.SubjectComment;
import com.yqz.pojo.SubjectCommentExample;

public interface SubjectCommentMapper {
    int countByExample(SubjectCommentExample example);

    int deleteByExample(SubjectCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubjectComment record);

    int insertSelective(SubjectComment record);

    List<SubjectComment> selectByExampleWithBLOBs(SubjectCommentExample example);

    List<SubjectComment> selectByExample(SubjectCommentExample example);

    SubjectComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubjectComment record, @Param("example") SubjectCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") SubjectComment record, @Param("example") SubjectCommentExample example);

    int updateByExample(@Param("record") SubjectComment record, @Param("example") SubjectCommentExample example);

    int updateByPrimaryKeySelective(SubjectComment record);

    int updateByPrimaryKeyWithBLOBs(SubjectComment record);

    int updateByPrimaryKey(SubjectComment record);
    
    /**
     * 获取部分电影评价
     *
     * @param map
     * @return
     */
    List<SubjectComment> selectBySortAndLimit(Map<String, Object> map);
}