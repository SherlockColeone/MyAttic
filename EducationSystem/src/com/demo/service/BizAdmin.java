package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.bean.Admin;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.CurriculumArrange;
import com.cn.bean.Elective;
import com.cn.bean.EnrollCet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.GradeCet;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.dao.IAdminDao;
import com.cn.dao.ICetDao;
import com.cn.dao.IClassesDao;
import com.cn.dao.ICoursesDao;
import com.cn.dao.ICurriculumArrangeDao;
import com.cn.dao.IElectiveDao;
import com.cn.dao.IEnrollCetDao;
import com.cn.dao.IEvaluationDao;
import com.cn.dao.IExamDao;
import com.cn.dao.IGradeCetDao;
import com.cn.dao.IMajorDao;
import com.cn.dao.IStudentDao;
import com.cn.dao.ITeacherDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.dao.impl.CetDaoImpl;
import com.cn.dao.impl.ClassesDaoImpl;
import com.cn.dao.impl.CoursesDaoImpl;
import com.cn.dao.impl.CurriculumArrangeDaoImpl;
import com.cn.dao.impl.ElectiveDaoImpl;
import com.cn.dao.impl.EnrollCetDaoImpl;
import com.cn.dao.impl.EvaluationDaoImpl;
import com.cn.dao.impl.ExamDaoImpl;
import com.cn.dao.impl.GradeCetDaoImpl;
import com.cn.dao.impl.MajorDaoImpl;
import com.cn.dao.impl.StudentDaoImpl;
import com.cn.dao.impl.TeacherDaoImpl;

/**
 * ����Ա���߼���
 * @author Sherlock
 *
 */
public class BizAdmin {
	IAdminDao adminDao = new AdminDaoImpl();
	IStudentDao studentDao = new StudentDaoImpl();
	ITeacherDao teacherDao = new TeacherDaoImpl();
	ICoursesDao coursesDao = new CoursesDaoImpl();
	IElectiveDao electiveDao = new ElectiveDaoImpl();
	ICurriculumArrangeDao curriculumArrangeDao = new CurriculumArrangeDaoImpl();
	IExamDao examDao = new ExamDaoImpl();
	ICetDao cetDao = new CetDaoImpl();
	IMajorDao majorDao = new MajorDaoImpl();
	IClassesDao classesDao = new ClassesDaoImpl();
	IEnrollCetDao enrollCetDao = new EnrollCetDaoImpl();
	IGradeCetDao gradeCetDao = new GradeCetDaoImpl();
	IEvaluationDao evaluationDao = new EvaluationDaoImpl();
	
	/**
	 * ����Ա��¼
	 * @param adminid ����Ա����
	 * @param pwd ����
	 * @return ��ѯ�Ĺ���Ա����
	 */
	public Admin adminLogin(int adminid,String pwd) {
		return adminDao.findAdminByIdAndPwd(adminid, pwd);
	}
	
	/**
	 * ����Ա���ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addStudent(Student vo) {
		if(studentDao.doStudent(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Աɾ��ѧ��ѧ����Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delStudentByStudentid(int studentid) {
		if(studentDao.delStudentById(studentid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸�ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyStudent(Student vo) {
		if(studentDao.updateStudent(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����ѧ�Ų�ѯѧ��ѧ����Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return ѧ������
	 */
	public Student searchStudentByStudentid(int studentid) {
		return studentDao.findStudentById(studentid);
	}
	
	/**
	 * ����Ա��ӽ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addTeacher(Teacher vo) {
		if(teacherDao.doTeacher(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Աɾ����ʦ��Ϣ
	 * @param teacherid ��ʦ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delTeacherByTeacherid(int teacherid) {
		if(teacherDao.delTeacherById(teacherid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸Ľ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyTeacher(Teacher vo) {
		if(teacherDao.updateTeacher(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݹ��Ų�ѯ��ʦ��Ϣ
	 * @param teacherid ��ʦ����
	 * @return ��ʦ����
	 */
	public Teacher searchTeacherByTeacherid(int teacherid) {
		return teacherDao.findTeacherById(teacherid);
	}
	
