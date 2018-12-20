package com.demo.dao;

import java.util.Map;

import com.cn.bean.EnrollCet;

/**
 * ��ῼ�Ա���������ӿ�
 * @author Sherlock
 *
 */
public interface IEnrollCetDao {
	
	/**
	 * �����ῼ�Ա�����Ϣ
	 * @param vo ��ῼ�Ա�������
	 * @return ����ӵ��е�����
	 */
	public int doEnrollCet(EnrollCet vo);
	
	/**
	 * ������ῼ�Ա���idɾ����ῼ�Ա�����Ϣ
	 * @param id ��ῼ�Ա���id
	 * @return ��ɾ�����е�����
	 */
	public int delEnrollCetById(int id);
	
	/**
	 * �޸���ῼ�Ա�����Ϣ
	 * @param vo ��ῼ�Ա�������
	 * @return ���޸ĵ��е�����
	 */
	public int updateEnrollCet(EnrollCet vo);
	
	/**
	 * ������ῼ�Ա���id��ѯ��ῼ�Ա�����Ϣ
	 * @param id ��ῼ�Ա���id
	 * @return ��ῼ�Ա�������
	 */
	public EnrollCet findEnrollCetById(int id);
	
	/**
	 * ����������ῼ�Ա���
	 * @return ���е���ῼ�Ա�������
	 */
	public Map<Integer,EnrollCet> findAllEnrollCet();
	
	/**
	 * ���ݿ���ѧ�Ų���������ῼ�Ա���
	 * @param studentid ����ѧ��
	 * @return ���п�������ῼ�Ա�������
	 */
	public Map<Integer,EnrollCet> findAllEnrollCetByStudentid(int studentid);
	
	/**
	 * ����ѧ�ź���ῼ��id��ѯ��ῼ�Ա�����Ϣ
	 * @param studentid ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�����Ϣ����
	 */
	public EnrollCet findEnrollCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * ���������ῼ�Ա���
	 * @return ��ɾ�����е�����
	 */
	public int delAllEnrollCet();
	
	/**
	 * ������ῼ��id����������ῼ�Ա���
	 * @param cetid ��ῼ��id
	 * @return ���п�������ῼ�Ա�������
	 */
	public Map<Integer,EnrollCet> findAllEnrollCetByCetid(int cetid);
}
