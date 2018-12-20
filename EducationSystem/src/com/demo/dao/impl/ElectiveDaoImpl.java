package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Elective;
import com.cn.dao.IElectiveDao;
import com.cn.dbc.BaseDao;

/**
 * 选修课程类接口实现类
 * @author Sherlock
 *
 */
public class ElectiveDaoImpl implements IElectiveDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doElective(Elective vo) {
		String sql = "insert into elective(id,name,week,day,time,place,teacher,termid,teacherid)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getWeek(),vo.getDay(),vo.getTime(),vo.getPlace(),vo.getTeacher(),
			vo.getTermid(),vo.getTeacherid());
	}

	@Override
	public int delElectiveById(int id) {
		String sql = "delete from elective where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateElective(Elective vo) {
		String sql = "update elective set name=?,week=?,day=?,time=?,place=?,teacher=?,teacherid=? where id=?";
		return bd.update(sql,vo.getName(),vo.getWeek(),vo.getDay(),vo.getTime(),vo.getPlace(),vo.getTeacher(),
				vo.getTermid(),vo.getTeacherid(),vo.getId());
	}

	@Override
	public Elective findElectiveById(int id) {
		String sql = "select * from elective where id = ?";
		return (Elective)bd.query(sql, Elective.class, id).get(0);
	}

	@Override
	public Map<Integer, Elective> findAllElective() {
		String sql = "select * from elective";
		return bd.query(sql, Elective.class);
	}

	@Override
	public Map<Integer, Elective> findAllElectiveByTermidAndTeacherid(int termid, int teacherid) {
		String sql = "select * from elective where termid = ? and teacherid = ?";
		return bd.query(sql, Elective.class, termid, teacherid);
	}

	@Override
	public Map<Integer, Elective> findAllElectiveByTermid(int termid) {
		String sql = "select * from elective where termid = ? ";
		return bd.query(sql, Elective.class, termid);
	}

}
