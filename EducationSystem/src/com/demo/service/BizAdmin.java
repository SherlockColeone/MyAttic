package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.bean.Admin;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.CurriculumArrange;
import com.cn.bean.Elective;
import com.cn.bean.EnrollCet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.GradeCet;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.dao.IAdminDao;
import com.cn.dao.ICetDao;
import com.cn.dao.IClassesDao;
import com.cn.dao.ICoursesDao;
import com.cn.dao.ICurriculumArrangeDao;
import com.cn.dao.IElectiveDao;
import com.cn.dao.IEnrollCetDao;
import com.cn.dao.IEvaluationDao;
import com.cn.dao.IExamDao;
import com.cn.dao.IGradeCetDao;
import com.cn.dao.IMajorDao;
import com.cn.dao.IStudentDao;
import com.cn.dao.ITeacherDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.dao.impl.CetDaoImpl;
import com.cn.dao.impl.ClassesDaoImpl;
import com.cn.dao.impl.CoursesDaoImpl;
import com.cn.dao.impl.CurriculumArrangeDaoImpl;
import com.cn.dao.impl.ElectiveDaoImpl;
import com.cn.dao.impl.EnrollCetDaoImpl;
import com.cn.dao.impl.EvaluationDaoImpl;
import com.cn.dao.impl.ExamDaoImpl;
import com.cn.dao.impl.GradeCetDaoImpl;
import com.cn.dao.impl.MajorDaoImpl;
import com.cn.dao.impl.StudentDaoImpl;
import com.cn.dao.impl.TeacherDaoImpl;

/**
 * 管理员端逻辑层
 * @author Sherlock
 *
 */
public class BizAdmin {
	IAdminDao adminDao = new AdminDaoImpl();
	IStudentDao studentDao = new StudentDaoImpl();
	ITeacherDao teacherDao = new TeacherDaoImpl();
	ICoursesDao coursesDao = new CoursesDaoImpl();
	IElectiveDao electiveDao = new ElectiveDaoImpl();
	ICurriculumArrangeDao curriculumArrangeDao = new CurriculumArrangeDaoImpl();
	IExamDao examDao = new ExamDaoImpl();
	ICetDao cetDao = new CetDaoImpl();
	IMajorDao majorDao = new MajorDaoImpl();
	IClassesDao classesDao = new ClassesDaoImpl();
	IEnrollCetDao enrollCetDao = new EnrollCetDaoImpl();
	IGradeCetDao gradeCetDao = new GradeCetDaoImpl();
	IEvaluationDao evaluationDao = new EvaluationDaoImpl();
	
	/**
	 * 管理员登录
	 * @param adminid 管理员工号
	 * @param pwd 密码
	 * @return 查询的管理员对象
	 */
	public Admin adminLogin(int adminid,String pwd) {
		return adminDao.findAdminByIdAndPwd(adminid, pwd);
	}
	
