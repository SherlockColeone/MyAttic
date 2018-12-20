package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Academy;
import com.cn.dao.IAcademyDao;
import com.cn.dbc.BaseDao;

/**
 * 二级学院类接口实现类
 * @author Sherlock
 *
 */
public class AcademyDaoImpl implements IAcademyDao {
	BaseDao bd = new BaseDao();

	@Override
	public Academy findAcademyById(int id) {
		String sql = "select * from academy where id = ?";
		return (Academy)bd.query(sql, Academy.class, id).get(0);
	}

	@Override
	public Map<Integer, Academy> findAllAcademy() {
		String sql = "select * from academy";
		return bd.query(sql, Academy.class);
	}

}
