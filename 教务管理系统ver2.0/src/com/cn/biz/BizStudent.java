package com.cn.biz;

import java.util.HashMap;
import java.util.Map;

import com.cn.bean.Cet;
import com.cn.bean.Courses;
import com.cn.bean.CurriculumArrange;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.EnrollCet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.GradeCet;
import com.cn.bean.StuScore;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.bean.TempElective;
import com.cn.dao.ICetDao;
import com.cn.dao.IClassesDao;
import com.cn.dao.ICoursesDao;
import com.cn.dao.ICurriculumArrangeDao;
import com.cn.dao.IElectiveDao;
import com.cn.dao.IEnrollCetDao;
import com.cn.dao.IEvaluationDao;
import com.cn.dao.IExamDao;
import com.cn.dao.IGradeCetDao;
import com.cn.dao.IStuScoreDao;
import com.cn.dao.IStudentDao;
import com.cn.dao.ITeacherDao;
import com.cn.dao.ITempElectiveDao;
import com.cn.dao.impl.CetDaoImpl;
import com.cn.dao.impl.ClassesDaoImpl;
import com.cn.dao.impl.CoursesDaoImpl;
import com.cn.dao.impl.CurriculumArrangeDaoImpl;
import com.cn.dao.impl.ElectiveDaoImpl;
import com.cn.dao.impl.EnrollCetDaoImpl;
import com.cn.dao.impl.EvaluationDaoImpl;
import com.cn.dao.impl.ExamDaoImpl;
import com.cn.dao.impl.GradeCetDaoImpl;
import com.cn.dao.impl.StuScoreDaoImpl;
import com.cn.dao.impl.StudentDaoImpl;
import com.cn.dao.impl.TeacherDaoImpl;
import com.cn.dao.impl.TempElectiveDaoImpl;

/**
 * 学生端逻辑层
 * @author Sherlock
 *
 */
public class BizStudent {
	IStudentDao studentDao = new StudentDaoImpl();
	IStuScoreDao stuScoreDao = new StuScoreDaoImpl();
	ICoursesDao coursesDao = new CoursesDaoImpl();
	IElectiveDao electiveDao = new ElectiveDaoImpl();
	IExamDao examDao = new ExamDaoImpl();
	IClassesDao classesDao = new ClassesDaoImpl();
	IGradeCetDao gradeCetDao = new GradeCetDaoImpl();
	ICetDao cetDao = new CetDaoImpl();
	IEvaluationDao evaluationDao = new EvaluationDaoImpl();
	ITeacherDao teacherDao = new TeacherDaoImpl();
	IEnrollCetDao enrollCetDao = new EnrollCetDaoImpl();
	ITempElectiveDao tempElectiveDao = new TempElectiveDaoImpl();
	ICurriculumArrangeDao curriculumArrangeDao = new CurriculumArrangeDaoImpl();
	
	/**
	 * 学生登录，根据学号与输入的密码检验学生是否存在
	 * @param studentid 学生学号
	 * @param pwd 输入的密码
	 * @return 学生对象，返回空则说明输入的信息错误
	 */
	public Student studentLogin(int studentid,String pwd) {
		return studentDao.findStudentByIdAndPwd(studentid, pwd);
	}
	
