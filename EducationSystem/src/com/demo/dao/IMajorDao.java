package com.demo.dao;

import java.util.Map;

import com.cn.bean.Major;

/**
 * רҵ��ӿ�
 * @author Sherlock
 *
 */
public interface IMajorDao {
	
	/**
	 * ����רҵid��ѯרҵ��Ϣ
	 * @param id רҵid
	 * @return רҵ����
	 */
	public Major findMajorById(int id);
	
	/**
	 * ���ݶ���ѧԺid��ѯ����רҵ
	 * @param academyid רҵid
	 * @return רҵ����
	 */
	public Map<Integer,Major> findAllMajorByAcademyId(int academyid);
	
	/**
	 * ��������רҵ
	 * @return ��ѯ��רҵ����
	 */
	public Map<Integer,Major> findAllMajor();
	
	/**
	 * ���רҵ��Ϣ
	 * @param vo רҵ����
	 * @return ����ӵ��е�����
	 */
	public int doMajor(Major vo);
	
	/**
	 * ����idɾ��רҵ��Ϣ
	 * @param id רҵid
	 * @return ��ɾ�����е�����
	 */
	public int delMajorById(int id);
	
	/**
	 * �޸�רҵ��Ϣ
	 * @param vo רҵ����
	 * @return ���޸ĵ��е�����
	 */
	public int updateMajor(Major vo);
}
