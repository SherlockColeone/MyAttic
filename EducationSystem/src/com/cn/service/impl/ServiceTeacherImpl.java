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
 * 	��ʦ���߼���ʵ����
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
		//��ȡ�ý�ʦ�����ݿ��е�����
		String password = teacherMapper.selectByPrimaryKey(teacherid).getPassword();
		if(pwd.equals(password)) { //��֤ͨ���������޸�����
			Teacher record = new Teacher();
			record.setId(teacherid);
			record.setPassword(newPwd);
			return teacherMapper.updateByPrimaryKeySelective(record);
		}
		else {  //�����������ԭʼ���벻��
			return -1;
		}
	}

	/**
	 * 	��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * @param courses רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼���
	 */
	private List<Curriculum> curriculumTransform(Courses courses, Elective elective) {
		List<Curriculum> list = new ArrayList<>();
		//רҵ�γ�
		if(courses!=null) {
			//��ȡ�Ͽν���
			String time = courses.getTime();
			//ͨ����ȡ��������γ̴�ڣ���ȡ���һ���ַ�
			int i = new Integer(time.substring(4));
			int lesson = 0;
			//����ȡ��2-8ʱ����2������γ��ڵڼ����
			if(i!=0) {
				lesson = i/2;
			}
			//����ȡ��0ʱ��Ϊ10�����ڵ�����
			else {
				lesson = 5;
			}
			//��ȡ�γ������ڼ�
			int day = courses.getDay();
			//��ȡ�༶����
			String classes = classesMapper.selectByPrimaryKey(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getId(), courses.getName(), courses.getWeek(), day, time, lesson,
					courses.getPlace(), courses.getTeacher(), courses.getClassesid(), courses.getTermid(), 
					courses.getTeacherid(),courses.getId(),0,classes);
			list.add(curr);
		}
		//ѡ�޿γ�
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
		//�ҵ��ý�ʦ����רҵ��
		CoursesExample coursesExample = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteriaCourses = coursesExample.createCriteria();
		criteriaCourses.andTermidEqualTo(termid);
		criteriaCourses.andTeacheridEqualTo(teacherid);
		List<Courses> listCourses = coursesMapper.selectByExample(coursesExample);
		for (Courses courses : listCourses) {
			list.addAll(curriculumTransform(courses, null));
		}
		//�ҵ��ý�ʦ����ѡ�޿�
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
		//�ҵ�����רҵ��
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		criteria.andTermidEqualTo(termid);
		List<Courses> listCourses = coursesMapper.selectByExample(example);
		for (Courses courses : listCourses) {
			//ת���ܿγ̵ĸ�ʽ
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
		//����ѡ�޿�id��ѯѧ���ɼ���
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		//�����ɼ���
		for (Stuscore stuscore : listStuscore) {
			int id = stuscore.getStudentid();
			//����ѧ��ѧ�Ų�ѯѧ��
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
		//�ȸ��ݰ༶�ҵ�����ѧ��
		StudentExample studentExample = new StudentExample();
		com.cn.bean.StudentExample.Criteria studentCriteria = studentExample.createCriteria();
		studentCriteria.andClassesidEqualTo(classesid);
		List<Student> listStudent = studentMapper.selectByExample(studentExample);
		StuscoreExample stuscoreExample = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria stuscoreCriteria = stuscoreExample.createCriteria();
		//���ѧ������
		stuscoreCriteria.andTermidEqualTo(termid);
		//����ѧ������
		for (Student student : listStudent) {
			//���ѧ������
			stuscoreCriteria.andStudentidEqualTo(student.getId());
			//�ҵ�һ��ѧ�ڸ�ѧ�������гɼ�����
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
			//����רҵ��id��ѧ�Ų����ѧ���ÿγ̵ĳɼ�
			criteria.andCouresidEqualTo(beanStuscore.getCurriculumId());
			criteria.andStudentidEqualTo(beanStuscore.getStudentid());
			List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
			Stuscore stuscore = listStuscore.get(0);
			String strScore = beanStuscore.getScore();
			//���óɼ�
			stuscore.setScore(strScore);
			//���㼨�㡣������㹫ʽ������=���ɼ�-50��+���ɼ�%10 /10��
			Integer score = new Integer(strScore);
			Double point = new Double((score-50)+((score%10)/10));
			//���ü���
			stuscore.setPoint(point);
			//��ӵ����ݿ���
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
			//����ѡ�޿�id��ѧ�Ų����ѧ���ÿγ̵ĳɼ�
			criteria.andElectiveidEqualTo(beanStuscore.getCurriculumId());
			criteria.andStudentidEqualTo(beanStuscore.getStudentid());
			List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
			Stuscore stuscore = listStuscore.get(0);
			String strScore = beanStuscore.getScore();
			//���óɼ�
			stuscore.setScore(strScore);
			//���㼨�㡣������㹫ʽ������=���ɼ�-50��+���ɼ�%10 /10��
			Integer score = new Integer(strScore);
			Double point = new Double((score-50)+((score%10)/10));
			//���ü���
			stuscore.setPoint(point);
			//��ӵ����ݿ���
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
			//ת�����ַ��������ڼ�
			String day = checkNameUtils.transformDay(elective.getDay());
			String time = day+" "+elective.getTime()+"��";
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
		//�������е�ѧ���ɼ�
		for (Stuscore stuscore : listStuscore) {
			//��ѯ�óɼ���Ӧ��ѧ����Ϣ
			Student student = studentMapper.selectByPrimaryKey(stuscore.getStudentid());
			Integer curriculumId = 0;
			if (stuscore.getCouresid()!=0) { //רҵ�εĳɼ�
				curriculumId = stuscore.getCouresid();
			} else { //ѡ�޿εĳɼ�
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
		//����ѧ���ҵ�ѧ��
		Student student = studentMapper.selectByPrimaryKey(studentid);
		BeanCet beanCet = new BeanCet(checkNameUtils.searchByCetId(gradecet.getCetid()), gradecet.getCettime(), 
				gradecet.getCetscore(), checkNameUtils.searchByClassesId(student.getClassesid()), student.getName(), studentid);
		return beanCet;
	}

	@Override
	public List<BeanArrange> changeAllCurriculumarrangeIntoBeanArrange(List<Curriculumarrange> listCurr) {
		List<BeanArrange> list = new ArrayList<>();
		for (Curriculumarrange arrange : listCurr) {
			//�ҵ��γ�����
			String name = checkNameUtils.searchByCoursesId(arrange.getCoursesid());
			//ƴ���Ͽ�����
			String day = checkNameUtils.transformDay(arrange.getDay());
			String time = arrange.getTime();
			//����ƴ��
			String date = day+"<br />"+time+"��";
			//�ҵ���ʦ����
			String teacher = checkNameUtils.searchByTeacherId(arrange.getTeacherid());
			//�ҵ��༶����
			String classes = checkNameUtils.searchByClassesId(arrange.getClassesid());
			BeanArrange bean = new BeanArrange(name, arrange.getWeek(), date, arrange.getPlace(), teacher, classes);
			list.add(bean);
		}
		return list;
	}

}
