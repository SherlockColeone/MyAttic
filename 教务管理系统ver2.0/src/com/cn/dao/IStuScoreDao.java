package com.cn.dao;

import java.util.Map;

import com.cn.bean.StuScore;

/**
 * ѧ���ɼ���ӿ�
 * @author Sherlock
 *
 */
public interface IStuScoreDao {
	
	/**
	 * ���ѧ���ɼ���Ϣ
	 * @param vo ѧ���ɼ�����
	 * @return ����ӵ��е�����
	 */
	public int doStuScore(StuScore vo);
	
	/**
	 * ����idɾ��ѧ���ɼ���Ϣ
	 * @param id id
	 * @return ��ɾ�����е�����
	 */
	public int delStuScoreById(int id);
	
	/**
	 * �޸�ѧ���ɼ���Ϣ
	 * @param vo ѧ���ɼ�����
	 * @return ���޸ĵ��е�����
	 */
	public int updateStuScore(StuScore vo);
	
	/**
	 * ����id��ѯѧ���ɼ���Ϣ
	 * @param id id
	 * @return ѧ���ɼ�����
	 */
	public StuScore findStuScoreById(int id);
	
	/**
	 * ��������ѧ���ɼ�
	 * @return ���е�ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> findAllStuScore();
	
	/**
	 * ����ѧ��id��ѧ�Ų�������ѧ���ɼ�
	 * @param termid ѧ��id
	 * @param studentid ѧ��
	 * @return һ��ѧ��ĳλѧ����ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> findAllStuScoreByTermidAndStudentid(int termid,int studentid);
	
	/**
	 * ����רҵ��id��ѯѧ���ɼ���Ϣ
	 * @param coursesid רҵ��id
	 * @return ��רҵ�ε�ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> findAllStuScoreByCoursesid(int coursesid);
	
	/**
	 * ����ѡ�޿�id��ѯѧ���ɼ���Ϣ
	 * @param electiveid ѡ�޿�id
	 * @return ��ѡ�޿ε�ѧ���ɼ�����
	 */
	public Map<Integer,StuScore> findAllStuScoreByElectiveid(int electiveid);
}
