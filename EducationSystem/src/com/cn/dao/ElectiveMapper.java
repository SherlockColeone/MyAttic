package com.cn.dao;

import com.cn.bean.Elective;
import com.cn.bean.ElectiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectiveMapper {
    int countByExample(ElectiveExample example);

    int deleteByExample(ElectiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Elective record);

    int insertSelective(Elective record);

    List<Elective> selectByExample(ElectiveExample example);

    Elective selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Elective record, @Param("example") ElectiveExample example);

    int updateByExample(@Param("record") Elective record, @Param("example") ElectiveExample example);

    int updateByPrimaryKeySelective(Elective record);

    int updateByPrimaryKey(Elective record);
}