	/**
	 * ����Ա��ӹ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addAdmin(Admin vo) {
		if(adminDao.doAdmin(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Աɾ������Ա��Ϣ
	 * @param adminid ����Ա����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delAdminByAdminid(int adminid) {
		if(adminDao.delAdminById(adminid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸Ĺ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyAdmin(Admin vo) {
		if(adminDao.updateAdmin(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݹ��Ų�ѯ����Ա��Ϣ
	 * @param adminid ����Ա����
	 * @return ����Ա����
	 */
	public Admin searchAdminByAdminid(int adminid) {
		return adminDao.findAdminById(adminid);
	}
	
	/**
	 * �޸Ĺ���Ա��������
	 * @param adminid ����Աid
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyAdminPwd(int adminid,String newPwd) {
		return adminDao.updatePasswordById(adminid, newPwd);
	}
	
	/**
	 * ���鲢���Ĺ���Ա����
	 * @param adminid ����Աid
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyAdminPwd(int adminid,String pwd,String newPwd,String rePwd) {
		//��ȡ�ù���Ա�����ݿ��е�����
		String password = adminDao.findAdminById(adminid).getPassword();
		if(pwd!=password) { //�����������ԭʼ���벻��
			return -2;
		}
		else if(newPwd!=rePwd){ //���ĵ�������ȷ�����벻��
			return -1;
		}
		else {
			return modifyAdminPwd(adminid, newPwd);
		}
	}
	
	/**
	 * ����Ա���רҵ��
	 * @param vo רҵ�ζ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addCourses(Courses vo) {
		if(coursesDao.doCourses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����רҵ��idɾ��רҵ��
	 * @param coursesid רҵ��id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delCoursesByCoursesid(int coursesid) {
		if(coursesDao.delCoursesById(coursesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸�רҵ��
	 * @param vo רҵ�ζ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCourses(Courses vo) {
		if(coursesDao.updateCourses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����רҵ��id��ѯרҵ��
	 * @param coursesid רҵ��id
	 * @return רҵ�ζ���
	 */
	public Courses searchCoursesByCoursesid(int coursesid) {
		return coursesDao.findCoursesById(coursesid);
	}
	
	/**
	 * ����Ա���ѡ�޿�
	 * @param vo ѡ�޿ζ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addElective(Elective vo) {
		if(electiveDao.doElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����ѡ�޿�idɾ��ѡ�޿�
	 * @param electiveid ѡ�޿�id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delElectiveByElectiveid(int electiveid) {
		if(electiveDao.delElectiveById(electiveid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸�ѡ�޿�
	 * @param vo ѡ�޿ζ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyElective(Elective vo) {
		if(electiveDao.updateElective(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����ѡ�޿�id��ѯѡ�޿�
	 * @param electiveid ѡ�޿�id
	 * @return ѡ�޿ζ���
	 */
	public Elective searchElectiveByElectiveid(int electiveid) {
		return electiveDao.findElectiveById(electiveid);
	}
	
	/**
	 * ����Ա�޸ĵ��ΰ���
	 * @param vo ���ΰ��Ŷ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCurriculumArrange(CurriculumArrange vo) {
		if(curriculumArrangeDao.updateCurriculumArrange(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݵ���id��ѯ���ΰ���
	 * @param coursesid רҵ��id
	 * @return רҵ�ζ���
	 */
	public CurriculumArrange searchCurriculumArrangeByCurriculumArrangeid(int curriculumArrangeid) {
		return curriculumArrangeDao.findCurriculumArrangeById(curriculumArrangeid);
	}
	
