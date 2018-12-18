package com.cn.dao.impl;

import java.util.Map;

import com.cn.bean.Teacher;
import com.cn.dao.ITeacherDao;
import com.cn.dbc.BaseDao;

/**
 * 教师类接口实现类
 * @author Sherlock
 *
 */
public class TeacherDaoImpl implements ITeacherDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doTeacher(Teacher vo) {
		String sql = "insert into teacher(id,name,sex,phone,idcard,birth,password,address,birthplace,entrytime,"
				+ "position,academyid,identity) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),
			vo.getAddress(),vo.getBirthplace(),vo.getEntrytime(),vo.getPosition(),vo.getAcademyid(),vo.getIdentity());
	}

	@Override
	public int delTeacherById(int id) {
		String sql = "delete from teacher where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateTeacher(Teacher vo) {
		String sql = "update teacher set name=?,sex=?,phone=?,idcard=?,birth=?,password=?,address=?,birthplace=?,"
				+ "entrytime=?,position=?,academyid=?,identity=? where id=?";
		return bd.update(sql,vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),vo.getAddress(),
			vo.getBirthplace(),vo.getEntrytime(),vo.getPosition(),vo.getAcademyid(),vo.getIdentity(),vo.getId());
	}

	@Override
	public Teacher findTeacherById(int id) {
		String sql = "select * from teacher where id = ?";
		return (Teacher)bd.query(sql, Teacher.class, id).get(0);
	}

	@Override
	public Map<Integer, Teacher> findAllTeacherByAcademyid(int academyid) {
		String sql = "select * from teacher where academyid = ?";
		return bd.query(sql, Teacher.class, academyid);
	}

	@Override
	public int updatePasswordById(int id,String pwd) {
		String sql = "update teacher set password=? where id=?";
		return bd.update(sql,pwd,id);
	}

	@Override
	public int updateInitPasswordById(int id) {
		String sql = "update teacher set password = '123456' where id = ?";
		return bd.update(sql,id);
	}

	@Override
	public Teacher findTeacherByIdAndPwd(int id, String pwd) {
		String sql = "select * from teacher where id = ? and password = ?";
		return (Teacher)bd.query(sql, Teacher.class, id, pwd).get(0);
	}

}
