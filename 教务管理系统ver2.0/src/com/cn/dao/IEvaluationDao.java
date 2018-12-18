package com.cn.dao;

import java.util.Map;

import com.cn.bean.Evaluation;

/**
 * ��ѧ������ӿ�
 * @author Sherlock
 *
 */
public interface IEvaluationDao {
	
	/**
	 * ��ӽ�ѧ������Ϣ
	 * @param vo ��ѧ���۶���
	 * @return ����ӵ��е�����
	 */
	public int doEvaluation(Evaluation vo);
	
	/**
	 * ����idɾ����ѧ������Ϣ
	 * @param id id
	 * @return ��ɾ�����е�����
	 */
	public int delEvaluationById(int id);
	
	/**
	 * �޸Ľ�ѧ������Ϣ
	 * @param vo ��ѧ���۶���
	 * @return ���޸ĵ��е�����
	 */
	public int updateEvaluation(Evaluation vo);
	
	/**
	 * ����id��ѯ��ѧ������Ϣ
	 * @param id id
	 * @return ��ѧ���۶���
	 */
	public Evaluation findEvaluationById(int id);
	
	/**
	 * �������н�ѧ����
	 * @return ���еĽ�ѧ���ۼ���
	 */
	public Map<Integer,Evaluation> findAllEvaluation();
	
	/**
	 * ���ݽ�ʦ���Ų�ѯ��ѧ����
	 * @param teacherid ��ʦ����
	 * @return �ý�ʦ�����н�ѧ����
	 */
	public Map<Integer,Evaluation> findAllEvaluationByteacherid(int teacherid);
}
