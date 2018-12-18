package com.cn.dao;

import java.util.Map;

import com.cn.bean.Cet;

/**
 * ��ῼ����ӿ�
 * @author Sherlock
 *
 */
public interface ICetDao {
	
	/**
	 * �����ῼ����Ϣ
	 * @param vo ��ῼ�Զ���
	 * @return ����ӵ��е�����
	 */
	public int doCet(Cet vo);
	
	/**
	 * ������ῼ��idɾ����ῼ����Ϣ
	 * @param id ��ῼ��id
	 * @return ��ɾ�����е�����
	 */
	public int delCetById(int id);
	
	/**
	 * �޸���ῼ����Ϣ
	 * @param vo ��ῼ�Զ���
	 * @return ���޸ĵ��е�����
	 */
	public int updateCet(Cet vo);
	
	/**
	 * ������ῼ��id��ѯ��ῼ����Ϣ
	 * @param id ��ῼ��id
	 * @return ��ῼ�Զ���
	 */
	public Cet findCetById(int id);
	
	/**
	 * ����������ῼ��
	 * @return ���е���ῼ�Լ���
	 */
	public Map<Integer,Cet> findAllCet();
	
	/**
	 * ����������ῼ��
	 * @param termid ѧ��id
	 * @return ���е���ῼ�Լ���
	 */
	public Map<Integer,Cet> findAllCetByTermid(int termid);
}
