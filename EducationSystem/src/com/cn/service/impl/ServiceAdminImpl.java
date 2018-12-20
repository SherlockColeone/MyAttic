package com.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Admin;
import com.cn.bean.AdminExample;
import com.cn.bean.AdminExample.Criteria;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.dao.AdminMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.TeacherMapper;
import com.cn.service.ServiceAdmin;

/**
 * 	管理员端逻辑层实现类
 * @author Sherlock
 *
 */
@Service
public class ServiceAdminImpl implements ServiceAdmin {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public Admin adminLogin(int adminid, String password) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(adminid);
		criteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public boolean addStudent(Student vo) {
		if(studentMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delStudentByStudentid(int studentid) {
		if(studentMapper.deleteByPrimaryKey(studentid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyStudent(Student vo) {
		if(studentMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student searchStudentByStudentid(int studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
	}

	@Override
	public boolean addTeacher(Teacher vo) {
		if(teacherMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delTeacherByTeacherid(int teacherid) {
		if(teacherMapper.deleteByPrimaryKey(teacherid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyTeacher(Teacher vo) {
		if(teacherMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Teacher searchTeacherByTeacherid(int teacherid) {
		return teacherMapper.selectByPrimaryKey(teacherid);
	}

	@Override
	public boolean addAdmin(Admin vo) {
		
		return false;
	}

	@Override
	public boolean delAdminByAdminid(int adminid) {
		
		return false;
	}

	@Override
	public boolean modifyAdmin(Admin vo) {
		
		return false;
	}

	@Override
	public Admin searchAdminByAdminid(int adminid) {
		
		return null;
	}

	@Override
	public int modifyAdminPwd(int adminid, String newPwd) {
		
		return 0;
	}

	@Override
	public int checkAndModifyAdminPwd(int adminid, String pwd, String newPwd, String rePwd) {
		
		return 0;
	}

	@Override
	public boolean addCourses(Courses vo) {
		
		return false;
	}

	@Override
	public boolean delCoursesByCoursesid(int coursesid) {
		
		return false;
	}

	@Override
	public boolean modifyCourses(Courses vo) {
		
		return false;
	}

	@Override
	public Courses searchCoursesByCoursesid(int coursesid) {
		
		return null;
	}

	@Override
	public boolean addElective(Elective vo) {
		
		return false;
	}

	@Override
	public boolean delElectiveByElectiveid(int electiveid) {
		
		return false;
	}

	@Override
	public boolean modifyElective(Elective vo) {
		
		return false;
	}

	@Override
	public Elective searchElectiveByElectiveid(int electiveid) {
		
		return null;
	}

	@Override
	public boolean modifyCurriculumArrange(Curriculumarrange vo) {
		
		return false;
	}

	@Override
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid) {
		
		return null;
	}

	@Override
	public boolean addExam(Exam vo) {
		
		return false;
	}

	@Override
	public boolean delExamByExamid(int examid) {
		
		return false;
	}

	@Override
	public boolean clearAllExam() {
		
		return false;
	}

	@Override
	public boolean modifyExam(Exam vo) {
		
		return false;
	}

	@Override
	public Exam searchExamByExamid(int examid) {
		
		return null;
	}

	@Override
	public boolean addMajor(Major vo) {
		
		return false;
	}

	@Override
	public boolean delMajorByMajorid(int majorid) {
		
		return false;
	}

	@Override
	public boolean modifyMajor(Major vo) {
		
		return false;
	}

	@Override
	public Major searchMajorByMajorid(int majorid) {
		
		return null;
	}

	@Override
	public boolean addClasses(Classes vo) {
		
		return false;
	}

	@Override
	public boolean delClassesByClassesid(int classesid) {
		
		return false;
	}

	@Override
	public boolean modifyClasses(Classes vo) {
		
		return false;
	}

	@Override
	public Classes searchClassesByClassesid(int classesid) {
		
		return null;
	}

	@Override
	public boolean addCet(Cet vo) {
		
		return false;
	}

	@Override
	public boolean delCetByCetid(int cetid) {
		
		return false;
	}

	@Override
	public boolean modifyCet(Cet vo) {
		
		return false;
	}

	@Override
	public Cet searchCetByCetid(int cetid) {
		
		return null;
	}

	@Override
	public Map<Integer, Enrollcet> searchAllEnrollcetByCetid(int cetid) {
		
		return null;
	}

	@Override
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid) {
		
		return null;
	}

	@Override
	public boolean addGradeCet(Gradecet vo) {
		
		return false;
	}

	@Override
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		
		return false;
	}

	@Override
	public boolean modifyGradeCet(Gradecet vo) {
		
		return false;
	}

	@Override
	public boolean addEvaluation(Evaluation vo) {
		
		return false;
	}

	@Override
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		
		return false;
	}

	@Override
	public boolean modifyEvaluation(Evaluation vo) {
		
		return false;
	}

	@Override
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		
		return null;
	}

}
