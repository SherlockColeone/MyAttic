package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.CurriculumArrange;
import com.cn.dao.ICurriculumArrangeDao;
import com.cn.dbc.BaseDao;

public class CurriculumArrangeDaoImpl implements ICurriculumArrangeDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doCurriculumArrange(CurriculumArrange vo) {
		String sql = "insert into curriculumarrange(id,coursesid,electiveid,week,day,time,place,classesid,teacherid,permit)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getCoursesid(),vo.getElectiveid(),vo.getWeek(),vo.getDay(),vo.getTime(),
				vo.getPlace(),vo.getClassesid(),vo.getTeacherid(),vo.getPermit());
	}

	@Override
	public int delCurriculumArrangeById(int id) {
		String sql = "delete from curriculumarrange where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateCurriculumArrange(CurriculumArrange vo) {
		String sql = "update curriculumarrange set coursesid=?,electiveid=?,week=?,day=?,time=?,place=?,classesid=?,teacherid=?,permit=? where id=?";
		return bd.update(sql,vo.getCoursesid(),vo.getElectiveid(),vo.getWeek(),vo.getDay(),vo.getTime(),vo.getPlace(),
				vo.getClassesid(),vo.getTeacherid(),vo.getPermit(),vo.getId());
	}

	@Override
	public CurriculumArrange findCurriculumArrangeById(int id) {
		String sql = "select * from curriculumarrange where id = ?";
		return (CurriculumArrange)bd.query(sql, CurriculumArrange.class, id).get(0);
	}

	@Override
	public Map<Integer, CurriculumArrange> findAllCurriculumArrange() {
		String sql = "select * from curriculumarrange";
		return bd.query(sql, CurriculumArrange.class);
	}

	@Override
	public Map<Integer, CurriculumArrange> findAllCurriculumArrangeByClassesid(int classesid) {
		String sql = "select * from curriculumarrange where classesid = ?";
		return bd.query(sql, CurriculumArrange.class,classesid);
	}

	@Override
	public Map<Integer, CurriculumArrange> findAllCurriculumArrangeByTeacherid(int teacherid) {
		String sql = "select * from curriculumarrange where teacherid = ?";
		return bd.query(sql, CurriculumArrange.class,teacherid);
	}

	@Override
	public int updatePermitById(int id,int permit) {
		String sql = "update curriculumarrange set permit=? where id=?";
		return bd.update(sql,permit,id);
	}

	@Override
	public int delAllCurriculumArrange() {
		String sql = "delete from curriculumarrange";
		return bd.update(sql);
	}

}
