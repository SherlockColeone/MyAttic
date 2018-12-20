package com.demo.dao;

import java.util.Map;

import com.cn.bean.GradeCet;

/**
 * ��ῼ�Գɼ���ӿ�
 * @author Sherlock
 *
 */
public interface IGradeCetDao {
	
	/**
	 * �����ῼ�Գɼ���Ϣ
	 * @param vo ��ῼ�Գɼ�����
	 * @return ����ӵ��е�����
	 */
	public int doGradeCet(GradeCet vo);
	
	/**
	 * ������ῼ�Գɼ�idɾ����ῼ�Գɼ���Ϣ
	 * @param id ��ῼ�Գɼ�id
	 * @return ��ɾ�����е�����
	 */
	public int delGradeCetById(int id);
	
	/**
	 * �޸���ῼ�Գɼ���Ϣ
	 * @param vo ��ῼ�Գɼ�����
	 * @return ���޸ĵ��е�����
	 */
	public int updateGradeCet(GradeCet vo);
	
	/**
	 * ������ῼ�Գɼ�id��ѯ��ῼ�Գɼ���Ϣ
	 * @param id ��ῼ�Գɼ�id
	 * @return ��ῼ�Գɼ�����
	 */
	public GradeCet findGradeCetById(int id);
	
	/**
	 * ����������ῼ�Գɼ�
	 * @return ���е���ῼ�Գɼ�����
	 */
	public Map<Integer,GradeCet> findAllGradeCet();
	
	/**
	 * ����ѧ�Ų�ѯѧ����������ῼ�Գɼ���Ϣ
	 * @param studentid ѧ��
	 * @return ��ѧ������ῼ�Գɼ�����
	 */
	public Map<Integer,GradeCet> findAllGradeCetByStudentid(int studentid);
	
	/**
	 * ����ѧ������ῼ��id��ѯѧ������ῼ�Գɼ���Ϣ
	 * @param studentid ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Գɼ�����
	 */
	public GradeCet findGradeCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * ���ݿ�����Ų�ѯ�ÿ�������ῼ�Գɼ���Ϣ
	 * @param classroomid �������
	 * @return �ÿ�������ῼ�Գɼ�����
	 */
	public Map<Integer,GradeCet> findAllGradeCetByClassroomid(int classroomid);
	
	/**
	 * ���ݼ࿼��ʦ���Ų�ѯ�ÿ�������ῼ�Գɼ���Ϣ
	 * @param teacherid �࿼��ʦ����
	 * @return �ü࿼��ʦ����ῼ�Գɼ�����
	 */
	public Map<Integer,GradeCet> findAllGradeCetByTeacherid(int teacherid);
}
