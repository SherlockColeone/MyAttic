package com.cn.service;

import java.util.List;

import com.cn.bean.Admin;
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

/**
 * 	管理员端逻辑层
 * @author Sherlock
 *
 */
public interface ServiceAdmin {
	
	/**
	 * 	管理员登录
	 * @param adminid 管理员工号
	 * @param password 密码
	 * @return 查询的管理员对象
	 */
	public Admin adminLogin(int adminid,String password);
	
	/**
	 * 	管理员添加学生学籍信息
	 * @param vo 学生对象
	 * @return 是否添加成功
	 */
	public boolean addStudent(Student vo);
	
	/**
	 * 	管理员删除学生学籍信息
	 * @param studentid 学生学号
	 * @return 是否删除成功
	 */
	public boolean delStudentByStudentid(int studentid);
	
	/**
	 *	 管理员修改学生学籍信息
	 * @param vo 学生对象
	 * @return 是否修改成功
	 */
	public boolean modifyStudent(Student vo);
	
	/**
	 * 	管理员根据学号查询学生学籍信息
	 * @param studentid 学生学号
	 * @return 学生对象
	 */
	public Student searchStudentByStudentid(int studentid);
	
	/**
	 * 	管理员添加教师信息
	 * @param vo 教师对象
	 * @return 是否添加成功
	 */
	public boolean addTeacher(Teacher vo);
	
	/**
	 *	 管理员删除教师信息
	 * @param teacherid 教师工号
	 * @return 是否删除成功
	 */
	public boolean delTeacherByTeacherid(int teacherid);
	
	/**
	 * 	管理员修改教师信息
	 * @param vo 教师对象
	 * @return 是否修改成功
	 */
	public boolean modifyTeacher(Teacher vo);
	
	/**
	 * 	管理员根据工号查询教师信息
	 * @param teacherid 教师工号
	 * @return 教师对象
	 */
	public Teacher searchTeacherByTeacherid(int teacherid);
	
	/**
	 * 	管理员添加管理员信息
	 * @param vo 管理员对象
	 * @return 是否添加成功
	 */
	public boolean addAdmin(Admin vo);
	
	/**
	 * 	管理员删除管理员信息
	 * @param adminid 管理员工号
	 * @return 是否删除成功
	 */
	public boolean delAdminByAdminid(int adminid);
	
	/**
	 * 	管理员修改管理员信息
	 * @param vo 管理员对象
	 * @return 是否修改成功
	 */
	public boolean modifyAdmin(Admin vo);
	
	/**
	 * 	管理员根据工号查询管理员信息
	 * @param adminid 管理员工号
	 * @return 管理员对象
	 */
	public Admin searchAdminByAdminid(int adminid);
	
	/**
	 * 	修改管理员本人密码
	 * @param adminid 管理员id
	 * @param newPwd 新密码
	 * @return 更改的列的数量
	 */
	public int modifyAdminPwd(int adminid,String newPwd);
	
	/**
	 * 	检验并更改管理员密码
	 * @param adminid 管理员id
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @param rePwd 确认密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明更改的密码与确认密码不符；若返回-2则说明输入的密码与原始密码不符
	 */
	public int checkAndModifyAdminPwd(int adminid,String pwd,String newPwd,String rePwd);
	
	/**
	 * 	管理员添加专业课
	 * @param vo 专业课对象
	 * @return 是否成功添加
	 */
	public boolean addCourses(Courses vo);
	
	/**
	 * 	管理员根据专业课id删除专业课
	 * @param coursesid 专业课id
	 * @return 是否删除成功
	 */
	public boolean delCoursesByCoursesid(int coursesid);
	
	/**
	 * 	管理员修改专业课
	 * @param vo 专业课对象
	 * @return 是否修改成功
	 */
	public boolean modifyCourses(Courses vo);
	
	/**
	 * 	管理员根据专业课id查询专业课
	 * @param coursesid 专业课id
	 * @return 专业课对象
	 */
	public Courses searchCoursesByCoursesid(int coursesid);
	
	/**
	 * 	管理员添加选修课
	 * @param vo 选修课对象
	 * @return 是否成功添加
	 */
	public boolean addElective(Elective vo);
	
	/**
	 *	 管理员根据选修课id删除选修课
	 * @param electiveid 选修课id
	 * @return 是否删除成功
	 */
	public boolean delElectiveByElectiveid(int electiveid);
	
	/**
	 * 	管理员修改选修课
	 * @param vo 选修课对象
	 * @return 是否修改成功
	 */
	public boolean modifyElective(Elective vo);
	
	/**
	 * 	管理员根据选修课id查询选修课
	 * @param electiveid 选修课id
	 * @return 选修课对象
	 */
	public Elective searchElectiveByElectiveid(int electiveid);
	
	/**
	 * 	管理员修改调课安排
	 * @param vo 调课安排对象
	 * @return 是否修改成功
	 */
	public boolean modifyCurriculumArrange(Curriculumarrange vo);
	
