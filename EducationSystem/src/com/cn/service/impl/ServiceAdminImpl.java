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
		
		return false;
	}

	@Override
	public boolean delStudentByStudentid(int studentid) {
		
		return false;
	}

	@Override
	public boolean modifyStudent(Student vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student searchStudentByStudentid(int studentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTeacher(Teacher vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTeacherByTeacherid(int teacherid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyTeacher(Teacher vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Teacher searchTeacherByTeacherid(int teacherid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAdmin(Admin vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delAdminByAdminid(int adminid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyAdmin(Admin vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin searchAdminByAdminid(int adminid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyAdminPwd(int adminid, String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkAndModifyAdminPwd(int adminid, String pwd, String newPwd, String rePwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addCourses(Courses vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delCoursesByCoursesid(int coursesid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCourses(Courses vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Courses searchCoursesByCoursesid(int coursesid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addElective(Elective vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delElectiveByElectiveid(int electiveid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyElective(Elective vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Elective searchElectiveByElectiveid(int electiveid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyCurriculumArrange(Curriculumarrange vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addExam(Exam vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delExamByExamid(int examid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearAllExam() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyExam(Exam vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Exam searchExamByExamid(int examid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMajor(Major vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delMajorByMajorid(int majorid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMajor(Major vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Major searchMajorByMajorid(int majorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addClasses(Classes vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delClassesByClassesid(int classesid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyClasses(Classes vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classes searchClassesByClassesid(int classesid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCet(Cet vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delCetByCetid(int cetid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCet(Cet vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cet searchCetByCetid(int cetid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Enrollcet> searchAllEnrollcetByCetid(int cetid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGradeCet(Gradecet vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGradeCet(Gradecet vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvaluation(Evaluation vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEvaluation(Evaluation vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		// TODO Auto-generated method stub
		return null;
	}

}
