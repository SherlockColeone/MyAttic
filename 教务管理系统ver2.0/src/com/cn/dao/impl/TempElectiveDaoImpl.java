package com.cn.dao.impl;

import java.util.Map;

import com.cn.bean.TempElective;
import com.cn.dao.ITempElectiveDao;
import com.cn.dbc.BaseDao;

/**
 * 选课报名记录类接口实现类
 * @author Sherlock
 *
 */
public class TempElectiveDaoImpl implements ITempElectiveDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doTempElective(TempElective vo) {
		String sql = "insert into tempelective(id,electiveid,studentid)";
		return bd.update(sql,vo.getId(),vo.getElectiveid(),vo.getStudentid());
	}

	@Override
	public int delTempElectiveById(int id) {
		String sql = "delete from tempelective where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateTempElective(TempElective vo) {
		String sql = "update tempelective set electiveid=?,studentid=? where id=?";
		return bd.update(sql,vo.getElectiveid(),vo.getStudentid(),vo.getId());
	}

	@Override
	public TempElective findTempElectiveById(int id) {
		String sql = "select * from tempelective where id = ?";
		return (TempElective)bd.query(sql, TempElective.class, id).get(0);
	}

	@Override
	public Map<Integer, TempElective> findAllTempElective() {
		String sql = "select * from tempelective";
		return bd.query(sql, TempElective.class);
	}

	@Override
	public Map<Integer, TempElective> findAllTempElectiveByStudentid(int studentid) {
		String sql = "select * from tempelective where studentid = ? ";
		return bd.query(sql, TempElective.class, studentid);
	}

	@Override
	public Map<Integer, TempElective> findAllTempElectiveByElectiveid(int electiveid) {
		String sql = "select * from tempelective where electiveid = ? ";
		return bd.query(sql, TempElective.class, electiveid);
	}

}
