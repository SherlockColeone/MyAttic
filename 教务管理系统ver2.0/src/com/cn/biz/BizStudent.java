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
 * ѧ�����߼���
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
	 * ѧ����¼������ѧ����������������ѧ���Ƿ����
	 * @param studentid ѧ��ѧ��
	 * @param pwd ���������
	 * @return ѧ�����󣬷��ؿ���˵���������Ϣ����
	 */
	public Student studentLogin(int studentid,String pwd) {
		return studentDao.findStudentByIdAndPwd(studentid, pwd);
	}
	
	/**
	 * ��ѯѧ��������Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return ��ѯ������ѧ������
	 */
	public Student searchStudentById(int studentid) {
		return studentDao.findStudentById(studentid);
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
	 * ��ѯ��ͬѧ�ں�һ���༶������רҵ��
	 * @param termid ѧ��id
	 * @param classesid �༶���
	 * @return һ��ѧ��һ���༶��רҵ�μ���
	 */
	public Map<Integer,Courses> searchAllCoursesByTermidAndClassesid(int termid,int classesid) {
		return coursesDao.findAllCoursesByTermidAndClassesId(termid, classesid);
	}
		
	/**
	 * ��ѯһ��ѧ����ͬѧ�ڵ�����ѧ���ɼ�
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return һ��ѧ��һ��ѧ�ڵ�ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> searchAllStuScoreByStudentidAndTermid(int studentid,int termid){
		return stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
	}
	
	/**
	 * ����ѡ�޿�id��ѯѡ�޿�
	 * @param id ѡ�޿�id
	 * @return ��ѯ��ѡ�޿�
	 */
	public Elective searchElectiveById(int id){
		return electiveDao.findElectiveById(id);
	}
	
	/**
	 * ����ѧ�ź�ѧ��id��ѯ��ѧ�ڵ�ѡ�ν��
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return ��ѧ��ѡ�޿ζ��󣬷��ؿ���˵����ѧ��û��ѡ�޿�
	 */
	public Elective searchElectiveByStudentidAndTermid(int studentid,int termid) {
		//���ұ�ѧ�ڸ�ѧ�������пγ�
		Map<Integer,StuScore> mapStuScore = stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
		//�������пγ�
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getElectiveid();
			//�жϸÿγ��Ƿ�Ϊѡ�޿�
			if(id!=0) {
				//��Ϊѡ�޿���ͨ��ѡ�޿�id��ѯ
				return searchElectiveById(id);
			}
		}
		//���Ҳ����򷵻ؿ�
		return null;
	}
	
	/**
	 * ѧ�����ѡ��
	 * @param studentid ѧ��
	 * @param electiveid ѡ�޿�id
	 * @return �Ƿ���ӳɹ�
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
	 * ѧ���޸�ѡ��
	 * @param tempid ѡ�޿α�����¼id
	 * @param electiveid �޸ĺ��ѡ�޿�id
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyTempElectiveByStudentid(int tempid,int electiveid) {
		//���ҵ�ԭ���ļ�¼
		TempElective tempElective = tempElectiveDao.findTempElectiveById(tempid);
		//�ٽ����޸�
		TempElective vo = new TempElective(tempid, electiveid, tempElective.getStudentid());
		if(tempElectiveDao.updateTempElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ѧ����ѯ���б�������ѡ�ν��
	 * @param studentid ѧ��
	 * @return ѡ�μ�¼����
	 */
	public Map<Integer,TempElective> searchAllTempElectiveByStudentid(int studentid){
		return tempElectiveDao.findAllTempElectiveByStudentid(studentid);
	}
	
	/**
	 * ��ѯһ��ѧ��һ��ѧ�ڵ����пγ̣�רҵ�μ���ѡ�޿Σ�
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return һ��ѧ��һ��ѧ�ڵ����пγ�
	 */
	public Map<Integer,Curriculum> searchCurriculumByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//ͨ��ѧ���ɼ����ѯ����רҵ����ѡ�޿�
		Map<Integer,StuScore> mapStuScore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (StuScore stuScore : mapStuScore.values()) {
			//�ֱ�ͨ�����Ե�id��ѯרҵ����ѡ�޿�
			int electiveid = stuScore.getElectiveid();
			if(electiveid!=0) {
				//רҵ��
				Courses courses = coursesDao.findCoursesById(stuScore.getCoursesid());
				mapCurr.putAll(curriculumTransform(courses, null));
			}
			else {
				//ѡ�޿�
				Elective elective = electiveDao.findElectiveById(stuScore.getElectiveid());
				mapCurr.putAll(curriculumTransform(null, elective));
			}
		}
		return mapCurr;
	}
	
	/**
	 * ��ѯһ����ʦһ��ѧ�ڵ�����רҵ��
	 * @param teacherid ��ʦ����
	 * @param termid ѧ��id
	 * @return һ����ʦһ��ѧ�ڵ�����רҵ�μ���
	 */
	public Map<Integer,Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid,int termid){
		return coursesDao.findAllCoursesByTermidAndTeacherid(termid, teacherid);
	}
	
	/**
	 * ��ѯ�༶�ĵ��ΰ���
	 * @param classesid �༶id
	 * @return ��������е��ΰ���
	 */
	public Map<Integer,CurriculumArrange> searchAllCoursesArrangeByClassesid(int classesid){
		return curriculumArrangeDao.findAllCurriculumArrangeByClassesid(classesid);
	}
	
	/**
	 * ��ѯ����Ŀ��԰���
	 * @param classesid �༶���
	 * @return �༶�Ŀ��԰��ż���
	 */
	public Map<Integer,Exam> searchAllExamByClassesid(int classesid){
		return examDao.findAllExamByClassesid(classesid);
	}
	
	/**
	 * �޸�ѧ����������
	 * @param studentid ѧ��ѧ��
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyStudentPwd(int studentid,String newPwd) {
		return studentDao.updatePasswordById(studentid, newPwd);
	}
	
	/**
	 * ���鲢����ѧ������
	 * @param studentid ѧ��ѧ��
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyStudentPwd(int studentid,String pwd,String newPwd,String rePwd) {
		//��ȡ��ѧ�������ݿ��е�����
		String password = studentDao.findStudentById(studentid).getPassword();
		if(pwd!=password) { //�����������ԭʼ���벻��
			return -2;
		}
		else if(newPwd!=rePwd){ //���ĵ�������ȷ�����벻��
			return -1;
		}
		else {
			return modifyStudentPwd(studentid, newPwd);
		}
	}
	
	/**
	 * ѧ��������ῼ��
	 * @param studentid
	 * @param cetid
	 * @return �Ƿ����ɹ�
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
	 * ѧ����ѯ������ῼ�Ա�����¼
	 * @param studentid ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�����¼
	 */
	public EnrollCet searchEnrollCetByStudentidAndCetid(int studentid,int cetid) {
		return enrollCetDao.findEnrollCetByStudentidAndCetid(studentid, cetid);
	}
	
	/**
	 * ������ѯĳ����ῼ�Գɼ��Ϳ��԰���
	 * @param studentid
	 * @param cetid
	 * @return ��ῼ�Գɼ�����
	 */
	public GradeCet searchGradeCetByStudentidAndCetid(int studentid,int cetid) {
		return gradeCetDao.findGradeCetByStudentidAndCetid(studentid, cetid);
	}
	
	/**
	 * ������ѯ����������ῼ�Գɼ�
	 * @param studentid ѧ��
	 * @return ��ῼ�Գɼ�����
	 */
	public Map<Integer,GradeCet> searchAllGradeCetByStudentid(int studentid){
		return gradeCetDao.findAllGradeCetByStudentid(studentid);
	}
	
	/**
	 * ��ѯ��ѧ�ڵ�������ῼ��
	 * @param termid ѧ��id
	 * @return ��ѧ�ڵ���ῼ�Լ���
	 */
	public Map<Integer,Cet> searchAllCet(int termid){
		return cetDao.findAllCetByTermid(termid);
	}
	
	/**
	 * ����ѧ����ѧ�ڲ�ѯ����רҵ�γ�
	 * @param studentid ѧ��
	 * @param termid ѧ��
	 * @return רҵ�γ̼���
	 */
	public Map<Integer,Courses> searchAllCoursesByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Courses> mapCourses = new HashMap<>();
		//���ҵ���ѧ�����пγ�
		Map<Integer,StuScore> mapStuScore = stuScoreDao.findAllStuScoreByTermidAndStudentid(termid, studentid);
		for (StuScore stuScore : mapStuScore.values()) {
			int id = stuScore.getCoursesid();
			//���ҵ�רҵ��
			if(id!=0) {
				mapCourses.put(id, coursesDao.findCoursesById(id));
			}
		}
		return mapCourses;
	}
	
	/**
	 * ����ѧ����ѧ���ҵ�����רҵ����ʦ
	 * @param studentid ѧ��
	 * @param termid ѧ��
	 * @return רҵ����ʦ����
	 */
	public Map<Integer,Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid,int termid){
		Map<Integer,Teacher> mapTeacher = new HashMap<>();
		//���ҵ���ѧ������רҵ��
		Map<Integer,Courses> mapCourses = searchAllCoursesByStudentidAndTermid(studentid, termid);
		for (Courses courses : mapCourses.values()) {
			//ͨ���γ��ҵ���Ӧ���ο���ʦ
			mapTeacher.put(courses.getTeacherid(), teacherDao.findTeacherById(courses.getTeacherid()));
		}
		return mapTeacher;
	}
	
	/**
	 * ѧ����ӽ�ʦ����
	 * @return ��ӵ�������
	 */
	public int addEvaluationByTeacherid(Evaluation vo) {
		return evaluationDao.doEvaluation(vo);
	}
	
}
