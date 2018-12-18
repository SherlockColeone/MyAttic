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
 * ��ʦ���߼���
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
	 * ��ʦ��¼
	 * @param teacherid ��ʦ����
	 * @param pwd ����
	 * @return ��ѯ�Ľ�ʦ����
	 */
	public Teacher teacherLogin(int teacherid,String pwd) {
		return teacherDao.findTeacherByIdAndPwd(teacherid, pwd);
	}
	
	/**
	 * ��ʦ��ѯ������Ϣ
	 * @param id ��ʦ����
	 * @return ��ʦ����
	 */
	public Teacher searchTeacherById(int id) {
		return teacherDao.findTeacherById(id);
	}
	
	/**
	 * ��ʦ��ѯ�༶��ѧ������
	 * @param classid �༶id
	 * @return �༶��ѧ������
	 */
	public Map<Integer,Student> searchAllStudentByClassesid(int classesid){
		return studentDao.findAllStudentByClassesid(classesid);
	}	
	
	/**
	 * �޸Ľ�ʦ��������
	 * @param teacherid ��ʦ����
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyTeacherPwd(int teacherid,String newPwd) {
		return teacherDao.updatePasswordById(teacherid, newPwd);
	}
	
	/**
	 * ���鲢���Ľ�ʦ����
	 * @param teacherid ��ʦ����
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyTeacherPwd(int teacherid,String pwd,String newPwd,String rePwd) {
		//��ȡ�ý�ʦ�����ݿ��е�����
		String password = teacherDao.findTeacherById(teacherid).getPassword();
		//�����������ԭʼ���벻��
		if(pwd!=password) {
			return -2;
		}
		//���ĵ�������ȷ�����벻��
		else if(newPwd!=rePwd){
			return -1;
		}
		//��֤ͨ���������޸�����
		else {  
			return modifyTeacherPwd(teacherid, newPwd);
		}
	}
	
	/**
	 * ��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * @param courses רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼���
	 */
	public Map<Integer,Curriculum> curriculumTransform(Courses courses,Elective elective){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
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
			//ͨ���༶id�ҵ��༶����
			String classes = classesDao.findClassesById(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getName(), courses.getWeek(), day,time,lesson,courses.getPlace(),
					courses.getTeacher(), classes);
			mapCurr.put(day*10+lesson, curr);
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
			Curriculum curr = new Curriculum(elective.getName(), elective.getWeek(), day, time, lesson, 
					elective.getPlace(), elective.getTeacher());
			mapCurr.put(day*10+lesson, curr);
		}
		return mapCurr;
	}
	
	/**
	 * ��ѯĳλ��ʦһ��ѧ�ڵ����пγ̰��ţ�רҵ�μ�ѡ�޿Σ�
	 * @param termid ѧ��id
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦһ��ѧ�ڵĿγ̰��ż���
	 */
	public Map<Integer,Curriculum> searchAllCurriculByTermidAndTeacherid(int termid,int teacherid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//�ҵ��ý�ʦ����רҵ��
		Map<Integer,Courses> mapCourses = coursesDao.findAllCoursesByTermidAndTeacherid(termid, teacherid);
		for (Courses courses : mapCourses.values()) {
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		//�ҵ��ý�ʦ����ѡ�޿�
		Map<Integer,Elective> mapElective = electiveDao.findAllElectiveByTermidAndTeacherid(termid, teacherid);
		for (Elective elective : mapElective.values()) {
			mapCurr.putAll(curriculumTransform(null, elective));
		}
		return mapCurr;
	}
	
	/**
	 * ��ѯһ��ѧ��һ���༶�����пγ�
	 * @param termid ѧ��id
	 * @param classesid �༶id
	 * @return һ��ѧ��һ���༶�Ŀγ̼���
	 */
	public Map<Integer,Curriculum> searchAllCurriculByTermidAndClassesid(int termid,int classesid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//�ҵ�����רҵ��
		Map<Integer,Courses> mapCourses = coursesDao.findAllCoursesByTermidAndClassesId(termid, classesid);
		for (Courses courses : mapCourses.values()) {
			//ת���ܿγ̵ĸ�ʽ
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		return mapCurr;
	}
	
	/**
	 * ��ӵ��ΰ���
	 * @param vo ���ΰ��Ŷ���
	 * @return �Ƿ���ӳɹ�
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
	 * ��ѯĳλ��ʦ�����е��ΰ���
	 * @param teacherid ��ʦ����
	 * @return ���ΰ��ż���
	 */
	public Map<Integer,CurriculumArrange> searchAllCurriculumArrangeByTeacherid(int teacherid){
		return curriculumArrangeDao.findAllCurriculumArrangeByTeacherid(teacherid);
	}
	
	/**
	 * ��ѯ�࿼��ʦ�����п��԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ���԰��ż���
	 */
	public Map<Integer,Exam> searchAllExamByTeacherid(int teacherid){
		return examDao.findAllExamByTeacherid(teacherid);
	}
	
	/**
	 * ��ѯ�࿼��ʦ��������ῼ�԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ��ῼ�԰��ż���
	 */
	public Map<Integer,GradeCet> searchAllGradeCetByTeacherid(int teacherid){
		return gradeCetDao.findAllGradeCetByTeacherid(teacherid);
	}
	
	/**
	 * ����ѡ�޿β�ѯ��ѡ�޿ε�ѧ������
	 * @param electiveid ѡ�޿�id
	 * @return ��ѡ�޿ε�ѧ������
	 */
	public Map<Integer,Student> searchAllStudentByElectiveid(int electiveid){
		Map<Integer,Student> mapStudent = new HashMap<>();
		//����ѡ�޿�id��ѯѧ���ɼ���
		Map<Integer, StuScore> mapStuScore = stuScoreDao.findAllStuScoreByElectiveid(electiveid);
		//�����ɼ���
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getStudentid();
			//����ѧ��ѧ�Ų�ѯѧ��
			mapStudent.put(id, studentDao.findStudentById(id));
		}
		return mapStudent;
	}
	
	/**
	 * ��ѯĳһ��רҵ�ε�����ѧ���ɼ�
	 * @param coursesid רҵ��id
	 * @return ĳһ��רҵ�ε�����ѧ���ɼ�
	 */
	public Map<Integer,StuScore> searchAllStuScoreByCoursesid(int coursesid){
		return stuScoreDao.findAllStuScoreByCoursesid(coursesid);
	}
	
	/**
	 * ��ѯĳһ��ѡ�޿ε�����ѧ���ɼ�
	 * @param electiveid ѡ�޿�id
	 * @return ĳһ��ѡ�޿ε�����ѧ���ɼ�
	 */
	public Map<Integer,StuScore> searchAllStuScoreByElectiveid(int electiveid){
		return stuScoreDao.findAllStuScoreByElectiveid(electiveid);
	}
	
	/**
	 * ��ѯһ����ĳ��ѧ�ڵ�����ѧ���ɼ�
	 * @param classesid �༶���
	 * @param termid ѧ��id
	 * @return һ����һ��ѧ�ڵ�����ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> searchAllStuScoreByClassesidAndTermid(int classesid,int termid){
		Map<Integer,StuScore> mapStuScore = new HashMap<>();
		//�ȸ��ݰ༶�ҵ�����ѧ��
		Map<Integer,Student> mapStudent = studentDao.findAllStudentByClassesid(classesid);
		//����ѧ������
		for (Student student : mapStudent.values()) {
			//�ҵ�һ��ѧ�ڸ�ѧ�������гɼ�����
			mapStuScore.putAll(stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, student.getId()));
		}
		return mapStuScore;
	}
	
	/**
	 * �ϴ�һ��רҵ�εĳɼ�
	 * @param coursesid רҵ��id
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addStuScoreByCoursesid(int coursesid) {
		
		return false;
	}
	
	/**
	 * �ϴ�һ���������ѧ���ɼ�
	 * @param classesid �༶���
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addStuScoreByClassesid(int classesid) {
		
		return false;
	}
	
	/**
	 * �ϴ�ĳһ����ῼ�Գɼ�
	 * @param studentid ����ѧ��
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addGradeCetByStudentid(int studentid) {
		
		return false;
	}
	
	/**
	 * �鿴ĳλ��ʦ�����н�ѧ����
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦ�����н�ѧ���ۼ���
	 */
	public Map<Integer,Evaluation> searchAllEvaluationByTeacherid(int teacherid){
		return evaluationDao.findAllEvaluationByteacherid(teacherid);
	}
}
