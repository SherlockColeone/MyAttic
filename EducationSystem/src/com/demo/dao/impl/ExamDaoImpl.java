package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Exam;
import com.cn.dao.IExamDao;
import com.cn.dbc.BaseDao;

/**
 * 考试类接口实现类
 * @author Sherlock
 *
 */
public class ExamDaoImpl implements IExamDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doExam(Exam vo) {
		String sql = "insert into exam(id,place,examtime,coursesid,teacherid,classesid)"
				+ "values(?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getPlace(),vo.getExamtime(),vo.getCoursesid(),vo.getTeacherid(),vo.getClassesid());
	}

	@Override
	public int delExamById(int id) {
		String sql = "delete from exam where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateExam(Exam vo) {
		String sql = "update exam set place=?,examtime=?,coursesid=?,teacherid=?,classesid=? where id=?";
		return bd.update(sql,vo.getPlace(),vo.getExamtime(),vo.getCoursesid(),vo.getTeacherid(),vo.getClassesid(),vo.getId());
	}

	@Override
	public Exam findExamById(int id) {
		String sql = "select * from exam where id = ?";
		return (Exam)bd.query(sql, Exam.class, id).get(0);
	}

	@Override
	public Map<Integer, Exam> findAllExam() {
		String sql = "select * from exam";
		return bd.query(sql, Exam.class);
	}

	@Override
	public Map<Integer, Exam> findAllExamByClassesid(int classesid) {
		String sql = "select * from exam where classesid = ? ";
		return bd.query(sql, Exam.class, classesid);
	}

	@Override
	public Map<Integer, Exam> findAllExamByTeacherid(int teacherid) {
		String sql = "select * from exam where teacherid = ? ";
		return bd.query(sql, Exam.class, teacherid);
	}

	@Override
	public int delAllExam() {
		String sql = "delete from exam";
		return bd.update(sql);
	}

}
