package com.demo.dao;

import java.util.Map;

import com.cn.bean.Student;

/**
 * ѧ����ӿ�
 * @author Sherlock
 *
 */
public interface IStudentDao {
	
	/**
	 * ���ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return ����ӵ��е�����
	 */
	public int doStudent(Student vo);
	
	/**
	 * ����ѧ��ɾ��ѧ��ѧ����Ϣ
	 * @param id ѧ��
	 * @return ��ɾ�����е�����
	 */
	public int delStudentById(int id);
	
	/**
	 * �޸�ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return ���޸ĵ��е�����
	 */
	public int updateStudent(Student vo);
	
	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ
	 * @param id ѧ��
	 * @return ѧ������
	 */
	public Student findStudentById(int id);
	
	/**
	 * ���ݰ༶��Ų�ѯ�ð༶��ѧ������
	 * @param classid �༶���
	 * @return �༶��ѧ������
	 */
	public Map<Integer,Student> findAllStudentByClassesid(int classesid);
	
	/**
	 * ����ѧ�Ÿ���ѧ������
	 * @param id ѧ��
	 * @param newPwd �޸ĵ�����
	 * @return ���޸ĵ��е�����
	 */
	public int updatePasswordById(int id,String newPwd);
	
	/**
	 * ����ѧ������ѧ�����루����Ϊ123456��
	 * @param id ѧ��
	 * @return ���޸ĵ��е�����
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * ����ѧ��������������ѯѧ������Ϊ��˵���޴�����
	 * @param id ѧ��
	 * @param pwd ���������
	 * @return ѧ������
	 */
	public Student findStudentByIdAndPwd(int id,String pwd);
}
