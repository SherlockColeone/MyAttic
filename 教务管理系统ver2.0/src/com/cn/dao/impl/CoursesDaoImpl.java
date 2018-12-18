package com.cn.dao.impl;

import java.util.Map;

import com.cn.bean.Courses;
import com.cn.dao.ICoursesDao;
import com.cn.dbc.BaseDao;

/**
 * 专业课程类接口实现类
 * @author Sherlock
 *
 */
public class CoursesDaoImpl implements ICoursesDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doCourses(Courses vo) {
		String sql = "insert into courses(id,name,week,day,time,place,teacher,classesid,termid,teacherid)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getWeek(),vo.getDay(),vo.getTime(),vo.getPlace(),vo.getTeacher(),
			vo.getClassesid(),vo.getTermid(),vo.getTeacherid());
	}

	@Override
	public int delCoursesById(int id) {
		String sql = "delete from courses where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateCourses(Courses vo) {
		String sql = "update courses set name=?,week=?,day=?,time=?,place=?,teacher=?,classesid=?,teacherid=? where id=?";
		return bd.update(sql,vo.getName(),vo.getWeek(),vo.getDay(),vo.getTime(),vo.getPlace(),vo.getTeacher(),
				vo.getClassesid(),vo.getTermid(),vo.getTeacherid(),vo.getId());
	}

	@Override
	public Courses findCoursesById(int id) {
		String sql = "select * from courses where id = ?";
		return (Courses)bd.query(sql, Courses.class, id).get(0);
	}

	@Override
	public Map<Integer, Courses> findAllCourses() {
		String sql = "select * from courses";
		return bd.query(sql, Courses.class);
	}

	@Override
	public Map<Integer, Courses> findAllCoursesByTermidAndClassesId(int termid, int classesid) {
		String sql = "select * from courses where termid = ? and classesid = ?";
		return bd.query(sql, Courses.class, termid, classesid);
	}

	@Override
	public Map<Integer, Courses> findAllCoursesByTermidAndTeacherid(int termid, int teacherid) {
		String sql = "select * from courses where termid = ? and teacherid = ?";
		return bd.query(sql, Courses.class, termid, teacherid);
	}

}
