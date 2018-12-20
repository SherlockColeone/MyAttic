package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Classes;
import com.cn.dao.IClassesDao;
import com.cn.dbc.BaseDao;

/**
 * 班级类接口实现类
 * @author Sherlock
 *
 */
public class ClassesDaoImpl implements IClassesDao {
	BaseDao bd = new BaseDao();

	@Override
	public Classes findClassesById(int id) {
		String sql = "select * from classes where id = ?";
		return (Classes)bd.query(sql, Classes.class, id).get(0);
	}

	@Override
	public Map<Integer, Classes> findAllClassesByMajorId(int majorid) {
		String sql = "select * from classes where majorid = ?";
		return bd.query(sql, Classes.class, majorid);
	}

	@Override
	public Map<Integer, Classes> findAllClasses() {
		String sql = "select * from classes";
		return bd.query(sql, Classes.class);
	}

	@Override
	public int doClasses(Classes vo) {
		String sql = "insert into classes(id,name,majorid) values(?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getMajorid());
	}

	@Override
	public int delClassesById(int id) {
		String sql = "delete from classes where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateClasses(Classes vo) {
		String sql = "update classes set name=?,majorid=? where id=?";
		return bd.update(sql,vo.getName(),vo.getMajorid(),vo.getId());
	}

}
