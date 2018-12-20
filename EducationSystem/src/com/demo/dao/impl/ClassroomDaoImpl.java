package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Classroom;
import com.cn.dao.IClassroomDao;
import com.cn.dbc.BaseDao;

/**
 * 课室类接口实现类
 * @author Sherlock
 *
 */
public class ClassroomDaoImpl implements IClassroomDao {
	BaseDao bd = new BaseDao();

	@Override
	public Classroom findClassroomById(int id) {
		String sql = "select * from classroom where id = ?";
		return (Classroom)bd.query(sql, Classroom.class, id).get(0);
	}

	@Override
	public Map<Integer, Classroom> findAllClassroom() {
		String sql = "select * from classroom";
		return bd.query(sql, Classroom.class);
	}

}
