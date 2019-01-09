package com.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.BeanArrange;
import com.cn.bean.BeanCet;
import com.cn.bean.BeanEvaluation;
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
import com.cn.bean.StudentExample.Criteria;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;
import com.cn.bean.TempelectiveExample;
import com.cn.bean.Term;
import com.cn.bean.TermExample;
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
import com.cn.dao.TempelectiveMapper;
import com.cn.dao.TermMapper;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetCurrentTermUtils;

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
	private GradecetMapper gradecetMapper;
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;
	@Autowired
	private TermMapper termMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CheckNameUtils checkNameUtils;

	@Override
	public Student studentLogin(int studentid, String pwd) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		//添加id的条件
		criteria.andIdEqualTo(studentid);
		//添加密码的条件
		criteria.andPasswordEqualTo(pwd);
		List<Student> list = studentMapper.selectByExample(example);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Student searchStudentById(int studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
	}

	/**
	 * 	把专业课或选修课转化成课程格式
	 * @param courses 专业课对象，若为空证明无专业课
	 * @param elective 选修课对象，若为空证明无选修课
	 * @return 总课程集合。
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
	public List<Courses> searchAllCoursesByTermidAndClassesid(int termid, int classesid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		criteria.andClassesidEqualTo(classesid);
		return coursesMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuScoreByStudentidAndTermid(int studentid, int termid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> list = stuscoreMapper.selectByExample(example);
		Map<Integer, Stuscore> map = new HashMap<>();
		for (Stuscore stuscore : list) {
			map.put(stuscore.getId(), stuscore);
		}
		return list;
	}

	@Override
	public Elective searchElectiveById(int id) {
		return electiveMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Elective> searchAllElectiveByStudentidAndTermid(int studentid, int termid) {
		List<Elective> list = new ArrayList<>();
		//查找本学期该学生的所有课程
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> listScore = stuscoreMapper.selectByExample(example);
		//遍历所有课程
		for (Stuscore stuscore : listScore) {
			int id = stuscore.getElectiveid();
			//判断该课程是否为选修课
			if(id!=0) {
				//若为选修课则通过选修课id查询
				Elective elecitve = searchElectiveById(id);
				//将选修课添加到集合中
				list.add(elecitve);
			}
		}
		return list;
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
	public List<Curriculum> searchCurriculumByStudentidAndTermid(int studentid, int termid) {
		List<Curriculum> list = new ArrayList<>();
		//通过学生成绩表查询所有专业课与选修课
		List<Stuscore> listStuscore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (Stuscore stuScore : listStuscore) {
			//分别通过各自的id查询专业课与选修课
			int electiveid = stuScore.getElectiveid();
			if(electiveid==0) {
				//专业课
				Courses courses = coursesMapper.selectByPrimaryKey(stuScore.getCouresid());
				list.addAll(curriculumTransform(courses, null));
			}
			else {
				//选修课
				Elective elective = electiveMapper.selectByPrimaryKey(stuScore.getElectiveid());
				list.addAll(curriculumTransform(null, elective));
			}
		}
		return list;
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
	public List<BeanArrange> searchAllCurriculumarrangeByClassesid(int classesid) {
		List<BeanArrange> list = new ArrayList<>();
		List<Curriculumarrange> listArrange = searchAllCoursesArrangeByClassesid(classesid);
		for (Curriculumarrange arrange : listArrange) {
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

	@Override
	public List<Exam> searchAllExamByClassesid(int classesid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return examMapper.selectByExample(example);
	}
	
	@Override
	public int modifyStudentPwd(int studentid,String pwd,  String newPwd) {
		//获取该学生在数据库中的密码
		String password = studentMapper.selectByPrimaryKey(studentid).getPassword();
		if(pwd.equals(password)) { //输入的密码符合原始密码
			Student record = new Student();
			record.setId(studentid);
			record.setPassword(newPwd);
			return studentMapper.updateByPrimaryKeySelective(record);
		}
		else { //输入的密码与原始密码不符
			return -1;
		}
	}

	@Override
	public boolean addGradecetApplyByStudentidAndCetid(int studentid, int cetid) {
		Gradecet vo = new Gradecet(studentid, cetid);
		if (gradecetMapper.insert(vo)>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid, Integer cetid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		List<Gradecet> list = gradecetMapper.selectByExample(example);
		if(list.size()==0) {
			return null;
		}
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
	public List<BeanCet> searchAllGradeCetScoreByStudentid(int studentid) {
		//先查出所有的社会考试成绩
		List<Gradecet> listAll = searchAllGradeCetByStudentid(studentid);
		List<BeanCet> list = new ArrayList<>();
		for (Gradecet gradecet : listAll) {
			if(gradecet.getCetscore()!=null) { //若有成绩
				String name = checkNameUtils.searchByCetId(gradecet.getCetid());
				String place = checkNameUtils.searchByClassroomId(gradecet.getClassroomid());
				BeanCet beanCet = new BeanCet(name, gradecet.getCettime(), place, gradecet.getCetscore(), null);
				list.add(beanCet);
			}
		}		
		return list;
	}

	@Override
	public List<BeanCet> searchAllGradeCetApplyByStudentid(int studentid) {
		//先查出所有的社会考试成绩
		List<Gradecet> listAll = searchAllGradeCetByStudentid(studentid);
		List<BeanCet> list = new ArrayList<>();
		for (Gradecet gradecet : listAll) {
			if(gradecet.getCetscore()==null) { //若没有成绩
				String name = checkNameUtils.searchByCetId(gradecet.getCetid());				
				Integer qualification = 0;
				String place = null;
				if (gradecet.getClassroomid()==null) { //若尚未安排考场，证明未报名
					qualification = 1;
				}
				else {
					place = checkNameUtils.searchByClassroomId(gradecet.getClassroomid());
				}
				BeanCet beanCet = new BeanCet(name, gradecet.getCettime(), place, null, qualification);
				list.add(beanCet);
			}
		}		
		return list;
	}
	
	@Override
	public List<Cet> searchAllCetByCurrentTerm() {
		Integer term = GetCurrentTermUtils.getCurrentTermiId();
		CetExample example = new CetExample();
		com.cn.bean.CetExample.Criteria criteria = example.createCriteria();		
		criteria.andTermidEqualTo(term);
		return cetMapper.selectByExample(example);
	}

	@Override
	public List<BeanCet> searchAllBeanCetByCurrentTerm() {
		List<BeanCet> list = new ArrayList<>();
		List<Cet> listCet = searchAllCetByCurrentTerm();
		for (Cet cet : listCet) {
			String name = checkNameUtils.searchByCetId(cet.getId());			
			BeanCet beanCet = new BeanCet(name, cet.getCettime(), null, cet.getId(), 0);
			list.add(beanCet);
		}
		return list;
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
	public Courses searchCoursesByCoursesId(int coursesId) {
		return coursesMapper.selectByPrimaryKey(coursesId);
		
	}

	@Override
	public int addEvaluationByTeacherid(Evaluation vo) {
		return evaluationMapper.insert(vo);
	}

	@Override
	public boolean addEvaluationByStudentidAndContent(int studentid, BeanEvaluation content) {
		//将content的10道题答案
		Integer tenth = content.getTenth();
		Integer nineth = content.getNineth();
		Integer eighth = content.getEighth();
		Integer seventh = content.getSeventh();
		Integer sixth = content.getSixth();
		Integer fifth = content.getFifth();
		Integer fourth = content.getFourth();
		Integer third = content.getThird();
		Integer second = content.getSecond();
		Integer first = content.getFirst();
		//将这10个数字用字符串加起来
		String anwser = first.toString()+second.toString()+third.toString()+fourth.toString()+fifth.toString()
				+sixth.toString()+seventh.toString()+eighth.toString()+nineth.toString()+tenth.toString();		
		Evaluation evaluation = new Evaluation(content.getTeacherid(), studentid, anwser);
		int isAdd = addEvaluationByTeacherid(evaluation);
		if (isAdd==0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Integer checkEvaluationByStudentidAndTeacherid(int studentid, int teacherid) {
		EvaluationExample example = new EvaluationExample();
		com.cn.bean.EvaluationExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTeacheridEqualTo(teacherid);
		List<Evaluation> list = evaluationMapper.selectByExample(example);
		if(list.size()==0) { //尚未评价
			return 0;
		}
		else { //已评价
			return 1;
		}
	}
	
	@Override
	public List<Term> searchAllTerm() {
		TermExample example = new TermExample();
		return termMapper.selectByExample(example);
	}

	@Override
	public List<Elective> searchAllElectiveByTermid(int termid) {
		ElectiveExample example = new ElectiveExample();
		com.cn.bean.ElectiveExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		return electiveMapper.selectByExample(example);
	}

	@Override
	public List<Curriculum> searchAllElectiveResultByStudentidAndTermid(int studentid, int termid) {
		List<Curriculum> list = new ArrayList<>();
		List<Elective> listElective = searchAllElectiveByTermid(termid);
		List<Tempelective> listTemp = searchAllTempElectiveByStudentid(studentid);
		int electiveid = 0;
		if (listTemp.size()>0) { //证明已有选修结果
			Tempelective temp = listTemp.get(0);
			//将已选择的选修课id保存
			electiveid = temp.getElectiveid();
		}
		for (Elective elective : listElective) {
			//把上课时间拼接起来
			Integer intDay = elective.getDay();
			String time = elective.getTime();
			String day = checkNameUtils.transformDay(intDay);
			time = day+" "+time;
			//用Curriculum类中的coursesid来标记是否已选择选修课，0代表尚未选择，1代表已选择
			Curriculum curriculum = new Curriculum(elective.getName(), time, elective.getTeacher(), 0, elective.getId());
			if (electiveid==elective.getId()) { //证明是该选修课被选择
				//标记该课程已被选择
				curriculum.setCoursesid(1);
			}
			list.add(curriculum);
		}		
		return list;
	}

}

