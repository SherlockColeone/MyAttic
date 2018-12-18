package com.cn.biz;

import java.util.HashMap;
import java.util.Map;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.CurriculumArrange;
import com.cn.bean.Elective;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.GradeCet;
import com.cn.bean.StuScore;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.dao.IClassesDao;
import com.cn.dao.ICoursesDao;
import com.cn.dao.ICurriculumArrangeDao;
import com.cn.dao.IElectiveDao;
import com.cn.dao.IEvaluationDao;
import com.cn.dao.IExamDao;
import com.cn.dao.IGradeCetDao;
import com.cn.dao.IStuScoreDao;
import com.cn.dao.IStudentDao;
import com.cn.dao.ITeacherDao;
import com.cn.dao.impl.ClassesDaoImpl;
import com.cn.dao.impl.CoursesDaoImpl;
import com.cn.dao.impl.CurriculumArrangeDaoImpl;
import com.cn.dao.impl.ElectiveDaoImpl;
import com.cn.dao.impl.EvaluationDaoImpl;
import com.cn.dao.impl.ExamDaoImpl;
import com.cn.dao.impl.GradeCetDaoImpl;
import com.cn.dao.impl.StuScoreDaoImpl;
import com.cn.dao.impl.StudentDaoImpl;
import com.cn.dao.impl.TeacherDaoImpl;

/**
 * 教师端逻辑层
 * @author Sherlock
 *
 */
public class BizTeacher {
	ITeacherDao teacherDao = new TeacherDaoImpl();
	IStudentDao studentDao = new StudentDaoImpl();
	ICoursesDao coursesDao = new CoursesDaoImpl();
	IElectiveDao electiveDao = new ElectiveDaoImpl();
	IClassesDao classesDao = new ClassesDaoImpl();
	ICurriculumArrangeDao curriculumArrangeDao = new CurriculumArrangeDaoImpl();
	IExamDao examDao = new ExamDaoImpl();
	IGradeCetDao gradeCetDao = new GradeCetDaoImpl();
	IStuScoreDao stuScoreDao = new StuScoreDaoImpl();
	IEvaluationDao evaluationDao = new EvaluationDaoImpl();
	
	/**
	 * 教师登录
	 * @param teacherid 教师工号
	 * @param pwd 密码
	 * @return 查询的教师对象
	 */
	public Teacher teacherLogin(int teacherid,String pwd) {
		return teacherDao.findTeacherByIdAndPwd(teacherid, pwd);
	}
	
	/**
	 * 教师查询个人信息
	 * @param id 教师工号
	 * @return 教师对象
	 */
	public Teacher searchTeacherById(int id) {
		return teacherDao.findTeacherById(id);
	}
	
	/**
	 * 教师查询班级的学生名单
	 * @param classid 班级id
	 * @return 班级的学生集合
	 */
	public Map<Integer,Student> searchAllStudentByClassesid(int classesid){
		return studentDao.findAllStudentByClassesid(classesid);
	}	
	
	/**
	 * 修改教师本人密码
	 * @param teacherid 教师工号
	 * @param newPwd 新密码
	 * @return 更改的列的数量
	 */
	public int modifyTeacherPwd(int teacherid,String newPwd) {
		return teacherDao.updatePasswordById(teacherid, newPwd);
	}
	
	/**
	 * 检验并更改教师密码
	 * @param teacherid 教师工号
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @param rePwd 确认密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明更改的密码与确认密码不符；若返回-2则说明输入的密码与原始密码不符
	 */
	public int checkAndModifyTeacherPwd(int teacherid,String pwd,String newPwd,String rePwd) {
		//获取该教师在数据库中的密码
		String password = teacherDao.findTeacherById(teacherid).getPassword();
		//输入的密码与原始密码不符
		if(pwd!=password) {
			return -2;
		}
		//更改的密码与确认密码不符
		else if(newPwd!=rePwd){
			return -1;
		}
		//验证通过，可以修改密码
		else {  
			return modifyTeacherPwd(teacherid, newPwd);
		}
	}
	
	/**
	 * 把专业课或选修课转化成课程格式
	 * @param courses 专业课对象，若为空证明无专业课
	 * @param elective 选修课对象，若为空证明无选修课
	 * @return 总课程集合
	 */
	public Map<Integer,Curriculum> curriculumTransform(Courses courses,Elective elective){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//专业课程
		if(courses!=null) {
			//获取上课节数
			String time = courses.getTime();
			//通过获取节数计算课程大节，获取最后一个字符
			int i = new Integer(time.substring(4));
			int lesson = 0;
			//当获取到2-8时除以2计算出课程在第几大节
			if(i!=0) {
				lesson = i/2;
			}
			//当获取到0时即为10，属于第五大节
			else {
				lesson = 5;
			}
			//获取课程在星期几
			int day = courses.getDay();
			//通过班级id找到班级名称
			String classes = classesDao.findClassesById(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getName(), courses.getWeek(), day,time,lesson,courses.getPlace(),
					courses.getTeacher(), classes);
			mapCurr.put(day*10+lesson, curr);
		}
		//选修课程
		if(elective!=null) {
			String time = elective.getTime();
			int i = new Integer(time.substring(4));
			int lesson = 0;
			if(i!=0) {
				lesson = i/2;
			}
			else {
				lesson = 5;
			}
			int day = elective.getDay();
			Curriculum curr = new Curriculum(elective.getName(), elective.getWeek(), day, time, lesson, 
					elective.getPlace(), elective.getTeacher());
			mapCurr.put(day*10+lesson, curr);
		}
		return mapCurr;
	}
	
