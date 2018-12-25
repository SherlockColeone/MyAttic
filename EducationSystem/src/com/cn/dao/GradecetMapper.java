package com.cn.dao;

import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradecetMapper {
    int countByExample(GradecetExample example);

    int deleteByExample(GradecetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gradecet record);

    int insertSelective(Gradecet record);

    List<Gradecet> selectByExample(GradecetExample example);

    Gradecet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gradecet record, @Param("example") GradecetExample example);

    int updateByExample(@Param("record") Gradecet record, @Param("example") GradecetExample example);

    int updateByPrimaryKeySelective(Gradecet record);

    int updateByPrimaryKey(Gradecet record);
}