	/**
	 * 管理员添加学生学籍信息
	 * @param vo 学生对象
	 * @return 是否添加成功
	 */
	public boolean addStudent(Student vo) {
		if(studentDao.doStudent(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员删除学生学籍信息
	 * @param studentid 学生学号
	 * @return 是否删除成功
	 */
	public boolean delStudentByStudentid(int studentid) {
		if(studentDao.delStudentById(studentid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改学生学籍信息
	 * @param vo 学生对象
	 * @return 是否修改成功
	 */
	public boolean modifyStudent(Student vo) {
		if(studentDao.updateStudent(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据学号查询学生学籍信息
	 * @param studentid 学生学号
	 * @return 学生对象
	 */
	public Student searchStudentByStudentid(int studentid) {
		return studentDao.findStudentById(studentid);
	}
	
	/**
	 * 管理员添加教师信息
	 * @param vo 教师对象
	 * @return 是否添加成功
	 */
	public boolean addTeacher(Teacher vo) {
		if(teacherDao.doTeacher(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员删除教师信息
	 * @param teacherid 教师工号
	 * @return 是否删除成功
	 */
	public boolean delTeacherByTeacherid(int teacherid) {
		if(teacherDao.delTeacherById(teacherid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改教师信息
	 * @param vo 教师对象
	 * @return 是否修改成功
	 */
	public boolean modifyTeacher(Teacher vo) {
		if(teacherDao.updateTeacher(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据工号查询教师信息
	 * @param teacherid 教师工号
	 * @return 教师对象
	 */
	public Teacher searchTeacherByTeacherid(int teacherid) {
		return teacherDao.findTeacherById(teacherid);
	}
	
	/**
	 * 管理员添加管理员信息
	 * @param vo 管理员对象
	 * @return 是否添加成功
	 */
	public boolean addAdmin(Admin vo) {
		if(adminDao.doAdmin(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员删除管理员信息
	 * @param adminid 管理员工号
	 * @return 是否删除成功
	 */
	public boolean delAdminByAdminid(int adminid) {
		if(adminDao.delAdminById(adminid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改管理员信息
	 * @param vo 管理员对象
	 * @return 是否修改成功
	 */
	public boolean modifyAdmin(Admin vo) {
		if(adminDao.updateAdmin(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据工号查询管理员信息
	 * @param adminid 管理员工号
	 * @return 管理员对象
	 */
	public Admin searchAdminByAdminid(int adminid) {
		return adminDao.findAdminById(adminid);
	}
	
	/**
	 * 修改管理员本人密码
	 * @param adminid 管理员id
	 * @param newPwd 新密码
	 * @return 更改的列的数量
	 */
	public int modifyAdminPwd(int adminid,String newPwd) {
		return adminDao.updatePasswordById(adminid, newPwd);
	}
	
	/**
	 * 检验并更改管理员密码
	 * @param adminid 管理员id
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @param rePwd 确认密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明更改的密码与确认密码不符；若返回-2则说明输入的密码与原始密码不符
	 */
	public int checkAndModifyAdminPwd(int adminid,String pwd,String newPwd,String rePwd) {
		//获取该管理员在数据库中的密码
		String password = adminDao.findAdminById(adminid).getPassword();
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
	
	/**
	 * 管理员添加专业课
	 * @param vo 专业课对象
	 * @return 是否成功添加
	 */
	public boolean addCourses(Courses vo) {
		if(coursesDao.doCourses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据专业课id删除专业课
	 * @param coursesid 专业课id
	 * @return 是否删除成功
	 */
	public boolean delCoursesByCoursesid(int coursesid) {
		if(coursesDao.delCoursesById(coursesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改专业课
	 * @param vo 专业课对象
	 * @return 是否修改成功
	 */
	public boolean modifyCourses(Courses vo) {
		if(coursesDao.updateCourses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据专业课id查询专业课
	 * @param coursesid 专业课id
	 * @return 专业课对象
	 */
	public Courses searchCoursesByCoursesid(int coursesid) {
		return coursesDao.findCoursesById(coursesid);
	}
	
	/**
	 * 管理员添加选修课
	 * @param vo 选修课对象
	 * @return 是否成功添加
	 */
	public boolean addElective(Elective vo) {
		if(electiveDao.doElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据选修课id删除选修课
	 * @param electiveid 选修课id
	 * @return 是否删除成功
	 */
	public boolean delElectiveByElectiveid(int electiveid) {
		if(electiveDao.delElectiveById(electiveid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改选修课
	 * @param vo 选修课对象
	 * @return 是否修改成功
	 */
	public boolean modifyElective(Elective vo) {
		if(electiveDao.updateElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据选修课id查询选修课
	 * @param electiveid 选修课id
	 * @return 选修课对象
	 */
	public Elective searchElectiveByElectiveid(int electiveid) {
		return electiveDao.findElectiveById(electiveid);
	}
	
	/**
	 * 管理员修改调课安排
	 * @param vo 调课安排对象
	 * @return 是否修改成功
	 */
	public boolean modifyCurriculumArrange(CurriculumArrange vo) {
		if(curriculumArrangeDao.updateCurriculumArrange(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据调课id查询调课安排
	 * @param coursesid 专业课id
	 * @return 专业课对象
	 */
	public CurriculumArrange searchCurriculumArrangeByCurriculumArrangeid(int curriculumArrangeid) {
		return curriculumArrangeDao.findCurriculumArrangeById(curriculumArrangeid);
	}
	
	/**
	 * 管理员添加考试
	 * @param vo 考试对象
	 * @return 是否成功添加
	 */
	public boolean addExam(Exam vo) {
		if(examDao.doExam(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据考试id删除考试
	 * @param examid 考试id
	 * @return 是否删除成功
	 */
	public boolean delExamByExamid(int examid) {
		if(examDao.delExamById(examid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员清除本次所有考试
	 * @return 是否清除成功
	 */
	public boolean clearAllExam() {
		if(examDao.delAllExam()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改考试
	 * @param vo 考试对象
	 * @return 是否修改成功
	 */
	public boolean modifyExam(Exam vo) {
		if(examDao.updateExam(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据考试id查询考试
	 * @param examid 考试id
	 * @return 考试对象
	 */
	public Exam searchExamByExamid(int examid) {
		return examDao.findExamById(examid);
	}
	
	/**
	 * 管理员添加专业
	 * @param vo 专业对象
	 * @return 是否成功添加
	 */
	public boolean addMajor(Major vo) {
		if(majorDao.doMajor(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据专业id删除专业
	 * @param majorid 专业id
	 * @return 是否删除成功
	 */
	public boolean delMajorByMajorid(int majorid) {
		if(majorDao.delMajorById(majorid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改专业
	 * @param vo 专业对象
	 * @return 是否修改成功
	 */
	public boolean modifyMajor(Major vo) {
		if(majorDao.updateMajor(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据专业id查询专业
	 * @param majorid 专业id
	 * @return 专业对象
	 */
	public Major searchMajorByMajorid(int majorid) {
		return majorDao.findMajorById(majorid);
	}
	
	/**
	 * 管理员添加班级
	 * @param vo 班级对象
	 * @return 是否成功添加
	 */
	public boolean addClasses(Classes vo) {
		if(classesDao.doClasses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据班级id删除班级
	 * @param cetid 班级id
	 * @return 是否删除成功
	 */
	public boolean delClassesByClassesid(int classesid) {
		if(classesDao.delClassesById(classesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改班级
	 * @param vo 班级对象
	 * @return 是否修改成功
	 */
	public boolean modifyClasses(Classes vo) {
		if(classesDao.updateClasses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据班级编号查询班级
	 * @param classesid 班级编号
	 * @return 班级对象
	 */
	public Classes searchClassesByClassesid(int classesid) {
		return classesDao.findClassesById(classesid);
	}
	
	/**
	 * 管理员添加社会考试
	 * @param vo 社会考试对象
	 * @return 是否成功添加
	 */
	public boolean addCet(Cet vo) {
		if(cetDao.doCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据社会考试id删除社会考试
	 * @param cetid 社会考试id
	 * @return 是否删除成功
	 */
	public boolean delCetByCetid(int cetid) {
		if(cetDao.delCetById(cetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改社会考试
	 * @param vo 社会考试对象
	 * @return 是否修改成功
	 */
	public boolean modifyCet(Cet vo) {
		if(cetDao.updateCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据社会考试id查询社会考试
	 * @param cetid 社会考试id
	 * @return 社会考试对象
	 */
	public Cet searchCetByCetid(int cetid) {
		return cetDao.findCetById(cetid);
	}
	
	/**
	 * 管理员查询某一次社会考试的所有社会考试报名
	 * @param cetid 社会考试id
	 * @return 社会考试报名集合
	 */
	public Map<Integer,EnrollCet> searchAllEnrollCetByCetid(int cetid){
		return enrollCetDao.findAllEnrollCetByCetid(cetid);
	}
	
	/**
	 * 管理员查询某一次社会考试所有报名的学生学号
	 * @param cetid 社会考试id
	 * @return 社会考试报名集合
	 */
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid){
		List<Integer> listStudentid = new ArrayList<>();
		Map<Integer,EnrollCet> mapEnrollCet = searchAllEnrollCetByCetid(cetid);
		for (EnrollCet enrollCet : mapEnrollCet.values()) {
			listStudentid.add(enrollCet.getStudentid());
		}
		return listStudentid;
	}
	
	/**
	 * 管理员添加社会考试成绩
	 * @param vo 社会考试成绩对象
	 * @return 是否成功添加
	 */
	public boolean addGradeCet(GradeCet vo) {
		if(gradeCetDao.doGradeCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据社会考试成绩id删除社会考试成绩
	 * @param cetid 社会考试成绩id
	 * @return 是否删除成功
	 */
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		if(gradeCetDao.delGradeCetById(gardecetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改社会考试成绩
	 * @param vo 社会考试成绩对象
	 * @return 是否修改成功
	 */
	public boolean modifyGradeCet(GradeCet vo) {
		if(gradeCetDao.updateGradeCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员添加教学评价
	 * @param vo 教学评价对象
	 * @return 是否成功添加
	 */
	public boolean addEvaluation(Evaluation vo) {
		if(evaluationDao.doEvaluation(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据教学评价id删除教学评价
	 * @param cetid 教学评价id
	 * @return 是否删除成功
	 */
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		if(evaluationDao.delEvaluationById(evaluationid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员修改教学评价
	 * @param vo 教学评价对象
	 * @return 是否修改成功
	 */
	public boolean modifyEvaluation(Evaluation vo) {
		if(evaluationDao.updateEvaluation(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 管理员根据教学评价id查询教学评价
	 * @param evaluationid 教学评价id
	 * @return 教学评价对象
	 */
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		return evaluationDao.findEvaluationById(evaluationid);
	}
	
}
