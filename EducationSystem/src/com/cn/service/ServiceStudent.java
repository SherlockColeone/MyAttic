package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.bean.BeanCet;
import com.cn.bean.Cet;
import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;
import com.cn.bean.Term;

/**
 * 	学生端逻辑层
 * @author Sherlock
 *
 */
public interface ServiceStudent {
	
	/**
	 *	 学生登录，根据学号与输入的密码检验学生是否存在
	 * @param studentid 学生学号
	 * @param password 输入的密码
	 * @return 学生对象，返回空则说明输入的信息错误
	 */
	public Student studentLogin(int studentid,String password);
	
	/**
	 * 	查询学生本人信息
	 * @param studentid 学生学号
	 * @return 查询出来的学生对象
	 */
	public Student searchStudentById(int studentid);
	
	/**
	 * 	查询不同学期和一个班级的所有专业课
	 * @param termid 学期id
	 * @param classesid 班级编号
	 * @return 一个学期一个班级的专业课集合
	 */
	public List<Courses> searchAllCoursesByTermidAndClassesid(int termid,int classesid);
	
	/**
	 * 	查询一个学生不同学期的所有学生成绩
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 一个学生一个学期的学生成绩集合
	 */
	public List<Stuscore> searchAllStuScoreByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	根据选修课id查询选修课
	 * @param id 选修课id
	 * @return 查询的选修课
	 */
	public Elective searchElectiveById(int id);
	
	/**
	 * 	根据学号和学期id查询本学期的选课结果
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 本学期选修课对象，返回空则说明本学期没有选修课
	 */
	public Elective searchElectiveByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	学生添加选课
	 * @param studentid 学号
	 * @param electiveid 选修课id
	 * @return 是否添加成功
	 */
	public boolean addTempElectiveByStudentid(int studentid,int electiveid);
	
	/**
	 *	 学生修改选课
	 * @param tempid 选修课报名记录id
	 * @param electiveid 修改后的选修课id
	 * @return 是否修改成功
	 */
	public boolean modifyTempElectiveByStudentid(int tempid,int electiveid);
	
	/**
	 * 	学生查询所有本人所有选课结果
	 * @param studentid 学号
	 * @return 选课记录集合
	 */
	public List<Tempelective> searchAllTempElectiveByStudentid(int studentid);
	
	/**
	 * 	查询一个学生一个学期的所有课程（专业课加上选修课）
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 一个学生一个学期的所有课程
	 */
	public List<Curriculum> searchCurriculumByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	查询一个老师一个学期的所有专业课
	 * @param teacherid 教师工号
	 * @param termid 学期id
	 * @return 一个老师一个学期的所有专业课集合
	 */
	public Map<Integer,Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid,int termid);
	
	/**
	 * 	查询班级的调课安排
	 * @param classesid 班级id
	 * @return 本班的所有调课安排
	 */
	public List<Curriculumarrange> searchAllCoursesArrangeByClassesid(int classesid);
	
	/**
	 *	 查询本班的考试安排
	 * @param classesid 班级编号
	 * @return 班级的考试安排集合
	 */
	public List<Exam> searchAllExamByClassesid(int classesid);
	
	/**
	 * 	更改学生密码
	 * @param studentid 学生学号
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明输入的密码与原始密码不符
	 */
	public int modifyStudentPwd(int studentid,String pwd,String newPwd);
	
	/**
	 * 	学生报名社会考试
	 * @param studentid 学生学号
	 * @param cetid 社会考试id
	 * @return 是否报名成功
	 */
	public boolean addEnrollCet(int studentid,int cetid);
	
	/**
	 * 	学生查询本次社会考试报名记录
	 * @param studentid 学号
	 * @param cetid 社会考试id
	 * @return 社会考试报名记录
	 */
	public Enrollcet searchEnrollCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * 	考生查询某次社会考试成绩和考试安排
	 * @param studentid 学号
	 * @param cetid 社会考试id
	 * @return 社会考试成绩对象
	 */
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid,Integer cetid);
	
	/**
	 * 	考生查询本人所有社会考试成绩
	 * @param studentid 学号
	 * @return 社会考试成绩集合
	 */
	public List<Gradecet> searchAllGradeCetByStudentid(int studentid);

	/**
	 * 	考生查询本人已有成绩的社会考试成绩
	 * @param studentid 学号
	 * @return 社会考试显示实体类集合
	 */
	public List<BeanCet> searchAllGradeCetScoreByStudentid(int studentid);	
	
	/**
	 * 	考生查询本人已报名的社会考试成绩
	 * @param studentid 学号
	 * @return 社会考试显示实体类集合
	 */
	public List<BeanCet> searchAllGradeCetApplyByStudentid(int studentid);
	
	/**
	 * 	查询本学期的所有社会考试
	 * @param termid 学期id
	 * @return 本学期的社会考试集合
	 */
	public List<Cet> searchAllCet(int termid);
	
	/**
	 * 	根据学号与学期查询所有专业课程
	 * @param studentid 学号
	 * @param termid 学期
	 * @return 专业课程集合
	 */
	public List<Courses> searchAllCoursesByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	根据学号与学期找到所有专业课老师
	 * @param studentid 学号
	 * @param termid 学期
	 * @return 专业课老师集合
	 */
	public List<Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	学生添加教学评价
	 * @param vo 教学评价
	 * @return 添加的列数量
	 */
	public int addEvaluationByTeacherid(Evaluation vo);
	
	/**
	 * 查询所有的学期
	 * @return 学期的集合
	 */
	public List<Term> searchAllTerm();
	
}
