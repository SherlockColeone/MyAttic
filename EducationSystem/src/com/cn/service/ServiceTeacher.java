package com.cn.service;

import java.util.List;

import com.cn.bean.BeanArrange;
import com.cn.bean.BeanCet;
import com.cn.bean.BeanStuscore;
import com.cn.bean.Cet;
import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;

/**
 * 	��ʦ���߼���
 * @author Sherlock
 *
 */
public interface ServiceTeacher {
	/**
	 * 	��ʦ��¼
	 * @param teacherid ��ʦ����
	 * @param password ����
	 * @return ��ѯ�Ľ�ʦ����
	 */
	public Teacher teacherLogin(int teacherid,String password);
	
	/**
	 * 	��ʦ��ѯ������Ϣ
	 * @param id ��ʦ����
	 * @return ��ʦ����
	 */
	public Teacher searchTeacherById(int id);
	
	/**
	 * 	��ʦ��ѯ�༶��ѧ������
	 * @param classid �༶id
	 * @return �༶��ѧ������
	 */
	public List<Student> searchAllStudentByClassesid(int classesid);
	
	/**
	 * 	���鲢���Ľ�ʦ����
	 * @param teacherid ��ʦ����
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�������������ԭʼ���벻��
	 */
	public int modifyTeacherPwd(int teacherid,String pwd,String newPwd);
	
	/**
	 * 	��ѯĳλ��ʦһ��ѧ�ڵ����пγ̰��ţ�רҵ�μ�ѡ�޿Σ�
	 * @param termid ѧ��id
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦһ��ѧ�ڵĿγ̰��ż���
	 */
	public List<Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid,int teacherid);
	
	/**
	 * 	��ѯһ��ѧ��һ���༶�����пγ�
	 * @param termid ѧ��id
	 * @param classesid �༶id
	 * @return һ��ѧ��һ���༶�Ŀγ̼���
	 */
	public List<Curriculum> searchAllCurriculumByTermidAndClassesid(int termid,int classesid);
	
	/**
	 * 	��ӵ��ΰ���
	 * @param vo ���ΰ��Ŷ���
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addCurriculumArrange(Curriculumarrange vo);
	
	/**
	 * 	��ѯĳλ��ʦ�����е��ΰ���
	 * @param teacherid ��ʦ����
	 * @return ���ΰ��ż���
	 */
	public List<Curriculumarrange> searchAllCurriculumArrangeByTeacherid(int teacherid);
	
	/**
	 * 	��ѯ�࿼��ʦ�����п��԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ���԰��ż���
	 */
	public List<Exam> searchAllExamByTeacherid(int teacherid);
	
	/**
	 * 	��ѯ�࿼��ʦ��������ῼ�԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ��ῼ�԰��ż���
	 */
	public List<Gradecet> searchAllGradeCetByTeacherid(int teacherid);
	
	/**
	 * ����ĳ��ѧ��ĳ����ῼ�Գɼ�
	 * @param studentid ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Գɼ�����
	 */
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 *	 ����ѡ�޿β�ѯ��ѡ�޿ε�ѧ������
	 * @param electiveid ѡ�޿�id
	 * @return ��ѡ�޿ε�ѧ������
	 */
	public List<Student> searchAllStudentByElectiveid(int electiveid);
	
	/**
	 * 	��ѯĳһ��רҵ�ε�����ѧ���ɼ�
	 * @param coursesid רҵ��id
	 * @return ĳһ��רҵ�ε�����ѧ���ɼ�
	 */
	public List<Stuscore> searchAllStuScoreByCoursesid(int coursesid);
	
	/**
	 * 	��ѯĳһ��ѡ�޿ε�����ѧ���ɼ�
	 * @param electiveid ѡ�޿�id
	 * @return ĳһ��ѡ�޿ε�����ѧ���ɼ�
	 */
	public List<Stuscore> searchAllStuScoreByElectiveid(int electiveid);
	
	/**
	 * 	��ѯһ����ĳ��ѧ�ڵ�����ѧ���ɼ�
	 * @param classesid �༶���
	 * @param termid ѧ��id
	 * @return һ����һ��ѧ�ڵ�����ѧ���ɼ�����
	 */
	public List<Stuscore> searchAllStuScoreByClassesidAndTermid(int classesid,int termid);
	
	/**
	 * 	�ϴ�һ��רҵ�εĳɼ�
	 * @param list һ��רҵ�ε�ѧ���ɼ�
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean modifyStuScoreByCoursesid(List<BeanStuscore> list);
	
	/**
	 * 	�ϴ�һ��ѡ�޿εĳɼ�
	 * @param list һ��ѡ�޿ε�ѧ���ɼ�
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean modifyStuScoreByElectiveid(List<BeanStuscore> list);
	
	/**
	 * 	�鿴ĳλ��ʦ�����н�ѧ����
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦ�����н�ѧ���ۼ���
	 */
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid);
	
	/**
	 * 	���ݽ�ʦ������ѧ��id��ѯ����רҵ��
	 * @param teacherid ��ʦ����
	 * @param termid ѧ��id
	 * @return �ý�ʦһ��ѧ�ڵ�����רҵ�μ���
	 */
	public List<Courses> searchAllCoursesByTeacheridAndTermid(int teacherid,int termid);
	
	/**
	 * 	���ݽ�ʦ������ѧ��id��ѯ����ѡ�޿�
	 * @param teacherid ��ʦ����
	 * @param termid ѧ��id
	 * @return �ý�ʦһ��ѧ�ڵ�����ѡ�޿μ���
	 */
	public List<Elective> searchAllElectiveByTeacheridAndTermid(int teacherid,int termid);
	
	/**
	 * 	��һ��ѡ�޿μ���ת���ɿγ̼���
	 * @param listElective ѡ�޿μ���
	 * @return �γ̼���
	 */
	public List<Curriculum> changeElectiveListIntoCurriculumList(List<Elective> listElective);
	
	/**
	 * 	��һ��ѧ������ת���ɿγ̼���
	 * @param listStudent ѧ������
	 * @return �γ̼���
	 */
	public List<Curriculum> changeStudentListIntoCurriculumList(List<Student> listStudent);
	
	/**
	 * 	��һ��ѧ���ɼ�����ת����BeanStuscore����
	 * @param listStuscore ѧ���ɼ�����
	 * @return BeanStuscore����
	 */
	public List<BeanStuscore> changeStuscoreListIntoBeanStuscoreList(List<Stuscore> listStuscore);
	
	/**
	 * ���ҵ�ǰѧ�ڵ�������ῼ��
	 * @return ��ῼ�Լ���
	 */
	public List<Cet> searchAllCetByCurrentTermid();
	
	/**
	 * ����ῼ�Գɼ���ת����BeanCet��
	 * @param gradecet ��ῼ�Գɼ������
	 * @param studentid ѧ��
	 * @return BeanCet��
	 */
	public BeanCet changeGradecetIntoBeanCetByStudentid(Gradecet gradecet,int studentid);
	
	/**
	 *  ���γ̰����༯��ת����BeanArrange����
	 * @param list �γ̰����༯��
	 * @return BeanArrange����
	 */
	public List<BeanArrange> changeAllCurriculumarrangeIntoBeanArrange(List<Curriculumarrange> listCurr);
	
	public List<Evaluation> GetStatisticsByListEvaluation(List<Evaluation> listEvaluation);
	
}
