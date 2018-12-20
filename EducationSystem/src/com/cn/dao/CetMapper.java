package com.cn.dao;

import com.cn.bean.Cet;
import com.cn.bean.CetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CetMapper {
    int countByExample(CetExample example);

    int deleteByExample(CetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cet record);

    int insertSelective(Cet record);

    List<Cet> selectByExample(CetExample example);

    Cet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cet record, @Param("example") CetExample example);

    int updateByExample(@Param("record") Cet record, @Param("example") CetExample example);

    int updateByPrimaryKeySelective(Cet record);

    int updateByPrimaryKey(Cet record);
}