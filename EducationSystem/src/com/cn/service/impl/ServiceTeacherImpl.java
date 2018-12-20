package com.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Courses;
import com.cn.bean.CoursesExample;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.CurriculumarrangeExample;
import com.cn.bean.Elective;
import com.cn.bean.ElectiveExample;
import com.cn.bean.Evaluation;
import com.cn.bean.EvaluationExample;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import com.cn.bean.Student;
import com.cn.bean.StudentExample;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.TeacherExample;
import com.cn.bean.TeacherExample.Criteria;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.StuscoreMapper;
import com.cn.dao.TeacherMapper;
import com.cn.service.ServiceTeacher;

/**
 * 	教师端逻辑层实现类
 * @author Sherlock
 *
 */
@Service
public class ServiceTeacherImpl implements ServiceTeacher {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private StuscoreMapper stuscoreMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;

	@Override
	public Teacher teacherLogin(int teacherid, String password) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(teacherid);
		criteria.andPasswordEqualTo(password);
		List<Teacher> list = teacherMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Teacher searchTeacherById(int id) {
		return teacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> searchAllStudentByClassesid(int classesid) {
		StudentExample example = new StudentExample();
		com.cn.bean.StudentExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return studentMapper.selectByExample(example);
	}

	@Override
	public int modifyTeacherPwd(int teacherid, String newPwd) {
		Teacher record = new Teacher();
		record.setId(teacherid);
		record.setPassword(newPwd);
		return teacherMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAndModifyTeacherPwd(int teacherid, String pwd, String newPwd, String rePwd) {
		//获取该教师在数据库中的密码
		String password = teacherMapper.selectByPrimaryKey(teacherid).getPassword();
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
	public Map<Integer, Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid, int teacherid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//找到该教师所有专业课
		CoursesExample coursesExample = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteriaCourses = coursesExample.createCriteria();
		criteriaCourses.andTermidEqualTo(termid);
		criteriaCourses.andTeacheridEqualTo(teacherid);
		List<Courses> listCourses = coursesMapper.selectByExample(coursesExample);
		for (Courses courses : listCourses) {
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		//找到该教师所有选修课
		ElectiveExample electiveExample = new ElectiveExample();
		com.cn.bean.ElectiveExample.Criteria criteriaElecitve = electiveExample.createCriteria();
		criteriaElecitve.andTermidEqualTo(termid);
		criteriaElecitve.andTeacheridEqualTo(teacherid);
		List<Elective> listElective = electiveMapper.selectByExample(electiveExample);
		for (Elective elective : listElective) {
			mapCurr.putAll(curriculumTransform(null, elective));
		}
		return mapCurr;
	}

	@Override
	public Map<Integer, Curriculum> searchAllCurriculumByTermidAndClassesid(int termid, int classesid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//找到所有专业课
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		criteria.andTermidEqualTo(termid);
		List<Courses> listCourses = coursesMapper.selectByExample(example);
		for (Courses courses : listCourses) {
			//转成总课程的格式
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		return mapCurr;
	}

	@Override
	public boolean addCurriculumArrange(Curriculumarrange vo) {	
		if(curriculumarrangeMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Curriculumarrange> searchAllCurriculumArrangeByTeacherid(int teacherid) {
		CurriculumarrangeExample example = new CurriculumarrangeExample();
		com.cn.bean.CurriculumarrangeExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return curriculumarrangeMapper.selectByExample(example);
	}

	@Override
	public List<Exam> searchAllExamByTeacherid(int teacherid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return examMapper.selectByExample(example);
	}

	@Override
	public List<Gradecet> searchAllGradeCetByTeacherid(int teacherid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return gradecetMapper.selectByExample(example);
	}

	@Override
	public List<Student> searchAllStudentByElectiveid(int electiveid) {
		List<Student> listStudent = new ArrayList<>();
		//根据选修课id查询学生成绩表
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		//遍历成绩表
		for (Stuscore stuscore : listStuscore) {
			int id = stuscore.getStudentid();
			//根据学生学号查询学生
			listStudent.add(studentMapper.selectByPrimaryKey(id));
		}
		return listStudent;
	}

	@Override
	public List<Stuscore> searchAllStuScoreByCoursesid(int coursesid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andCouresidEqualTo(coursesid);
		return stuscoreMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuScoreByElectiveid(int electiveid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		return stuscoreMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuScoreByClassesidAndTermid(int classesid, int termid) {
		List<Stuscore> listStusore = new ArrayList<>();
		//先根据班级找到所有学生
		StudentExample studentExample = new StudentExample();
		com.cn.bean.StudentExample.Criteria studentCriteria = studentExample.createCriteria();
		studentCriteria.andClassesidEqualTo(classesid);
		List<Student> listStudent = studentMapper.selectByExample(studentExample);
		StuscoreExample stuscoreExample = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria stuscoreCriteria = stuscoreExample.createCriteria();
		//添加学期条件
		stuscoreCriteria.andTermidEqualTo(termid);
		//遍历学生集合
		for (Student student : listStudent) {
			//添加学生条件
			stuscoreCriteria.andStudentidEqualTo(student.getId());
			//找到一个学期该学生的所有成绩集合
			listStusore.add(stuscoreMapper.selectByExample(stuscoreExample).get(0));
		}
		return listStusore;
	}

	@Override
	public boolean addStuScoreByCoursesid(int coursesid) {
		
		return false;
	}

	@Override
	public boolean addStuScoreByClassesid(int classesid) {
		
		return false;
	}

	@Override
	public boolean addGradeCetByStudentid(int studentid) {
		
		return false;
	}

	@Override
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid) {
		EvaluationExample example = new EvaluationExample();
		com.cn.bean.EvaluationExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return evaluationMapper.selectByExample(example);
	}

}
