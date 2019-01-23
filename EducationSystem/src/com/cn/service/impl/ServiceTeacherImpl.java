package com.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.BeanArrange;
import com.cn.bean.BeanCet;
import com.cn.bean.BeanStuscore;
import com.cn.bean.Cet;
import com.cn.bean.CetExample;
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
import com.cn.dao.CetMapper;
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
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

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
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private CetMapper cetMapper;

	@Override
	public Teacher teacherLogin(int teacherid, String password) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(teacherid);
		criteria.andPasswordEqualTo(password);
		List<Teacher> list = teacherMapper.selectByExample(example);
		if(list.size()==0) {
			return null;
		}
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
	public int modifyTeacherPwd(int teacherid, String pwd, String newPwd) {
		//获取该教师在数据库中的密码
		String password = teacherMapper.selectByPrimaryKey(teacherid).getPassword();
		if(pwd.equals(password)) { //验证通过，可以修改密码
			Teacher record = new Teacher();
			record.setId(teacherid);
			record.setPassword(newPwd);
			return teacherMapper.updateByPrimaryKeySelective(record);
		}
		else {  //输入的密码与原始密码不符
			return -1;
		}
	}

	/**
	 * 	把专业课或选修课转化成课程格式
	 * @param courses 专业课对象，若为空证明无专业课
	 * @param elective 选修课对象，若为空证明无选修课
	 * @return 总课程集合
	 */
	private List<Curriculum> curriculumTransform(Courses courses, Elective elective) {
		List<Curriculum> list = new ArrayList<>();
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
			//获取班级名称
			String classes = classesMapper.selectByPrimaryKey(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getId(), courses.getName(), courses.getWeek(), day, time, lesson,
					courses.getPlace(), courses.getTeacher(), courses.getClassesid(), courses.getTermid(), 
					courses.getTeacherid(),courses.getId(),0,classes);
			list.add(curr);
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
			Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getWeek(), day, time,
					lesson,elective.getPlace(), elective.getTeacher(), elective.getTermid(),elective.getTeacherid(),
					0,elective.getId());
			list.add(curr);
		}
		return list;
	}

	@Override
	public List<Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid, int teacherid) {
		List<Curriculum> list = new ArrayList<>();
		//找到该教师所有专业课
		CoursesExample coursesExample = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteriaCourses = coursesExample.createCriteria();
		criteriaCourses.andTermidEqualTo(termid);
		criteriaCourses.andTeacheridEqualTo(teacherid);
		List<Courses> listCourses = coursesMapper.selectByExample(coursesExample);
		for (Courses courses : listCourses) {
			list.addAll(curriculumTransform(courses, null));
		}
		//找到该教师所有选修课
		ElectiveExample electiveExample = new ElectiveExample();
		com.cn.bean.ElectiveExample.Criteria criteriaElecitve = electiveExample.createCriteria();
		criteriaElecitve.andTermidEqualTo(termid);
		criteriaElecitve.andTeacheridEqualTo(teacherid);
		List<Elective> listElective = electiveMapper.selectByExample(electiveExample);
		for (Elective elective : listElective) {
			list.addAll(curriculumTransform(null, elective));
		}
		return list;
	}

	@Override
	public List<Curriculum> searchAllCurriculumByTermidAndClassesid(int termid, int classesid) {
		List<Curriculum> list = new ArrayList<>();
		//找到所有专业课
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		criteria.andTermidEqualTo(termid);
		List<Courses> listCourses = coursesMapper.selectByExample(example);
		for (Courses courses : listCourses) {
			//转成总课程的格式
			list.addAll(curriculumTransform(courses, null));
		}
		return list;
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
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid,int cetid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		return gradecetMapper.selectByExample(example).get(0);
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
	public boolean modifyStuScoreByCoursesid(List<BeanStuscore> list) {
		int i = 0;
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		for (BeanStuscore beanStuscore : list) {
			//根据专业课id和学号查出该学生该课程的成绩
			criteria.andCouresidEqualTo(beanStuscore.getCurriculumId());
			criteria.andStudentidEqualTo(beanStuscore.getStudentid());
			List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
			Stuscore stuscore = listStuscore.get(0);
			String strScore = beanStuscore.getScore();
			//设置成绩
			stuscore.setScore(strScore);
			//计算绩点。绩点计算公式：绩点=（成绩-50）+（成绩%10 /10）
			Integer score = new Integer(strScore);
			Double point = new Double((score-50)+((score%10)/10));
			//设置绩点
			stuscore.setPoint(point);
			//添加到数据库中
			i = stuscoreMapper.insert(stuscore);
		}
		if (i>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyStuScoreByElectiveid(List<BeanStuscore> list) {
		int i = 0;
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		for (BeanStuscore beanStuscore : list) {
			//根据选修课id和学号查出该学生该课程的成绩
			criteria.andElectiveidEqualTo(beanStuscore.getCurriculumId());
			criteria.andStudentidEqualTo(beanStuscore.getStudentid());
			List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
			Stuscore stuscore = listStuscore.get(0);
			String strScore = beanStuscore.getScore();
			//设置成绩
			stuscore.setScore(strScore);
			//计算绩点。绩点计算公式：绩点=（成绩-50）+（成绩%10 /10）
			Integer score = new Integer(strScore);
			Double point = new Double((score-50)+((score%10)/10));
			//设置绩点
			stuscore.setPoint(point);
			//添加到数据库中
			i = stuscoreMapper.insert(stuscore);
		}
		if (i>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid) {
		EvaluationExample example = new EvaluationExample();
		com.cn.bean.EvaluationExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return evaluationMapper.selectByExample(example);
	}

	@Override
	public List<Courses> searchAllCoursesByTeacheridAndTermid(int teacherid, int termid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		criteria.andTermidEqualTo(termid);
		return coursesMapper.selectByExample(example);
	}

	@Override
	public List<Elective> searchAllElectiveByTeacheridAndTermid(int teacherid, int termid) {
		ElectiveExample example = new ElectiveExample();
		com.cn.bean.ElectiveExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		criteria.andTermidEqualTo(termid);
		return electiveMapper.selectByExample(example);
	}

	@Override
	public List<Curriculum> changeElectiveListIntoCurriculumList(List<Elective> listElective) {
		List<Curriculum> list = new ArrayList<>();
		for (Elective elective : listElective) {
			//转换成字符串的星期几
			String day = checkNameUtils.transformDay(elective.getDay());
			String time = day+" "+elective.getTime()+"节";
			Curriculum curr = new Curriculum(elective.getName(), time, elective.getPlace(), elective.getId());
			list.add(curr);
		}
		return list;
	}

	@Override
	public List<Curriculum> changeStudentListIntoCurriculumList(List<Student> listStudent) {
		List<Curriculum> list = new ArrayList<>();
		for (Student student : listStudent) {
			Curriculum curr = new Curriculum(student.getId(), student.getName(),
					checkNameUtils.searchByClassesId(student.getClassesid()));
			list.add(curr);
		}
		return list;
	}

	@Override
	public List<BeanStuscore> changeStuscoreListIntoBeanStuscoreList(List<Stuscore> listStuscore) {	
		List<BeanStuscore> list = new ArrayList<>();
		//遍历所有的学生成绩
		for (Stuscore stuscore : listStuscore) {
			//查询该成绩对应的学生信息
			Student student = studentMapper.selectByPrimaryKey(stuscore.getStudentid());
			Integer curriculumId = 0;
			if (stuscore.getCouresid()!=0) { //专业课的成绩
				curriculumId = stuscore.getCouresid();
			} else { //选修课的成绩
				curriculumId = stuscore.getElectiveid();
			}
			BeanStuscore score = new BeanStuscore(student.getId(), checkNameUtils.searchByClassesId(student.getClassesid()), 
					student.getName(), null, null, stuscore.getScore(),curriculumId);
			list.add(score);
		}
		return list;
	}

	@Override
	public List<Cet> searchAllCetByCurrentTermid() {
		CetExample example = new CetExample();
		com.cn.bean.CetExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(GetTermUtils.getCurrentTermiId());
		return cetMapper.selectByExample(example);
	}

	@Override
	public BeanCet changeGradecetIntoBeanCetByStudentid(Gradecet gradecet,int studentid) {
		//根据学号找到学生
		Student student = studentMapper.selectByPrimaryKey(studentid);
		BeanCet beanCet = new BeanCet(checkNameUtils.searchByCetId(gradecet.getCetid()), gradecet.getCettime(), 
				gradecet.getCetscore(), checkNameUtils.searchByClassesId(student.getClassesid()), student.getName(), studentid);
		return beanCet;
	}

	@Override
	public List<BeanArrange> changeAllCurriculumarrangeIntoBeanArrange(List<Curriculumarrange> listCurr) {
		List<BeanArrange> list = new ArrayList<>();
		for (Curriculumarrange arrange : listCurr) {
			//找到课程名称
			String name = checkNameUtils.searchByCoursesId(arrange.getCoursesid());
			//拼接上课日期
			String day = checkNameUtils.transformDay(arrange.getDay());
			String time = arrange.getTime();
			//进行拼接
			String date = day+"<br />"+time+"节";
			//找到教师名称
			String teacher = checkNameUtils.searchByTeacherId(arrange.getTeacherid());
			//找到班级名称
			String classes = checkNameUtils.searchByClassesId(arrange.getClassesid());
			BeanArrange bean = new BeanArrange(name, arrange.getWeek(), date, arrange.getPlace(), teacher, classes);
			list.add(bean);
		}
		return list;
	}

}
