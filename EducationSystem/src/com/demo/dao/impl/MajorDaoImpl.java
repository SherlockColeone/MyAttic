package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Major;
import com.cn.dao.IMajorDao;
import com.cn.dbc.BaseDao;

/**
 * 专业类接口实现类
 * @author Sherlock
 *
 */
public class MajorDaoImpl implements IMajorDao {
	BaseDao bd = new BaseDao();

	@Override
	public Major findMajorById(int id) {
		String sql = "select * from major where id = ?";
		return (Major)bd.query(sql, Major.class, id).get(0);
	}

	@Override
	public Map<Integer, Major> findAllMajorByAcademyId(int academyid) {
		String sql = "select * from major where academyid = ?";
		return bd.query(sql, Major.class, academyid);
	}

	@Override
	public Map<Integer, Major> findAllMajor() {
		String sql = "select * from major";
		return bd.query(sql, Major.class);
	}

	@Override
	public int doMajor(Major vo) {
		String sql = "insert into major(id,name,academyid) values(?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getAcademyid());
	}

	@Override
	public int delMajorById(int id) {
		String sql = "delete from major where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateMajor(Major vo) {
		String sql = "update major set name=?,academyid=? where id=?";
		return bd.update(sql,vo.getName(),vo.getAcademyid(),vo.getId());
	}

}