	/**
	 * 	管理员根据调课id查询调课安排
	 * @param curriculumarrangeid 调课id
	 * @return 调课安排对象
	 */
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid);
	
	/**
	 * 	管理员添加考试
	 * @param vo 考试对象
	 * @return 是否成功添加
	 */
	public boolean addExam(Exam vo);
	
	/**
	 * 	管理员根据考试id删除考试
	 * @param examid 考试id
	 * @return 是否删除成功
	 */
	public boolean delExamByExamid(int examid);
	
	/**
	 * 	管理员清除本次所有考试
	 * @return 是否清除成功
	 */
	public boolean clearAllExam();
	
	/**
	 * 	管理员修改考试
	 * @param vo 考试对象
	 * @return 是否修改成功
	 */
	public boolean modifyExam(Exam vo);
	
	/**
	 * 	管理员根据考试id查询考试
	 * @param examid 考试id
	 * @return 考试对象
	 */
	public Exam searchExamByExamid(int examid);
	
	/**
	 * 	管理员添加专业
	 * @param vo 专业对象
	 * @return 是否成功添加
	 */
	public boolean addMajor(Major vo);
	
	/**
	 * 	管理员根据专业id删除专业
	 * @param majorid 专业id
	 * @return 是否删除成功
	 */
	public boolean delMajorByMajorid(int majorid);
	
	/**
	 * 	管理员修改专业
	 * @param vo 专业对象
	 * @return 是否修改成功
	 */
	public boolean modifyMajor(Major vo);
	
	/**
	 * 	管理员根据专业id查询专业
	 * @param majorid 专业id
	 * @return 专业对象
	 */
	public Major searchMajorByMajorid(int majorid);
	
	/**
	 *	 管理员添加班级
	 * @param vo 班级对象
	 * @return 是否成功添加
	 */
	public boolean addClasses(Classes vo);
	
	/**
	 *	 管理员根据班级id删除班级
	 * @param classesid 班级id
	 * @return 是否删除成功
	 */
	public boolean delClassesByClassesid(int classesid);
	
	/**
	 * 	管理员修改班级
	 * @param vo 班级对象
	 * @return 是否修改成功
	 */
	public boolean modifyClasses(Classes vo);
	
	/**
	 * 	管理员根据班级编号查询班级
	 * @param classesid 班级编号
	 * @return 班级对象
	 */
	public Classes searchClassesByClassesid(int classesid);
	
	/**
	 * 	管理员添加社会考试
	 * @param vo 社会考试对象
	 * @return 是否成功添加
	 */
	public boolean addCet(Cet vo);
	
	/**
	 * 	管理员根据社会考试id删除社会考试
	 * @param cetid 社会考试id
	 * @return 是否删除成功
	 */
	public boolean delCetByCetid(int cetid);
	
	/**
	 *	 管理员修改社会考试
	 * @param vo 社会考试对象
	 * @return 是否修改成功
	 */
	public boolean modifyCet(Cet vo);
	
	/**
	 * 	管理员根据社会考试id查询社会考试
	 * @param cetid 社会考试id
	 * @return 社会考试对象
	 */
	public Cet searchCetByCetid(int cetid);
	
	/**
	 *	 管理员查询某一次社会考试的所有社会考试报名
	 * @param cetid 社会考试id
	 * @return 社会考试报名集合
	 */
	public List<Enrollcet> searchAllEnrollcetByCetid(int cetid);
	
	/**
	 * 	管理员查询某一次社会考试所有报名的学生学号
	 * @param cetid 社会考试id
	 * @return 社会考试报名集合
	 */
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid);
	
	/**
	 * 	管理员添加社会考试成绩
	 * @param vo 社会考试成绩对象
	 * @return 是否成功添加
	 */
	public boolean addGradeCet(Gradecet vo);
	
	/**
	 * 	管理员根据社会考试成绩id删除社会考试成绩
	 * @param cetid 社会考试成绩id
	 * @return 是否删除成功
	 */
	public boolean delGradeCetByGradeCetid(int gardecetid);
	
	/**
	 * 	管理员修改社会考试成绩
	 * @param vo 社会考试成绩对象
	 * @return 是否修改成功
	 */
	public boolean modifyGradeCet(Gradecet vo) ;
	
	/**
	 * 	管理员添加教学评价
	 * @param vo 教学评价对象
	 * @return 是否成功添加
	 */
	public boolean addEvaluation(Evaluation vo);
	
	/**
	 * 	管理员根据教学评价id删除教学评价
	 * @param evaluationid 教学评价id
	 * @return 是否删除成功
	 */
	public boolean delEvaluationByEvaluationid(int evaluationid);
	
	/**
	 * 	管理员修改教学评价
	 * @param vo 教学评价对象
	 * @return 是否修改成功
	 */
	public boolean modifyEvaluation(Evaluation vo);
	
	/**
	 * 	管理员根据教学评价id查询教学评价
	 * @param evaluationid 教学评价id
	 * @return 教学评价对象
	 */
	public Evaluation searchEvaluationByEvaluationid(int evaluationid);
	
}
