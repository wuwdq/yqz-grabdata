package com.yqz.mapper;

import com.yqz.pojo.SubjectDetail;
import com.yqz.pojo.SubjectDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectDetailMapper {
    int countByExample(SubjectDetailExample example);

    int deleteByExample(SubjectDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubjectDetail record);

    int insertSelective(SubjectDetail record);

    List<SubjectDetail> selectByExampleWithBLOBs(SubjectDetailExample example);

    List<SubjectDetail> selectByExample(SubjectDetailExample example);

    SubjectDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubjectDetail record, @Param("example") SubjectDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") SubjectDetail record, @Param("example") SubjectDetailExample example);

    int updateByExample(@Param("record") SubjectDetail record, @Param("example") SubjectDetailExample example);

    int updateByPrimaryKeySelective(SubjectDetail record);

    int updateByPrimaryKeyWithBLOBs(SubjectDetail record);

    int updateByPrimaryKey(SubjectDetail record);
}