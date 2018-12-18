package com.cn.dao;

import java.util.Map;

import com.cn.bean.TempElective;

/**
 * ѡ�α�����¼��ӿ�
 * @author Sherlock
 *
 */
public interface ITempElectiveDao {
	
	/**
	 * ���ѡ�α�����¼��Ϣ
	 * @param vo ѡ�α�����¼����
	 * @return ����ӵ��е�����
	 */
	public int doTempElective(TempElective vo);
	
	/**
	 * ����ѡ�α�����¼idɾ��ѡ�α�����¼��Ϣ
	 * @param id ѡ�α�����¼id
	 * @return ��ɾ�����е�����
	 */
	public int delTempElectiveById(int id);
	
	/**
	 * �޸�ѡ�α�����¼��Ϣ
	 * @param vo ѡ�α�����¼����
	 * @return ���޸ĵ��е�����
	 */
	public int updateTempElective(TempElective vo);
	
	/**
	 * ����ѡ�α�����¼id��ѯѡ�α�����¼��Ϣ
	 * @param id ѡ�α�����¼id
	 * @return ѡ�α�����¼����
	 */
	public TempElective findTempElectiveById(int id);
	
	/**
	 * ��������ѡ�α�����¼
	 * @return ���е�ѡ�α�����¼����
	 */
	public Map<Integer,TempElective> findAllTempElective();
	
	/**
	 * ���ݿ���ѧ�Ų�������ѡ�α�����¼
	 * @param studentid ѧ��
	 * @return ����ѧ����ѡ�α�����¼����
	 */
	public Map<Integer,TempElective> findAllTempElectiveByStudentid(int studentid);
	
	/**
	 * ����ѡ�޿�id��������ѡ�α�����¼
	 * @param electiveid ѡ�޿�id
	 * @return ����ѧ����ѡ�α�����¼����
	 */
	public Map<Integer,TempElective> findAllTempElectiveByElectiveid(int electiveid);
}
