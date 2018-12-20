package com.demo.dao;

import java.util.Map;

import com.cn.bean.CurriculumArrange;

/**
 * ���ΰ�����ӿ�
 * @author Sherlock
 *
 */
public interface ICurriculumArrangeDao {
	
	/**
	 * ��ӵ��ΰ�����Ϣ
	 * @param vo ���ΰ��Ŷ���
	 * @return ����ӵ��е�����
	 */
	public int doCurriculumArrange(CurriculumArrange vo);
	
	/**
	 * ����רҵ��idɾ�����ΰ�����Ϣ
	 * @param id רҵ��id
	 * @return ��ɾ�����е�����
	 */
	public int delCurriculumArrangeById(int id);
	
	/**
	 * �޸ĵ��ΰ�����Ϣ
	 * @param vo ���ΰ��Ŷ���
	 * @return ���޸ĵ��е�����
	 */
	public int updateCurriculumArrange(CurriculumArrange vo);
	
	/**
	 * ����רҵ��id��ѯ���ΰ�����Ϣ
	 * @param id רҵ��id
	 * @return ���ΰ��Ŷ���
	 */
	public CurriculumArrange findCurriculumArrangeById(int id);
	
	/**
	 * �������е��ΰ���
	 * @return ���еĵ��ΰ��ż���
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrange();
	
	/**
	 * ���ݰ༶id��ѯ���ΰ���
	 * @param classesid �༶id
	 * @return ���еĵ��ΰ��ż���
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrangeByClassesid(int classesid);
	
	/**
	 * ���ݽ�ʦ��ѯ���ΰ���
	 * @param teacherid ��ʦ����
	 * @return ���еĵ��ΰ��ż���
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrangeByTeacherid(int teacherid);
	
	/**
	 * ����id�޸��Ƿ���׼
	 * @param id ���ΰ���id
	 * @param permit �Ƿ���׼����
	 * @return ���޸ĵ��е�����
	 */
	public int updatePermitById(int id,int permit);
	
	/**
	 * ������е��ΰ���
	 * @return ��ɾ�����е�����
	 */
	public int delAllCurriculumArrange();
}
