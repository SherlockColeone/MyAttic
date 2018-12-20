package com.cn.dao;

import com.cn.bean.Tempelective;
import com.cn.bean.TempelectiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempelectiveMapper {
    int countByExample(TempelectiveExample example);

    int deleteByExample(TempelectiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tempelective record);

    int insertSelective(Tempelective record);

    List<Tempelective> selectByExample(TempelectiveExample example);

    Tempelective selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tempelective record, @Param("example") TempelectiveExample example);

    int updateByExample(@Param("record") Tempelective record, @Param("example") TempelectiveExample example);

    int updateByPrimaryKeySelective(Tempelective record);

    int updateByPrimaryKey(Tempelective record);
}