	/**
	 * 查询学生本人信息
	 * @param studentid 学生学号
	 * @return 查询出来的学生对象
	 */
	public Student searchStudentById(int studentid) {
		return studentDao.findStudentById(studentid);
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
	 * 查询不同学期和一个班级的所有专业课
	 * @param termid 学期id
	 * @param classesid 班级编号
	 * @return 一个学期一个班级的专业课集合
	 */
	public Map<Integer,Courses> searchAllCoursesByTermidAndClassesid(int termid,int classesid) {
		return coursesDao.findAllCoursesByTermidAndClassesId(termid, classesid);
	}
		
	/**
	 * 查询一个学生不同学期的所有学生成绩
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 一个学生一个学期的学生成绩集合
	 */
	public Map<Integer,StuScore> searchAllStuScoreByStudentidAndTermid(int studentid,int termid){
		return stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
	}
	
	/**
	 * 根据选修课id查询选修课
	 * @param id 选修课id
	 * @return 查询的选修课
	 */
	public Elective searchElectiveById(int id){
		return electiveDao.findElectiveById(id);
	}
	
	/**
	 * 根据学号和学期id查询本学期的选课结果
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 本学期选修课对象，返回空则说明本学期没有选修课
	 */
	public Elective searchElectiveByStudentidAndTermid(int studentid,int termid) {
		//查找本学期该学生的所有课程
		Map<Integer,StuScore> mapStuScore = stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
		//遍历所有课程
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getElectiveid();
			//判断该课程是否为选修课
			if(id!=0) {
				//若为选修课则通过选修课id查询
				return searchElectiveById(id);
			}
		}
		//若找不到则返回空
		return null;
	}
	
