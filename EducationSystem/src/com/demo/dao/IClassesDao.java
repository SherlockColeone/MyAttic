package com.demo.dao;

import java.util.Map;

import com.cn.bean.Classes;

/**
 * �༶��ӿ�
 * @author Sherlock
 *
 */
public interface IClassesDao {
	
	/**
	 * ���ݰ༶id��ѯ�༶��Ϣ
	 * @param id �༶id
	 * @return �༶����
	 */
	public Classes findClassesById(int id);
	
	/**
	 * ����רҵid��ѯ���а༶
	 * @param majorid רҵid
	 * @return �༶����
	 */
	public Map<Integer,Classes> findAllClassesByMajorId(int majorid);
	
	/**
	 * �������а༶
	 * @return ��ѯ�İ༶����
	 */
	public Map<Integer,Classes> findAllClasses();
	
	/**
	 * ��Ӱ༶��Ϣ
	 * @param vo �༶����
	 * @return ����ӵ��е�����
	 */
	public int doClasses(Classes vo);
	
	/**
	 * ����idɾ���༶��Ϣ
	 * @param id �༶id
	 * @return ��ɾ�����е�����
	 */
	public int delClassesById(int id);
	
	/**
	 * �޸İ༶��Ϣ
	 * @param vo �༶����
	 * @return ���޸ĵ��е�����
	 */
	public int updateClasses(Classes vo);
}
