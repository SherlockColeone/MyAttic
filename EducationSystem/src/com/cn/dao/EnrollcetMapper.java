package com.cn.dao;

import com.cn.bean.Enrollcet;
import com.cn.bean.EnrollcetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnrollcetMapper {
    int countByExample(EnrollcetExample example);

    int deleteByExample(EnrollcetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enrollcet record);

    int insertSelective(Enrollcet record);

    List<Enrollcet> selectByExample(EnrollcetExample example);

    Enrollcet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Enrollcet record, @Param("example") EnrollcetExample example);

    int updateByExample(@Param("record") Enrollcet record, @Param("example") EnrollcetExample example);

    int updateByPrimaryKeySelective(Enrollcet record);

    int updateByPrimaryKey(Enrollcet record);
}