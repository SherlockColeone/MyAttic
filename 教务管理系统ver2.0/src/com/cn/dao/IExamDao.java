package com.cn.dao;

import java.util.Map;

import com.cn.bean.Exam;

/**
 * ������ӿ�
 * @author Sherlock
 *
 */
public interface IExamDao {
	
	/**
	 * ��ӿ�����Ϣ
	 * @param vo ���Զ���
	 * @return ����ӵ��е�����
	 */
	public int doExam(Exam vo);
	
	/**
	 * ����idɾ��������Ϣ
	 * @param id ����id
	 * @return ��ɾ�����е�����
	 */
	public int delExamById(int id);
	
	/**
	 * �޸Ŀ�����Ϣ
	 * @param vo ���Զ���
	 * @return ���޸ĵ��е�����
	 */
	public int updateExam(Exam vo);
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param id ����id
	 * @return ���Զ���
	 */
	public Exam findExamById(int id);
	
	/**
	 * �������п���
	 * @return ��ѯ�Ŀ��Լ���
	 */
	public Map<Integer,Exam> findAllExam();
	
	/**
	 * ���ݰ༶��Ų������п���
	 * @param classesid �༶���
	 * @return һ����Ŀ��Լ���
	 */
	public Map<Integer,Exam> findAllExamByClassesid(int classesid);
	
	/**
	 * ���ݼ࿼��ʦ���Ų������п���
	 * @param teacherid �࿼��ʦ����
	 * @return ĳλ�࿼��ʦ�Ŀ��Լ���
	 */
	public Map<Integer,Exam> findAllExamByTeacherid(int teacherid);
	
	/**
	 * ������п�����Ϣ
	 * @return ��ɾ�����е�����
	 */
	public int delAllExam();
}
