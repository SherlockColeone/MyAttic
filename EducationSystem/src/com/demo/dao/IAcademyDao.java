package com.demo.dao;

import java.util.Map;

import com.cn.bean.Academy;

/**
 * ����ѧԺ��ӿ�
 * @author Sherlock
 *
 */
public interface IAcademyDao {
	
	/**
	 * ���ݶ���ѧԺid��ѯ����ѧԺ��Ϣ
	 * @param id ����ѧԺid
	 * @return ����ѧԺ����
	 */
	public Academy findAcademyById(int id);
	
	/**
	 * �������ж���ѧԺ
	 * @return ��ѯ�Ķ���ѧԺ����
	 */
	public Map<Integer,Academy> findAllAcademy();
}
