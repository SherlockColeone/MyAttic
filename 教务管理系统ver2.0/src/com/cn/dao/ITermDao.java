package com.cn.dao;

import java.util.Map;

import com.cn.bean.Term;

/**
 * ѧ����ӿ�
 * @author Sherlock
 *
 */
public interface ITermDao {
	
	/**
	 * ����ѧ��id��ѯѧ����Ϣ
	 * @param id ѧ��id
	 * @return ѧ�ڶ���
	 */
	public Term findTermById(int id);
	
	/**
	 * ��������ѧ��
	 * @return ��ѯ��ѧ�ڼ���
	 */
	public Map<Integer,Term> findAllTerm();
}
