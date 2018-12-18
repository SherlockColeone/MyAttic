package com.cn.dao.impl;

import java.util.Map;

import com.cn.bean.GradeCet;
import com.cn.dao.IGradeCetDao;
import com.cn.dbc.BaseDao;

/**
 * 社会考试成绩类接口实现类
 * @author Sherlock
 *
 */
public class GradeCetDaoImpl implements IGradeCetDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doGradeCet(GradeCet vo) {
		String sql = "insert into gradecet(id,studentid,cetid,cettime,cetscore,classroomid)"
				+ "values(?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getStudentid(),vo.getCetid(),vo.getCettime(),vo.getCetscore(),vo.getClassroomid());
	}

	@Override
	public int delGradeCetById(int id) {
		String sql = "delete from gradecet where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateGradeCet(GradeCet vo) {
		String sql = "update gradecet set studentid=?,cetid=?,cettime=?,cetscore=?,classroomid=? where id=?";
		return bd.update(sql,vo.getStudentid(),vo.getCetid(),vo.getCettime(),vo.getCetscore(),vo.getClassroomid(),vo.getId());
	}

	@Override
	public GradeCet findGradeCetById(int id) {
		String sql = "select * from gradecet where id = ?";
		return (GradeCet)bd.query(sql, GradeCet.class, id).get(0);
	}

	@Override
	public Map<Integer, GradeCet> findAllGradeCet() {
		String sql = "select * from gradecet";
		return bd.query(sql, GradeCet.class);
	}

	@Override
	public Map<Integer, GradeCet> findAllGradeCetByStudentid(int studentid) {
		String sql = "select * from gradecet where studentid = ? ";
		return bd.query(sql, GradeCet.class, studentid);
	}
	
	@Override
	public GradeCet findGradeCetByStudentidAndCetid(int studentid, int cetid) {
		String sql = "select * from gradecet where studentid = ? and cetid = ?";
		return (GradeCet)bd.query(sql, GradeCet.class, studentid).get(0);
	}

	@Override
	public Map<Integer, GradeCet> findAllGradeCetByClassroomid(int classroomid) {
		String sql = "select * from gradecet where classroomid = ? ";
		return bd.query(sql, GradeCet.class, classroomid);
	}

	@Override
	public Map<Integer, GradeCet> findAllGradeCetByTeacherid(int teacherid) {
		String sql = "select * from gradecet where teacherid = ? ";
		return bd.query(sql, GradeCet.class, teacherid);
	}

}
