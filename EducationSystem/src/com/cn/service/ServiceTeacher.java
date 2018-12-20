package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;

/**
 * 	教师端逻辑层
 * @author Sherlock
 *
 */
public interface ServiceTeacher {
	/**
	 * 	教师登录
	 * @param teacherid 教师工号
	 * @param password 密码
	 * @return 查询的教师对象
	 */
	public Teacher teacherLogin(int teacherid,String password);
	
	/**
	 * 	教师查询个人信息
	 * @param id 教师工号
	 * @return 教师对象
	 */
	public Teacher searchTeacherById(int id);
	
	/**
	 * 	教师查询班级的学生名单
	 * @param classid 班级id
	 * @return 班级的学生集合
	 */
	public List<Student> searchAllStudentByClassesid(int classesid);
	
	/**
	 * 	修改教师本人密码
	 * @param teacherid 教师工号
	 * @param newPwd 新密码
	 * @return 更改的列的数量
	 */
	public int modifyTeacherPwd(int teacherid,String newPwd);
	
	/**
	 * 	检验并更改教师密码
	 * @param teacherid 教师工号
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @param rePwd 确认密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明更改的密码与确认密码不符；若返回-2则说明输入的密码与原始密码不符
	 */
	public int checkAndModifyTeacherPwd(int teacherid,String pwd,String newPwd,String rePwd);
	
	/**
	 * 	把专业课或选修课转化成课程格式
	 * @param courses 专业课对象，若为空证明无专业课
	 * @param elective 选修课对象，若为空证明无选修课
	 * @return 总课程集合
	 */
	public Map<Integer,Curriculum> curriculumTransform(Courses courses,Elective elective);
	
	/**
	 * 	查询某位教师一个学期的所有课程安排（专业课加选修课）
	 * @param termid 学期id
	 * @param teacherid 教师工号
	 * @return 某位教师一个学期的课程安排集合
	 */
	public Map<Integer,Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid,int teacherid);
	
	/**
	 * 	查询一个学期一个班级的所有课程
	 * @param termid 学期id
	 * @param classesid 班级id
	 * @return 一个学期一个班级的课程集合
	 */
	public Map<Integer,Curriculum> searchAllCurriculumByTermidAndClassesid(int termid,int classesid);
	
	/**
	 * 	添加调课安排
	 * @param vo 调课安排对象
	 * @return 是否添加成功
	 */
	public boolean addCurriculumArrange(Curriculumarrange vo);
	
	/**
	 * 	查询某位教师的所有调课安排
	 * @param teacherid 教师工号
	 * @return 调课安排集合
	 */
	public List<Curriculumarrange> searchAllCurriculumArrangeByTeacherid(int teacherid);
	
	/**
	 * 	查询监考老师的所有考试安排
	 * @param teacherid 监考老师工号
	 * @return 考试安排集合
	 */
	public List<Exam> searchAllExamByTeacherid(int teacherid);
	
	/**
	 * 	查询监考老师的所有社会考试安排
	 * @param teacherid 监考老师工号
	 * @return 社会考试安排集合
	 */
	public List<Gradecet> searchAllGradeCetByTeacherid(int teacherid);
	
	/**
	 *	 根据选修课查询该选修课的学生名单
	 * @param electiveid 选修课id
	 * @return 该选修课的学生名单
	 */
	public List<Student> searchAllStudentByElectiveid(int electiveid);
	
	/**
	 * 	查询某一门专业课的所有学生成绩
	 * @param coursesid 专业课id
	 * @return 某一门专业课的所有学生成绩
	 */
	public List<Stuscore> searchAllStuScoreByCoursesid(int coursesid);
	
	/**
	 * 	查询某一门选修课的所有学生成绩
	 * @param electiveid 选修课id
	 * @return 某一门选修课的所有学生成绩
	 */
	public List<Stuscore> searchAllStuScoreByElectiveid(int electiveid);
	
	/**
	 * 	查询一个班某个学期的所有学生成绩
	 * @param classesid 班级编号
	 * @param termid 学期id
	 * @return 一个班一个学期的所有学生成绩集合
	 */
	public List<Stuscore> searchAllStuScoreByClassesidAndTermid(int classesid,int termid);
	
	/**
	 * 	上传一门专业课的成绩
	 * @param coursesid 专业课id
	 * @return 是否成功上传
	 */
	public boolean addStuScoreByCoursesid(int coursesid);
	
	/**
	 * 	上传一个班的所有学生成绩
	 * @param classesid 班级编号
	 * @return 是否成功上传
	 */
	public boolean addStuScoreByClassesid(int classesid);
	
	/**
	 * 	上传某一次社会考试成绩
	 * @param studentid 考生学号
	 * @return 是否成功上传
	 */
	public boolean addGradeCetByStudentid(int studentid);
	
	/**
	 * 	查看某位教师的所有教学评价
	 * @param teacherid 教师工号
	 * @return 某位教师的所有教学评价集合
	 */
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid);
	
}
