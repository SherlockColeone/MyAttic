package com.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.cn.bean.EnrollcetExample;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.dao.AdminMapper;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EnrollcetMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.MajorMapper;
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
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private EnrollcetMapper enrollcetMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;
	

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
		if(adminMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delAdminByAdminid(int adminid) {
		if(adminMapper.deleteByPrimaryKey(adminid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyAdmin(Admin vo) {
		if(adminMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Admin searchAdminByAdminid(int adminid) {
		return adminMapper.selectByPrimaryKey(adminid);
	}

	@Override
	public int modifyAdminPwd(int adminid, String newPwd) {
		Admin record = new Admin();
		record.setId(adminid);
		record.setPassword(newPwd);
		return adminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAndModifyAdminPwd(int adminid, String pwd, String newPwd, String rePwd) {
		//获取该管理员在数据库中的密码
		String password = adminMapper.selectByPrimaryKey(adminid).getPassword();
		if(pwd!=password) { //输入的密码与原始密码不符
			return -2;
		}
		else if(newPwd!=rePwd){ //更改的密码与确认密码不符
			return -1;
		}
		else {
			return modifyAdminPwd(adminid, newPwd);
		}
	}

	@Override
	public boolean addCourses(Courses vo) {
		if(coursesMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delCoursesByCoursesid(int coursesid) {
		if(coursesMapper.deleteByPrimaryKey(coursesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyCourses(Courses vo) {
		if(coursesMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Courses searchCoursesByCoursesid(int coursesid) {
		return coursesMapper.selectByPrimaryKey(coursesid);
	}

	@Override
	public boolean addElective(Elective vo) {		
		if(electiveMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delElectiveByElectiveid(int electiveid) {
		if(electiveMapper.deleteByPrimaryKey(electiveid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyElective(Elective vo) {
		if(electiveMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Elective searchElectiveByElectiveid(int electiveid) {
		return electiveMapper.selectByPrimaryKey(electiveid);
	}

	@Override
	public boolean modifyCurriculumArrange(Curriculumarrange vo) {
		if(curriculumarrangeMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid) {
		return curriculumarrangeMapper.selectByPrimaryKey(curriculumarrangeid);
	}

	@Override
	public boolean addExam(Exam vo) {		
		if(examMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delExamByExamid(int examid) {
		if(examMapper.deleteByPrimaryKey(examid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean clearAllExam() {
		ExamExample example = new ExamExample();
		if(examMapper.deleteByExample(example)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyExam(Exam vo) {
		if(examMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Exam searchExamByExamid(int examid) {
		return examMapper.selectByPrimaryKey(examid);
	}

	@Override
	public boolean addMajor(Major vo) {	
		if(majorMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delMajorByMajorid(int majorid) {
		if(majorMapper.deleteByPrimaryKey(majorid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyMajor(Major vo) {
		if(majorMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Major searchMajorByMajorid(int majorid) {
		return majorMapper.selectByPrimaryKey(majorid);
	}

	@Override
	public boolean addClasses(Classes vo) {
		if(classesMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delClassesByClassesid(int classesid) {
		if(classesMapper.deleteByPrimaryKey(classesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyClasses(Classes vo) {
		if(classesMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Classes searchClassesByClassesid(int classesid) {
		return classesMapper.selectByPrimaryKey(classesid);
	}

	@Override
	public boolean addCet(Cet vo) {
		if(cetMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delCetByCetid(int cetid) {
		if(cetMapper.deleteByPrimaryKey(cetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyCet(Cet vo) {
		if(cetMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Cet searchCetByCetid(int cetid) {
		return cetMapper.selectByPrimaryKey(cetid);
	}

	@Override
	public List<Enrollcet> searchAllEnrollcetByCetid(int cetid) {
		EnrollcetExample example = new EnrollcetExample();
		com.cn.bean.EnrollcetExample.Criteria criteria = example.createCriteria();
		criteria.andCetidEqualTo(cetid);
		return enrollcetMapper.selectByExample(example);
	}

	@Override
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid) {
		List<Integer> listStudentid = new ArrayList<>();
		List<Enrollcet> listEnrollcet = searchAllEnrollcetByCetid(cetid);
		for (Enrollcet enrollcet : listEnrollcet) {
			listStudentid.add(enrollcet.getStudentid());
		}
		return listStudentid;
	}

	@Override
	public boolean addGradeCet(Gradecet vo) {
		if(gradecetMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		if(gradecetMapper.deleteByPrimaryKey(gardecetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyGradeCet(Gradecet vo) {
		if(gradecetMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addEvaluation(Evaluation vo) {
		if(evaluationMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		if(evaluationMapper.deleteByPrimaryKey(evaluationid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyEvaluation(Evaluation vo) {
		if(evaluationMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		return evaluationMapper.selectByPrimaryKey(evaluationid);
	}

}
