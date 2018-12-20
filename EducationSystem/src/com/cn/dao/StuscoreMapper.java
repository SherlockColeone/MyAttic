package com.cn.dao;

import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuscoreMapper {
    int countByExample(StuscoreExample example);

    int deleteByExample(StuscoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stuscore record);

    int insertSelective(Stuscore record);

    List<Stuscore> selectByExample(StuscoreExample example);

    Stuscore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stuscore record, @Param("example") StuscoreExample example);

    int updateByExample(@Param("record") Stuscore record, @Param("example") StuscoreExample example);

    int updateByPrimaryKeySelective(Stuscore record);

    int updateByPrimaryKey(Stuscore record);
}