	/**
	 * 学生添加选课
	 * @param studentid 学号
	 * @param electiveid 选修课id
	 * @return 是否添加成功
	 */
	public boolean addTempElectiveByStudentid(int studentid,int electiveid) {
		TempElective vo = new TempElective(electiveid, studentid);
		if(tempElectiveDao.doTempElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 学生修改选课
	 * @param tempid 选修课报名记录id
	 * @param electiveid 修改后的选修课id
	 * @return 是否修改成功
	 */
	public boolean modifyTempElectiveByStudentid(int tempid,int electiveid) {
		//先找到原本的记录
		TempElective tempElective = tempElectiveDao.findTempElectiveById(tempid);
		//再进行修改
		TempElective vo = new TempElective(tempid, electiveid, tempElective.getStudentid());
		if(tempElectiveDao.updateTempElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 学生查询所有本人所有选课结果
	 * @param studentid 学号
	 * @return 选课记录集合
	 */
	public Map<Integer,TempElective> searchAllTempElectiveByStudentid(int studentid){
		return tempElectiveDao.findAllTempElectiveByStudentid(studentid);
	}
	
	/**
	 * 查询一个学生一个学期的所有课程（专业课加上选修课）
	 * @param studentid 学号
	 * @param termid 学期id
	 * @return 一个学生一个学期的所有课程
	 */
	public Map<Integer,Curriculum> searchCurriculumByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//通过学生成绩表查询所有专业课与选修课
		Map<Integer,StuScore> mapStuScore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (StuScore stuScore : mapStuScore.values()) {
			//分别通过各自的id查询专业课与选修课
			int electiveid = stuScore.getElectiveid();
			if(electiveid!=0) {
				//专业课
				Courses courses = coursesDao.findCoursesById(stuScore.getCoursesid());
				mapCurr.putAll(curriculumTransform(courses, null));
			}
			else {
				//选修课
				Elective elective = electiveDao.findElectiveById(stuScore.getElectiveid());
				mapCurr.putAll(curriculumTransform(null, elective));
			}
		}
		return mapCurr;
	}
	
	/**
	 * 查询一个老师一个学期的所有专业课
	 * @param teacherid 教师工号
	 * @param termid 学期id
	 * @return 一个老师一个学期的所有专业课集合
	 */
	public Map<Integer,Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid,int termid){
		return coursesDao.findAllCoursesByTermidAndTeacherid(termid, teacherid);
	}
	
	/**
	 * 查询班级的调课安排
	 * @param classesid 班级id
	 * @return 本班的所有调课安排
	 */
	public Map<Integer,CurriculumArrange> searchAllCoursesArrangeByClassesid(int classesid){
		return curriculumArrangeDao.findAllCurriculumArrangeByClassesid(classesid);
	}
	
	/**
	 * 查询本班的考试安排
	 * @param classesid 班级编号
	 * @return 班级的考试安排集合
	 */
	public Map<Integer,Exam> searchAllExamByClassesid(int classesid){
		return examDao.findAllExamByClassesid(classesid);
	}
	
	/**
	 * 修改学生本人密码
	 * @param studentid 学生学号
	 * @param newPwd 新密码
	 * @return 更改的列的数量
	 */
	public int modifyStudentPwd(int studentid,String newPwd) {
		return studentDao.updatePasswordById(studentid, newPwd);
	}
	
	/**
	 * 检验并更改学生密码
	 * @param studentid 学生学号
	 * @param pwd 原始密码
	 * @param newPwd 新密码
	 * @param rePwd 确认密码
	 * @return 更改的列数量，若返回正整数则修改成功；若返回0则修改失败；若返回-1则说明更改的密码与确认密码不符；若返回-2则说明输入的密码与原始密码不符
	 */
	public int checkAndModifyStudentPwd(int studentid,String pwd,String newPwd,String rePwd) {
		//获取该学生在数据库中的密码
		String password = studentDao.findStudentById(studentid).getPassword();
		if(pwd!=password) { //输入的密码与原始密码不符
			return -2;
		}
		else if(newPwd!=rePwd){ //更改的密码与确认密码不符
			return -1;
		}
		else {
			return modifyStudentPwd(studentid, newPwd);
		}
	}
	
	/**
	 * 学生报名社会考试
	 * @param studentid
	 * @param cetid
	 * @return 是否报名成功
	 */
	public boolean addEnrollCet(int studentid,int cetid) {
		EnrollCet vo = new EnrollCet(cetid, studentid);
		if (enrollCetDao.doEnrollCet(vo)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 学生查询本次社会考试报名记录
	 * @param studentid 学号
	 * @param cetid 社会考试id
	 * @return 社会考试报名记录
	 */
	public EnrollCet searchEnrollCetByStudentidAndCetid(int studentid,int cetid) {
		return enrollCetDao.findEnrollCetByStudentidAndCetid(studentid, cetid);
	}
	
	/**
	 * 考生查询某次社会考试成绩和考试安排
	 * @param studentid
	 * @param cetid
	 * @return 社会考试成绩对象
	 */
	public GradeCet searchGradeCetByStudentidAndCetid(int studentid,int cetid) {
		return gradeCetDao.findGradeCetByStudentidAndCetid(studentid, cetid);
	}
	
	/**
	 * 考生查询本人所有社会考试成绩
	 * @param studentid 学号
	 * @return 社会考试成绩集合
	 */
	public Map<Integer,GradeCet> searchAllGradeCetByStudentid(int studentid){
		return gradeCetDao.findAllGradeCetByStudentid(studentid);
	}
	
	/**
	 * 查询本学期的所有社会考试
	 * @param termid 学期id
	 * @return 本学期的社会考试集合
	 */
	public Map<Integer,Cet> searchAllCet(int termid){
		return cetDao.findAllCetByTermid(termid);
	}
	
	/**
	 * 根据学号与学期查询所有专业课程
	 * @param studentid 学号
	 * @param termid 学期
	 * @return 专业课程集合
	 */
	public Map<Integer,Courses> searchAllCoursesByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Courses> mapCourses = new HashMap<>();
		//先找到本学期所有课程
		Map<Integer,StuScore> mapStuScore = stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getCoursesid();
			//再找到专业课
			if(id!=0) {
				mapCourses.put(id, coursesDao.findCoursesById(id));
			}
		}
		return mapCourses;
	}
	
	/**
	 * 根据学号与学期找到所有专业课老师
	 * @param studentid 学号
	 * @param termid 学期
	 * @return 专业课老师集合
	 */
	public Map<Integer,Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Teacher> mapTeacher = new HashMap<>();
		//先找到本学期所有专业课
		Map<Integer,Courses> mapCourses = searchAllCoursesByStudentidAndTermid(studentid, termid);
		for (Courses courses : mapCourses.values()) {
			//通过课程找到对应的任课老师
			mapTeacher.put(courses.getTeacherid(), teacherDao.findTeacherById(courses.getTeacherid()));
		}
		return mapTeacher;
	}
	
	/**
	 * 学生添加教师评价
	 * @return 添加的列数量
	 */
	public int addEvaluationByTeacherid(Evaluation vo) {
		return evaluationDao.doEvaluation(vo);
	}
	
}