	/**
	 * 查询某位教师一个学期的所有课程安排（专业课加选修课）
	 * @param termid 学期id
	 * @param teacherid 教师工号
	 * @return 某位教师一个学期的课程安排集合
	 */
	public Map<Integer,Curriculum> searchAllCurriculByTermidAndTeacherid(int termid,int teacherid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//找到该教师所有专业课
		Map<Integer,Courses> mapCourses = coursesDao.findAllCoursesByTermidAndTeacherid(termid, teacherid);
		for (Courses courses : mapCourses.values()) {
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		//找到该教师所有选修课
		Map<Integer,Elective> mapElective = electiveDao.findAllElectiveByTermidAndTeacherid(termid, teacherid);
		for (Elective elective : mapElective.values()) {
			mapCurr.putAll(curriculumTransform(null, elective));
		}
		return mapCurr;
	}
	
	/**
	 * 查询一个学期一个班级的所有课程
	 * @param termid 学期id
	 * @param classesid 班级id
	 * @return 一个学期一个班级的课程集合
	 */
	public Map<Integer,Curriculum> searchAllCurriculByTermidAndClassesid(int termid,int classesid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//找到所有专业课
		Map<Integer,Courses> mapCourses = coursesDao.findAllCoursesByTermidAndClassesId(termid, classesid);
		for (Courses courses : mapCourses.values()) {
			//转成总课程的格式
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		return mapCurr;
	}
	
	/**
	 * 添加调课安排
	 * @param vo 调课安排对象
	 * @return 是否添加成功
	 */
	public boolean addCurriculumArrange(CurriculumArrange vo) {
		if(curriculumArrangeDao.doCurriculumArrange(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 查询某位教师的所有调课安排
	 * @param teacherid 教师工号
	 * @return 调课安排集合
	 */
	public Map<Integer,CurriculumArrange> searchAllCurriculumArrangeByTeacherid(int teacherid){
		return curriculumArrangeDao.findAllCurriculumArrangeByTeacherid(teacherid);
	}
	
	/**
	 * 查询监考老师的所有考试安排
	 * @param teacherid 监考老师工号
	 * @return 考试安排集合
	 */
	public Map<Integer,Exam> searchAllExamByTeacherid(int teacherid){
		return examDao.findAllExamByTeacherid(teacherid);
	}
	
	/**
	 * 查询监考老师的所有社会考试安排
	 * @param teacherid 监考老师工号
	 * @return 社会考试安排集合
	 */
	public Map<Integer,GradeCet> searchAllGradeCetByTeacherid(int teacherid){
		return gradeCetDao.findAllGradeCetByTeacherid(teacherid);
	}
	
	/**
	 * 根据选修课查询该选修课的学生名单
	 * @param electiveid 选修课id
	 * @return 该选修课的学生名单
	 */
	public Map<Integer,Student> searchAllStudentByElectiveid(int electiveid){
		Map<Integer,Student> mapStudent = new HashMap<>();
		//根据选修课id查询学生成绩表
		Map<Integer, StuScore> mapStuScore = stuScoreDao.findAllStuScoreByElectiveid(electiveid);
		//遍历成绩表
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getStudentid();
			//根据学生学号查询学生
			mapStudent.put(id, studentDao.findStudentById(id));
		}
		return mapStudent;
	}
	
	/**
	 * 查询某一门专业课的所有学生成绩
	 * @param coursesid 专业课id
	 * @return 某一门专业课的所有学生成绩
	 */
	public Map<Integer,StuScore> searchAllStuScoreByCoursesid(int coursesid){
		return stuScoreDao.findAllStuScoreByCoursesid(coursesid);
	}
	
	/**
	 * 查询某一门选修课的所有学生成绩
	 * @param electiveid 选修课id
	 * @return 某一门选修课的所有学生成绩
	 */
	public Map<Integer,StuScore> searchAllStuScoreByElectiveid(int electiveid){
		return stuScoreDao.findAllStuScoreByElectiveid(electiveid);
	}
	
	/**
	 * 查询一个班某个学期的所有学生成绩
	 * @param classesid 班级编号
	 * @param termid 学期id
	 * @return 一个班一个学期的所有学生成绩集合
	 */
	public Map<Integer,StuScore> searchAllStuScoreByClassesidAndTermid(int classesid,int termid){
		Map<Integer,StuScore> mapStuScore = new HashMap<>();
		//先根据班级找到所有学生
		Map<Integer,Student> mapStudent = studentDao.findAllStudentByClassesid(classesid);
		//遍历学生集合
		for (Student student : mapStudent.values()) {
			//找到一个学期该学生的所有成绩集合
			mapStuScore.putAll(stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, student.getId()));
		}
		return mapStuScore;
	}
	
	/**
	 * 上传一门专业课的成绩
	 * @param coursesid 专业课id
	 * @return 是否成功上传
	 */
	public boolean addStuScoreByCoursesid(int coursesid) {
		
		return false;
	}
	
	/**
	 * 上传一个班的所有学生成绩
	 * @param classesid 班级编号
	 * @return 是否成功上传
	 */
	public boolean addStuScoreByClassesid(int classesid) {
		
		return false;
	}
	
	/**
	 * 上传某一次社会考试成绩
	 * @param studentid 考生学号
	 * @return 是否成功上传
	 */
	public boolean addGradeCetByStudentid(int studentid) {
		
		return false;
	}
	
	/**
	 * 查看某位教师的所有教学评价
	 * @param teacherid 教师工号
	 * @return 某位教师的所有教学评价集合
	 */
	public Map<Integer,Evaluation> searchAllEvaluationByTeacherid(int teacherid){
		return evaluationDao.findAllEvaluationByteacherid(teacherid);
	}
}
