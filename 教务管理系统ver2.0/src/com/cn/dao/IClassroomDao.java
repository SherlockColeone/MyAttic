package com.cn.dao;

import java.util.Map;

import com.cn.bean.Classroom;

/**
 * ������ӿ�
 * @author Sherlock
 *
 */
public interface IClassroomDao {
	
	/**
	 * ���ݿ���id��ѯ������Ϣ
	 * @param id ����id
	 * @return ���Ҷ���
	 */
	public Classroom findClassroomById(int id);
	
	/**
	 * �������п���
	 * @return ��ѯ�Ŀ��Ҽ���
	 */
	public Map<Integer,Classroom> findAllClassroom();
}
