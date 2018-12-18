package com.cn.dao;

import java.util.Map;

import com.cn.bean.Elective;

/**
 * ѡ�޿γ���ӿ�
 * @author Sherlock
 *
 */
public interface IElectiveDao {
	/**
	 * ���ѡ�޿γ���Ϣ
	 * @param vo ѡ�޿γ̶���
	 * @return ����ӵ��е�����
	 */
	public int doElective(Elective vo);
	
	/**
	 * ����ѡ�޿�idɾ��ѡ�޿γ���Ϣ
	 * @param id ѡ�޿�id
	 * @return ��ɾ�����е�����
	 */
	public int delElectiveById(int id);
	
	/**
	 * �޸�ѡ�޿γ���Ϣ
	 * @param vo ѡ�޿γ̶���
	 * @return ���޸ĵ��е�����
	 */
	public int updateElective(Elective vo);
	
	/**
	 * ����ѡ�޿�id��ѯѡ�޿γ���Ϣ
	 * @param id ѡ�޿�id
	 * @return ѡ�޿γ̶���
	 */
	public Elective findElectiveById(int id);
	
	/**
	 * ��������ѡ�޿γ�
	 * @return ���е�ѡ�޿γ̼���
	 */
	public Map<Integer,Elective> findAllElective();

	/**
	 * ����ѧ��id��������ѡ�޿γ�
	 * @param termid
	 * @return һ��ѧ������ѡ�޿γ̼���
	 */
	public Map<Integer,Elective> findAllElectiveByTermid(int termid);
	
	/**
	 * ����ѧ��id�ͽ��ҹ��Ų�������ѡ�޿γ�
	 * @param termid ѧ��id
	 * @param teacherid ���ҹ���
	 * @return һ��ѧ��ĳλ��ʦ��ѡ�޿γ̼���
	 */
	public Map<Integer,Elective> findAllElectiveByTermidAndTeacherid(int termid,int teacherid);
}
