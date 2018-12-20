package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.EnrollCet;
import com.cn.dao.IEnrollCetDao;
import com.cn.dbc.BaseDao;

/**
 * 社会考试报名报名类接口实现类
 * @author Sherlock
 *
 */
public class EnrollCetDaoImpl implements IEnrollCetDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doEnrollCet(EnrollCet vo) {
		String sql = "insert into enrollcet(id,cetid,studentid)";
		return bd.update(sql,vo.getId(),vo.getCetid(),vo.getStudentid());
	}

	@Override
	public int delEnrollCetById(int id) {
		String sql = "delete from enrollcet where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateEnrollCet(EnrollCet vo) {
		String sql = "update enrollcet set cetid=?,studentid=? where id=?";
		return bd.update(sql,vo.getCetid(),vo.getStudentid(),vo.getId());
	}

	@Override
	public EnrollCet findEnrollCetById(int id) {
		String sql = "select * from enrollcet where id = ?";
		return (EnrollCet)bd.query(sql, EnrollCet.class, id).get(0);
	}

	@Override
	public Map<Integer, EnrollCet> findAllEnrollCet() {
		String sql = "select * from enrollcet";
		return bd.query(sql, EnrollCet.class);
	}

	@Override
	public Map<Integer, EnrollCet> findAllEnrollCetByStudentid(int studentid) {
		String sql = "select * from enrollcet where studentid = ? ";
		return bd.query(sql, EnrollCet.class, studentid);
	}

	@Override
	public EnrollCet findEnrollCetByStudentidAndCetid(int studentid, int cetid) {
		String sql = "select * from enrollcet where studentid = ? and cetid = ?";
		return (EnrollCet)bd.query(sql, EnrollCet.class, studentid,cetid).get(0);
	}

	@Override
	public int delAllEnrollCet() {
		String sql = "delete from enrollcet";
		return bd.update(sql);
	}

	@Override
	public Map<Integer, EnrollCet> findAllEnrollCetByCetid(int cetid) {
		String sql = "select * from enrollcet where cetid = ? ";
		return bd.query(sql, EnrollCet.class, cetid);
	}

}
