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
 * 	ѧ�����߼���ʵ����
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
		//���id������
		criteria.andIdEqualTo(studentid);
		//������������
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
	 * 	��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * @param courses רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼��ϡ�
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
		//���ұ�ѧ�ڸ�ѧ�������пγ�
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> listScore = stuscoreMapper.selectByExample(example);
		//�������пγ�
		for (Stuscore stuscore : listScore) {
			int id = stuscore.getElectiveid();
			//�жϸÿγ��Ƿ�Ϊѡ�޿�
			if(id!=0) {
				//��Ϊѡ�޿���ͨ��ѡ�޿�id��ѯ
				Elective elecitve = searchElectiveById(id);
				//��ѡ�޿���ӵ�������
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
		//���ҵ�ԭ���ļ�¼
		Tempelective tempElective = tempelectiveMapper.selectByPrimaryKey(tempid);
		//�ٽ����޸�
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
		//ͨ��ѧ���ɼ����ѯ����רҵ����ѡ�޿�
		List<Stuscore> listStuscore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (Stuscore stuScore : listStuscore) {
			//�ֱ�ͨ�����Ե�id��ѯרҵ����ѡ�޿�
			int electiveid = stuScore.getElectiveid();
			if(electiveid==0) {
				//רҵ��
				Courses courses = coursesMapper.selectByPrimaryKey(stuScore.getCouresid());
				list.addAll(curriculumTransform(courses, null));
			}
			else {
				//ѡ�޿�
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

	@Override
	public List<Exam> searchAllExamByClassesid(int classesid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return examMapper.selectByExample(example);
	}
	
	@Override
	public int modifyStudentPwd(int studentid,String pwd,  String newPwd) {
		//��ȡ��ѧ�������ݿ��е�����
		String password = studentMapper.selectByPrimaryKey(studentid).getPassword();
		if(pwd.equals(password)) { //������������ԭʼ����
			Student record = new Student();
			record.setId(studentid);
			record.setPassword(newPwd);
			return studentMapper.updateByPrimaryKeySelective(record);
		}
		else { //�����������ԭʼ���벻��
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
		//�Ȳ�����е���ῼ�Գɼ�
		List<Gradecet> listAll = searchAllGradeCetByStudentid(studentid);
		List<BeanCet> list = new ArrayList<>();
		for (Gradecet gradecet : listAll) {
			if(gradecet.getCetscore()!=null) { //���гɼ�
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
		//�Ȳ�����е���ῼ�Գɼ�
		List<Gradecet> listAll = searchAllGradeCetByStudentid(studentid);
		List<BeanCet> list = new ArrayList<>();
		for (Gradecet gradecet : listAll) {
			if(gradecet.getCetscore()==null) { //��û�гɼ�
				String name = checkNameUtils.searchByCetId(gradecet.getCetid());				
				Integer qualification = 0;
				String place = null;
				if (gradecet.getClassroomid()==null) { //����δ���ſ�����֤��δ����
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
		//���ҵ���ѧ�����пγ�
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		for (Stuscore stuScore : listStuscore) {
			int id = stuScore.getCouresid();
			//���ҵ�רҵ��
			if(id!=0) {
				//��ӵ�������
				listCourses.add(coursesMapper.selectByPrimaryKey(id));
			}
		}
		return listCourses;
	}

	@Override
	public List<Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid, int termid) {
		List<Teacher> listTeacher = new ArrayList<>();
		//���ҵ���ѧ������רҵ��
		List<Courses> listCourses = searchAllCoursesByStudentidAndTermid(studentid, termid);
		for (Courses courses : listCourses) {
			//ͨ���γ��ҵ���Ӧ���ο���ʦ
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
		//��content��10�����
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
		//����10���������ַ���������
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
		if(list.size()==0) { //��δ����
			return 0;
		}
		else { //������
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
		if (listTemp.size()>0) { //֤������ѡ�޽��
			Tempelective temp = listTemp.get(0);
			//����ѡ���ѡ�޿�id����
			electiveid = temp.getElectiveid();
		}
		for (Elective elective : listElective) {
			//���Ͽ�ʱ��ƴ������
			Integer intDay = elective.getDay();
			String time = elective.getTime();
			String day = checkNameUtils.transformDay(intDay);
			time = day+" "+time;
			//��Curriculum���е�coursesid������Ƿ���ѡ��ѡ�޿Σ�0������δѡ��1������ѡ��
			Curriculum curriculum = new Curriculum(elective.getName(), time, elective.getTeacher(), 0, elective.getId());
			if (electiveid==elective.getId()) { //֤���Ǹ�ѡ�޿α�ѡ��
				//��Ǹÿγ��ѱ�ѡ��
				curriculum.setCoursesid(1);
			}
			list.add(curriculum);
		}		
		return list;
	}

}