	/**
	 * ����Ա��ӿ���
	 * @param vo ���Զ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addExam(Exam vo) {
		if(examDao.doExam(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݿ���idɾ������
	 * @param examid ����id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delExamByExamid(int examid) {
		if(examDao.delExamById(examid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����������п���
	 * @return �Ƿ�����ɹ�
	 */
	public boolean clearAllExam() {
		if(examDao.delAllExam()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸Ŀ���
	 * @param vo ���Զ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyExam(Exam vo) {
		if(examDao.updateExam(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݿ���id��ѯ����
	 * @param examid ����id
	 * @return ���Զ���
	 */
	public Exam searchExamByExamid(int examid) {
		return examDao.findExamById(examid);
	}
	
	/**
	 * ����Ա���רҵ
	 * @param vo רҵ����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addMajor(Major vo) {
		if(majorDao.doMajor(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����רҵidɾ��רҵ
	 * @param majorid רҵid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delMajorByMajorid(int majorid) {
		if(majorDao.delMajorById(majorid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸�רҵ
	 * @param vo רҵ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyMajor(Major vo) {
		if(majorDao.updateMajor(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա����רҵid��ѯרҵ
	 * @param majorid רҵid
	 * @return רҵ����
	 */
	public Major searchMajorByMajorid(int majorid) {
		return majorDao.findMajorById(majorid);
	}
	
	/**
	 * ����Ա��Ӱ༶
	 * @param vo �༶����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addClasses(Classes vo) {
		if(classesDao.doClasses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݰ༶idɾ���༶
	 * @param cetid �༶id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delClassesByClassesid(int classesid) {
		if(classesDao.delClassesById(classesid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸İ༶
	 * @param vo �༶����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyClasses(Classes vo) {
		if(classesDao.updateClasses(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݰ༶��Ų�ѯ�༶
	 * @param classesid �༶���
	 * @return �༶����
	 */
	public Classes searchClassesByClassesid(int classesid) {
		return classesDao.findClassesById(classesid);
	}
	
	/**
	 * ����Ա�����ῼ��
	 * @param vo ��ῼ�Զ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addCet(Cet vo) {
		if(cetDao.doCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա������ῼ��idɾ����ῼ��
	 * @param cetid ��ῼ��id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delCetByCetid(int cetid) {
		if(cetDao.delCetById(cetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸���ῼ��
	 * @param vo ��ῼ�Զ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCet(Cet vo) {
		if(cetDao.updateCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա������ῼ��id��ѯ��ῼ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Զ���
	 */
	public Cet searchCetByCetid(int cetid) {
		return cetDao.findCetById(cetid);
	}
	
	/**
	 * ����Ա��ѯĳһ����ῼ�Ե�������ῼ�Ա���
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�������
	 */
	public Map<Integer,EnrollCet> searchAllEnrollCetByCetid(int cetid){
		return enrollCetDao.findAllEnrollCetByCetid(cetid);
	}
	
	/**
	 * ����Ա��ѯĳһ����ῼ�����б�����ѧ��ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�������
	 */
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid){
		List<Integer> listStudentid = new ArrayList<>();
		Map<Integer,EnrollCet> mapEnrollCet = searchAllEnrollCetByCetid(cetid);
		for (EnrollCet enrollCet : mapEnrollCet.values()) {
			listStudentid.add(enrollCet.getStudentid());
		}
		return listStudentid;
	}
	
	/**
	 * ����Ա�����ῼ�Գɼ�
	 * @param vo ��ῼ�Գɼ�����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addGradeCet(GradeCet vo) {
		if(gradeCetDao.doGradeCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա������ῼ�Գɼ�idɾ����ῼ�Գɼ�
	 * @param cetid ��ῼ�Գɼ�id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delGradeCetByGradeCetid(int gardecetid) {
		if(gradeCetDao.delGradeCetById(gardecetid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸���ῼ�Գɼ�
	 * @param vo ��ῼ�Գɼ�����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyGradeCet(GradeCet vo) {
		if(gradeCetDao.updateGradeCet(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա��ӽ�ѧ����
	 * @param vo ��ѧ���۶���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addEvaluation(Evaluation vo) {
		if(evaluationDao.doEvaluation(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݽ�ѧ����idɾ����ѧ����
	 * @param cetid ��ѧ����id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delEvaluationByEvaluationid(int evaluationid) {
		if(evaluationDao.delEvaluationById(evaluationid)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա�޸Ľ�ѧ����
	 * @param vo ��ѧ���۶���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyEvaluation(Evaluation vo) {
		if(evaluationDao.updateEvaluation(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * ����Ա���ݽ�ѧ����id��ѯ��ѧ����
	 * @param evaluationid ��ѧ����id
	 * @return ��ѧ���۶���
	 */
	public Evaluation searchEvaluationByEvaluationid(int evaluationid) {
		return evaluationDao.findEvaluationById(evaluationid);
	}
	
}
