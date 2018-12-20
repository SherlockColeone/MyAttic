package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.StuScore;
import com.cn.dao.IStuScoreDao;
import com.cn.dbc.BaseDao;

/**
 * 学生成绩类接口实现类
 * @author Sherlock
 *
 */
public class StuScoreDaoImpl implements IStuScoreDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doStuScore(StuScore vo) {
		String sql = "insert into stuscore(id,studentid,coursesname,score,credit,point,termid,coursesid,electiveid)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getStudentid(),vo.getCoursesname(),vo.getScore(),vo.getCredit(),vo.getPoint(),
				vo.getTermid(),vo.getCoursesid(),vo.getElectiveid());
	}

	@Override
	public int delStuScoreById(int id) {
		String sql = "delete from stuscore where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateStuScore(StuScore vo) {
		String sql = "update stuscore set studentid=?,coursesname=?,score=?,credit=?,point=?,termid=?,coursesid=?,"
				+ "electiveid=? where id=?";
		return bd.update(sql,vo.getStudentid(),vo.getCoursesname(),vo.getScore(),vo.getCredit(),vo.getPoint(),
				vo.getTermid(),vo.getCoursesid(),vo.getElectiveid(),vo.getId());
	}

	@Override
	public StuScore findStuScoreById(int id) {
		String sql = "select * from stuscore where id = ?";
		return (StuScore)bd.query(sql, StuScore.class, id).get(0);
	}

	@Override
	public Map<Integer, StuScore> findAllStuScore() {
		String sql = "select * from stuscore";
		return bd.query(sql, StuScore.class);
	}

	@Override
	public Map<Integer, StuScore> findAllStuScoreByTermidAndStudentid(int termid, int studentid) {
		String sql = "select * from stuscore where termid = ? and studentid = ?";
		return bd.query(sql, StuScore.class, termid,studentid);
	}

	@Override
	public Map<Integer, StuScore> findAllStuScoreByCoursesid(int coursesid) {
		String sql = "select * from stuscore where coursesid = ? ";
		return bd.query(sql, StuScore.class, coursesid);
	}

	@Override
	public Map<Integer, StuScore> findAllStuScoreByElectiveid(int electiveid) {
		String sql = "select * from stuscore where electiveid = ? ";
		return bd.query(sql, StuScore.class, electiveid);
	}

}
