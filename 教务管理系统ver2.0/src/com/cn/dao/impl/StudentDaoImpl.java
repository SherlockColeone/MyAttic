package com.cn.dao.impl;

import java.util.Map;

import com.cn.bean.Student;
import com.cn.dao.IStudentDao;
import com.cn.dbc.BaseDao;

/**
 * 学生类接口实现类
 * @author Sherlock
 *
 */
public class StudentDaoImpl implements IStudentDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doStudent(Student vo) {
		String sql = "insert into student(id,name,sex,phone,idcard,birth,password,address,birthplace,regist,"
				+ "academyid,majorid,classesid,identity) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),
			vo.getAddress(),vo.getBirthplace(),vo.getRegist(),vo.getAcademyid(),vo.getMajorid(),vo.getClassesid(),vo.getIdentity());
	}

	@Override
	public int delStudentById(int id) {
		String sql = "delete from student where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateStudent(Student vo) {
		String sql = "update student set name=?,sex=?,phone=?,idcard=?,birth=?,password=?,address=?,birthplace=?,"
				+ "regist=?,academyid=?,majorid=?,classesid=?,identity=? where id=?";
		return bd.update(sql,vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),vo.getAddress(),
			vo.getBirthplace(),vo.getRegist(),vo.getAcademyid(),vo.getMajorid(),vo.getClassesid(),vo.getIdentity(),vo.getId());
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "select * from student where id = ?";
		return (Student)bd.query(sql, Student.class, id).get(0);
	}

	@Override
	public Map<Integer, Student> findAllStudentByClassesid(int classesid) {
		String sql = "select * from student where classesid = ?";
		return bd.query(sql, Student.class, classesid);
	}

	@Override
	public int updatePasswordById(int id,String pwd) {
		String sql = "update student set password=? where id=?";
		return bd.update(sql,pwd,id);
	}

	@Override
	public int updateInitPasswordById(int id) {
		String sql = "update student set password = '123456' where id = ?";
		return bd.update(sql,id);
	}

	@Override
	public Student findStudentByIdAndPwd(int id, String pwd) {
		String sql = "select * from student where id = ? and password = ?";
		return (Student)bd.query(sql, Student.class, id,pwd).get(0);
	}

}
