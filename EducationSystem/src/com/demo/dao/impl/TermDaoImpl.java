package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Term;
import com.cn.dao.ITermDao;
import com.cn.dbc.BaseDao;

/**
 * 学期类接口实现类
 * @author Sherlock
 *
 */
public class TermDaoImpl implements ITermDao {
	BaseDao bd = new BaseDao();

	@Override
	public Term findTermById(int id) {
		String sql = "select * from term where id = ?";
		return (Term)bd.query(sql, Term.class, id).get(0);
	}

	@Override
	public Map<Integer, Term> findAllTerm() {
		String sql = "select * from term";
		return bd.query(sql, Term.class);
	}

}
