package com.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Admin;
import com.cn.bean.AdminExample;
import com.cn.bean.AdminExample.Criteria;
import com.cn.bean.BeanElective;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.CoursesExample;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.StudentExample;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;
import com.cn.bean.TempelectiveExample;
import com.cn.dao.AdminMapper;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.MajorMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.StuscoreMapper;
import com.cn.dao.TeacherMapper;
import com.cn.dao.TempelectiveMapper;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	����Ա���߼���ʵ����
 * @author Sherlock
 *
 */
@Service
public class ServiceAdminImpl implements ServiceAdmin {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;
	@Autowired
	private TempelectiveMapper tempelectiveMapper;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private StuscoreMapper stuscoreMapper;
	

	@Override
	public Admin adminLogin(int adminid, String password) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(adminid);
		criteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public boolean addStudent(Student vo) {
		if(studentMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delStudentByStudentid(int studentid) {
		if(studentMapper.deleteByPrimaryKey(studentid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyStudent(Student vo) {
		if(studentMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student searchStudentByStudentid(int studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
	}

	@Override
	public boolean addTeacher(Teacher vo) {
		if(teacherMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delTeacherByTeacherid(int teacherid) {
		if(teacherMapper.deleteByPrimaryKey(teacherid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyTeacher(Teacher vo) {
		if(teacherMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Teacher searchTeacherByTeacherid(int teacherid) {
		return teacherMapper.selectByPrimaryKey(teacherid);
	}

	@Override
	public boolean addAdmin(Admin vo) {
		if(adminMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delAdminByAdminid(int adminid) {
		if(adminMapper.deleteByPrimaryKey(adminid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyAdmin(Admin vo) {
		if(adminMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Admin searchAdminByAdminid(int adminid) {
		return adminMapper.selectByPrimaryKey(adminid);
	}

	@Override
	public int modifyAdminPwd(int adminid, String pwd, String newPwd) {
		//��ȡ�ù���Ա�����ݿ��е�����
		String password = adminMapper.selectByPrimaryKey(adminid).getPassword();
		if(pwd.equals(password)) {
			Admin record = new Admin();
			record.setId(adminid);
			record.setPassword(newPwd);
			return adminMapper.updateByPrimaryKeySelective(record);
		}
		else { //�����������ԭʼ���벻��
			return -1;
		}
	}

	@Override
	public boolean addCourses(Courses vo) {
		if(coursesMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delCoursesByCoursesid(int coursesid) {
		if(coursesMapper.deleteByPrimaryKey(coursesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyCourses(Courses vo) {
		if(coursesMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Courses searchCoursesByCoursesid(int coursesid) {
		return coursesMapper.selectByPrimaryKey(coursesid);
	}

	@Override
	public boolean addElective(Elective vo) {		
		if(electiveMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delElectiveByElectiveid(int electiveid) {
		if(electiveMapper.deleteByPrimaryKey(electiveid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyElective(Elective vo) {
		if(electiveMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Elective searchElectiveByElectiveid(int electiveid) {
		return electiveMapper.selectByPrimaryKey(electiveid);
	}

	@Override
	public boolean modifyCurriculumArrange(Curriculumarrange vo) {
		if(curriculumarrangeMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid) {
		return curriculumarrangeMapper.selectByPrimaryKey(curriculumarrangeid);
	}

	@Override
	public boolean addExam(Exam vo) {		
		if(examMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delExamByExamid(int examid) {
		if(examMapper.deleteByPrimaryKey(examid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean clearAllExam() {
		ExamExample example = new ExamExample();
		if(examMapper.deleteByExample(example)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyExam(Exam vo) {
		if(examMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Exam searchExamByExamid(int examid) {
		return examMapper.selectByPrimaryKey(examid);
	}

	@Override
	public boolean addMajor(Major vo) {	
		if(majorMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delMajorByMajorid(int majorid) {
		if(majorMapper.deleteByPrimaryKey(majorid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyMajor(Major vo) {
		if(majorMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Major searchMajorByMajorid(int majorid) {
		return majorMapper.selectByPrimaryKey(majorid);
	}

	@Override
	public boolean addClasses(Classes vo) {
		if(classesMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delClassesByClassesid(int classesid) {
		if(classesMapper.deleteByPrimaryKey(classesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyClasses(Classes vo) {
		if(classesMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Classes searchClassesByClassesid(int classesid) {
		return classesMapper.selectByPrimaryKey(classesid);
	}

	@Override
	public boolean addCet(Cet vo) {
		if(cetMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delCetByCetid(int cetid) {
		if(cetMapper.deleteByPrimaryKey(cetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyCet(Cet vo) {
		if(cetMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Cet searchCetByCetid(int cetid) {
		return cetMapper.selectByPrimaryKey(cetid);
	}

	@Override
	public List<Gradecet> searchAllGradecetApplyByCetid(int cetid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andCetidEqualTo(cetid);
		return gradecetMapper.selectByExample(example);
	}

	@Override
	public List<Integer> searchAllGradecetApplyStudentidByCetid(int cetid) {
		List<Integer> listStudentid = new ArrayList<>();
		List<Gradecet> listGradecetApply = searchAllGradecetApplyByCetid(cetid);
		for (Gradecet gradecet : listGradecetApply) {
			listStudentid.add(gradecet.getStudentid());
		}
		return listStudentid;
	}

	@Override
	public boolean addGradeCet(Gradecet vo) {
		if(gradecetMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		if(gradecetMapper.deleteByPrimaryKey(gardecetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyGradeCet(Gradecet vo) {
		if(gradecetMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addEvaluation(Evaluation vo) {
		if(evaluationMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		if(evaluationMapper.deleteByPrimaryKey(evaluationid)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyEvaluation(Evaluation vo) {
		if(evaluationMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		return evaluationMapper.selectByPrimaryKey(evaluationid);
	}

	@Override
	public List<Tempelective> searchAllTempElective() {
		TempelectiveExample example = new TempelectiveExample();
		return tempelectiveMapper.selectByExample(example);
	}

	@Override
	public List<Tempelective> searchAllTempElectiveByElectiveid(int electiveid) {
		TempelectiveExample example = new TempelectiveExample();
		com.cn.bean.TempelectiveExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		return tempelectiveMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuscoreByElectiveid(int electiveid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		return stuscoreMapper.selectByExample(example);
	}
	
	/**
	 * �ж������ظ���ѡ�޿α�ż���
	 * @param electiveid ������ѡ�޿α��
	 * @param resultList ѡ�޿μ�¼����
	 * @return ����һ��BeanElective�����ʾ��ǰ����Ѵ��ڣ�����null��ʾ��ǰ��Ų����ڣ�������Ӹñ��
	 */
	private BeanElective remainUnique(int electiveid,List<BeanElective> resultList) {
		for (BeanElective bean : resultList) {
			if (electiveid==bean.getId()) { //��ʾ��ǰ��ż���������
				//ֱ�ӷ��ظö���
				return bean;
			}
		}	
		//����null�������ڸñ��
		return null;
	}
	
	@Override
	public List<BeanElective> showBeanElectiveList() {
		List<BeanElective> resultList = new ArrayList<>();
		List<Tempelective> list = searchAllTempElective();
		//��������ѧ������ѡ�β�ͳ�Ƴ�ÿ�ſε�����
		for (Tempelective temp : list) {
			BeanElective result = remainUnique(temp.getElectiveid(), resultList);
			if (result==null) { //��ǰѡ�α�Ų����ڣ���Ҫ�����µ�ѡ�޿�
				BeanElective bean = new BeanElective();
				//������ѡ�α�ŵ�ѡ�޿�
				bean.setId(temp.getElectiveid());
				//��ǰ����Ϊ1
				bean.setNumber(1);
				//���ÿγ������������
				resultList.add(bean);
			} else { //��ǰѡ�α���Ѵ���
				//ֱ������������һ
				result.setNumber(result.getNumber()+1);				
			} 			
		}
		List<BeanElective> listResult = new ArrayList<>();
		for (BeanElective bean : resultList) {
			Elective elective = searchElectiveByElectiveid(bean.getId());
			//��ʱ�����ʾ���д���			
			String day = checkNameUtils.transformDay(elective.getDay());
			String time = day+" "+elective.getTime()+"��";
			//���б���ÿ��BeanElective������и�ֵ
			//�ж��Ƿ�����Ӹ�ѡ�޿ε�ѧ���ɼ�����
			int isInserted = 0;//0����δ���
			if (searchAllStuscoreByElectiveid(bean.getId()).size()>0) { //֤�������
				isInserted = 1;
			}
			bean = new BeanElective(isInserted, bean.getId(), elective.getName(), elective.getWeek(), elective.getTeacherid(), 
					elective.getTeacher(), time, elective.getPlace(), bean.getNumber());
			//�������һ�������б����ظ�
			listResult.add(bean);
		}
		return listResult;
	}

	@Override
	public List<Integer> splitResult(String result) {
		List<Integer> list = new ArrayList<>();
		String[] strList = result.split("\\*");
		for (String string : strList) {
			list.add(new Integer(string));
		}
		return list;
	}

	@Override
	public boolean addStuscore(Stuscore vo) {
		if (stuscoreMapper.insert(vo)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean addStuscoreByElectiveidList(List<Integer> idList) {
		for (Integer electiveid : idList) {
			List<Tempelective> listTemp = searchAllTempElectiveByElectiveid(electiveid);
			for (Tempelective temp : listTemp) {
				Stuscore stuscore = new Stuscore(temp.getStudentid(), checkNameUtils.searchByElectiveId(temp.getElectiveid()),
						2, GetTermUtils.getCurrentTermiId(), 0, electiveid);
				stuscoreMapper.insert(stuscore);
			}
		}
		return true;
	}

	@Override
	public List<Student> searchAllStudentByClassesid(int classesid) {
		StudentExample example = new StudentExample();
		com.cn.bean.StudentExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return studentMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuscoreByCoursesid(int coursesid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andCouresidEqualTo(coursesid);
		return stuscoreMapper.selectByExample(example);
	}		
	
	@Override
	public boolean addStuscoreByElectiveidListAndClassesid(List<Integer> idList,int classesid) {
		//�������еĿγ̱��
		for (Integer coursesid : idList) {
			//���ݰ༶��Ų������е�ѧ��
			List<Student> listStudent = searchAllStudentByClassesid(classesid);
			for (Student student : listStudent) {
				//����ѧ���ɼ�
				Stuscore stuscore = new Stuscore(student.getId(), checkNameUtils.searchByCoursesId(coursesid),
						4, GetTermUtils.getCurrentTermiId(), coursesid, 0);
				stuscoreMapper.insert(stuscore);
			}
		}
		return true;
	}
	
	@Override
	public List<Courses> searchAllCoursesByClassesid(int classesid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return coursesMapper.selectByExample(example);
	}
	
	/**
	 * ��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * 
	 * @param courses  רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼���
	 */
	private List<Curriculum> curriculumTransform(Courses courses, Elective elective) {
		List<Curriculum> list = new ArrayList<>();
		// רҵ�γ�
		if (courses != null) {
			// ��ȡ�Ͽν���
			String time = courses.getTime();
			// ͨ����ȡ��������γ̴�ڣ���ȡ���һ���ַ�
			int i = new Integer(time.substring(4));
			int lesson = 0;
			// ����ȡ��2-8ʱ����2������γ��ڵڼ����
			if (i != 0) {
				lesson = i / 2;
			}
			// ����ȡ��0ʱ��Ϊ10�����ڵ�����
			else {
				lesson = 5;
			}
			// ��ȡ�γ������ڼ�
			int day = courses.getDay();
			// ��ȡ�༶����
			String classes = classesMapper.selectByPrimaryKey(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getId(), courses.getName(), courses.getWeek(), day, time, lesson,
					courses.getPlace(), courses.getTeacher(), courses.getClassesid(), courses.getTermid(),
					courses.getTeacherid(), courses.getId(), 0, classes);
			list.add(curr);
		}
		// ѡ�޿γ�
		if (elective != null) {
			String time = elective.getTime();
			int i = new Integer(time.substring(4));
			int lesson = 0;
			if (i != 0) {
				lesson = i / 2;
			} else {
				lesson = 5;
			}
			int day = elective.getDay();
			Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getWeek(), day, time,
					lesson, elective.getPlace(), elective.getTeacher(), elective.getTermid(), elective.getTeacherid(),
					0, elective.getId());
			list.add(curr);
		}
		return list;
	}	
	
	@Override
	public List<Curriculum> searchCurriculumByClassesidAndTermid(int classesid, int termid) {
		List<Curriculum> list = new ArrayList<>();
		//��ѯ����רҵ��
		List<Courses> listCourses = searchAllCoursesByClassesid(classesid);
		for (Courses courses : listCourses) {
			list.addAll(curriculumTransform(courses, null));
		}
		return list;
	}

	@Override
	public List<Stuscore> searchAllStuscoreByStudentidAndTermid(int studentid, int termid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		return stuscoreMapper.selectByExample(example);
	}

	@Override
	public List<Courses> searchAllCoursesByClassesidAndTermid(int classesid, int termid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		criteria.andTermidEqualTo(termid);
		return coursesMapper.selectByExample(example);
	}

	@Override
	public List<BeanElective> showBeanCoursesList(int classesid,int termid) {
		List<BeanElective> list = new ArrayList<>();
		List<Courses> listCourses = searchAllCoursesByClassesidAndTermid(classesid, termid);
		//�ҵ�������ѧ��һ���༶������רҵ��
		for (Courses courses : listCourses) {
			//����רҵ���Ƿ���¼��Stuscore����
			List<Stuscore> isExisted = searchAllStuscoreByCoursesid(courses.getId());
			int isInserted = 0;//0����δ���
			if (isExisted.size()==0) { //������
				isInserted = 1;
			}
			//��ʱ�����ʾ���д���			
			String day = checkNameUtils.transformDay(courses.getDay());
			String time = day+" "+courses.getTime()+"��";
			BeanElective bean = new BeanElective(isInserted, courses.getId(), courses.getName(), courses.getWeek(), 
					courses.getTeacherid(), courses.getTeacher(), time, courses.getPlace(), null);
			list.add(bean);
		}		
		return list;
	}

}
