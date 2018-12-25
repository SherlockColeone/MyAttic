package com.cn.dao;

import com.cn.bean.Curriculumarrange;
import com.cn.bean.CurriculumarrangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurriculumarrangeMapper {
    int countByExample(CurriculumarrangeExample example);

    int deleteByExample(CurriculumarrangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curriculumarrange record);

    int insertSelective(Curriculumarrange record);

    List<Curriculumarrange> selectByExample(CurriculumarrangeExample example);

    Curriculumarrange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curriculumarrange record, @Param("example") CurriculumarrangeExample example);

    int updateByExample(@Param("record") Curriculumarrange record, @Param("example") CurriculumarrangeExample example);

    int updateByPrimaryKeySelective(Curriculumarrange record);

    int updateByPrimaryKey(Curriculumarrange record);
}