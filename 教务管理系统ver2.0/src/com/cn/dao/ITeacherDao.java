package com.cn.dao;

import java.util.Map;

import com.cn.bean.Teacher;

/**
 * ��ʦ��ӿ�
 * @author Sherlock
 *
 */
public interface ITeacherDao {
	
	/**
	 * ��ӽ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return ����ӵ��е�����
	 */
	public int doTeacher(Teacher vo);
	
	/**
	 * ���ݹ���ɾ����ʦ��Ϣ
	 * @param id ����
	 * @return ��ɾ���Ľ�ʦ��������
	 */
	public int delTeacherById(int id);
	
	/**
	 * �޸Ľ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return ���޸ĵĽ�ʦ��������
	 */
	public int updateTeacher(Teacher vo);
	
	/**
	 * ���ݹ��Ų�ѯ��ʦ��Ϣ
	 * @param id ����
	 * @return ��ʦ����
	 */
	public Teacher findTeacherById(int id);
	
	/**
	 * ���ݰ༶��Ų�ѯ�ð༶�Ľ�ʦ����
	 * @param academyid ����ѧԺ���
	 * @return ����ѧԺ�����н�ʦ����
	 */
	public Map<Integer,Teacher> findAllTeacherByAcademyid(int academyid);
	
	/**
	 * ���ݹ��Ÿ���ѧ������
	 * @param id ����
	 * @param pwd �޸ĵ�����
	 * @return ���޸ĵ��е�����
	 */
	public int updatePasswordById(int id,String pwd);
	
	/**
	 * ���ݹ������ý�ʦ���루����Ϊ123456��
	 * @param id ����
	 * @return ���޸ĵ��е�����
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * ���ݹ���������������ѯ��ʦ����Ϊ��˵���޴�����
	 * @param id ����
	 * @param pwd ���������
	 * @return ��ʦ����
	 */
	public Teacher findTeacherByIdAndPwd(int id,String pwd);
}
