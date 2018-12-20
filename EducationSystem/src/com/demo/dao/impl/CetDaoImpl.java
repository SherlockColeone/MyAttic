package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Cet;
import com.cn.dao.ICetDao;
import com.cn.dbc.BaseDao;

/**
 * 社会考试类接口实现类
 * @author Sherlock
 *
 */
public class CetDaoImpl implements ICetDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doCet(Cet vo) {
		String sql = "insert into cet(id,cetname,cettime) values(?,?,?)";
		return bd.update(sql,vo.getId(),vo.getCetname(),vo.getCettime());
	}

	@Override
	public int delCetById(int id) {
		String sql = "delete from cet where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateCet(Cet vo) {
		String sql = "update cet set cetname=?,cettime=? where id=?";
		return bd.update(sql,vo.getCetname(),vo.getCettime(),vo.getId());
	}

	@Override
	public Cet findCetById(int id) {
		String sql = "select * from cet where id = ?";
		return (Cet)bd.query(sql, Cet.class, id).get(0);
	}

	@Override
	public Map<Integer, Cet> findAllCet() {
		String sql = "select * from cet";
		return bd.query(sql, Cet.class);
	}

	@Override
	public Map<Integer, Cet> findAllCetByTermid(int termid) {
		String sql = "select * from cet where termid = ?";
		return bd.query(sql, Cet.class,termid);
	}

}
