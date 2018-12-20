package com.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Cet;
import com.cn.bean.CetExample;
import com.cn.bean.Courses;
import com.cn.bean.CoursesExample;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.CurriculumarrangeExample;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.EnrollcetExample;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import com.cn.bean.Student;
import com.cn.bean.StudentExample;
import com.cn.bean.StudentExample.Criteria;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;
import com.cn.bean.TempelectiveExample;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EnrollcetMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.StuscoreMapper;
import com.cn.dao.TeacherMapper;
import com.cn.dao.TempelectiveMapper;
import com.cn.service.ServiceStudent;

/**
 * 	学生端逻辑层实现类
 * @author Sherlock
 *
 */
@Service
public class ServiceStudentImpl implements ServiceStudent {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private StuscoreMapper stuscoreMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private TempelectiveMapper tempelectiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private EnrollcetMapper enrollcetMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;

	@Override
	public Student studentLogin(int studentid, String pwd) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		//添加id的条件
		criteria.andIdEqualTo(studentid);
		//添加密码的条件
		criteria.andPasswordEqualTo(pwd);
		List<Student> list = studentMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Student searchStudentById(int studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
	}

	@Override
	public Map<Integer, Curriculum> curriculumTransform(Courses courses, Elective elective) {
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
			String classes = classesMapper.selectByPrimaryKey(courses.getClassesid()).getName();
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

	@Override
	public List<Courses> searchAllCoursesByTermidAndClassesid(int termid, int classesid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		criteria.andClassesidEqualTo(classesid);
		return coursesMapper.selectByExample(example);
	}

	@Override
	public Map<Integer,Stuscore> searchAllStuScoreByStudentidAndTermid(int studentid, int termid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> list = stuscoreMapper.selectByExample(example);
		Map<Integer, Stuscore> map = new HashMap<>();
		for (Stuscore stuscore : list) {
			map.put(stuscore.getId(), stuscore);
		}
		return null;
	}

	@Override
	public Elective searchElectiveById(int id) {
		return electiveMapper.selectByPrimaryKey(id);
	}

	@Override
	public Elective searchElectiveByStudentidAndTermid(int studentid, int termid) {
		//查找本学期该学生的所有课程
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> list = stuscoreMapper.selectByExample(example);
		//遍历所有课程
		for (Stuscore stuscore : list) {
			int id = stuscore.getElectiveid();
			//判断该课程是否为选修课
			if(id!=0) {
				//若为选修课则通过选修课id查询
				return searchElectiveById(id);
			}
		}
		return null;
	}

	@Override
	public boolean addTempElectiveByStudentid(int studentid, int electiveid) {
		Tempelective tempelective = new Tempelective(electiveid, studentid);
		if(tempelectiveMapper.insert(tempelective)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyTempElectiveByStudentid(int tempid, int electiveid) {
		//先找到原本的记录
		Tempelective tempElective = tempelectiveMapper.selectByPrimaryKey(tempid);
		//再进行修改
		Tempelective vo = new Tempelective(tempid, electiveid, tempElective.getStudentid());
		if(tempelectiveMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Tempelective> searchAllTempElectiveByStudentid(int studentid) {
		TempelectiveExample example = new TempelectiveExample();
		com.cn.bean.TempelectiveExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return tempelectiveMapper.selectByExample(example);
	}

	@Override
	public Map<Integer, Curriculum> searchCurriculumByStudentidAndTermid(int studentid, int termid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//通过学生成绩表查询所有专业课与选修课
		Map<Integer,Stuscore> mapStuScore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (Stuscore stuScore : mapStuScore.values()) {
			//分别通过各自的id查询专业课与选修课
			int electiveid = stuScore.getElectiveid();
			if(electiveid!=0) {
				//专业课
				Courses courses = coursesMapper.selectByPrimaryKey(stuScore.getCouresid());
				mapCurr.putAll(curriculumTransform(courses, null));
			}
			else {
				//选修课
				Elective elective = electiveMapper.selectByPrimaryKey(stuScore.getElectiveid());
				mapCurr.putAll(curriculumTransform(null, elective));
			}
		}
		return mapCurr;
	}

	@Override
	public Map<Integer, Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid, int termid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		criteria.andTermidEqualTo(termid);
		List<Courses> list = coursesMapper.selectByExample(example);
		Map<Integer, Courses> map = new HashMap<>();
		for (Courses courses : list) {
			map.put(courses.getId(), courses);
		}
		return map;
	}

	@Override
	public List<Curriculumarrange> searchAllCoursesArrangeByClassesid(int classesid) {
		CurriculumarrangeExample example = new CurriculumarrangeExample();
		com.cn.bean.CurriculumarrangeExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return curriculumarrangeMapper.selectByExample(example);
	}

	@Override
	public List<Exam> searchAllExamByClassesid(int classesid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return examMapper.selectByExample(example);
	}

	@Override
	public int modifyStudentPwd(int studentid, String newPwd) {
		Student record = new Student();
		record.setId(studentid);
		record.setPassword(newPwd);
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAndModifyStudentPwd(int studentid, String pwd, String newPwd, String rePwd) {
		//获取该学生在数据库中的密码
		String password = studentMapper.selectByPrimaryKey(studentid).getPassword();
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

	@Override
	public boolean addEnrollCet(int studentid, int cetid) {
		Enrollcet vo = new Enrollcet(cetid, studentid);
		if (enrollcetMapper.insert(vo)>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Enrollcet searchEnrollCetByStudentidAndCetid(int studentid, int cetid) {
		EnrollcetExample example = new EnrollcetExample();
		com.cn.bean.EnrollcetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		List<Enrollcet> list = enrollcetMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid, String cetid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		List<Gradecet> list = gradecetMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public List<Gradecet> searchAllGradeCetByStudentid(int studentid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return gradecetMapper.selectByExample(example);
	}

	@Override
	public List<Cet> searchAllCet(int termid) {
		CetExample example = new CetExample();
		com.cn.bean.CetExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		return cetMapper.selectByExample(example);
	}

	@Override
	public List<Courses> searchAllCoursesByStudentidAndTermid(int studentid, int termid) {
		List<Courses> listCourses = new ArrayList<>();
		//先找到本学期所有课程
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		for (Stuscore stuScore : listStuscore) {
			int id = stuScore.getCouresid();
			//再找到专业课
			if(id!=0) {
				//添加到集合中
				listCourses.add(coursesMapper.selectByPrimaryKey(id));
			}
		}
		return listCourses;
	}

	@Override
	public List<Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid, int termid) {
		List<Teacher> listTeacher = new ArrayList<>();
		//先找到本学期所有专业课
		List<Courses> listCourses = searchAllCoursesByStudentidAndTermid(studentid, termid);
		for (Courses courses : listCourses) {
			//通过课程找到对应的任课老师
			listTeacher.add(teacherMapper.selectByPrimaryKey(courses.getTeacherid()));
		}
		return listTeacher;
	}

	@Override
	public int addEvaluationByTeacherid(Evaluation vo) {
		return evaluationMapper.insert(vo);
	}

}

