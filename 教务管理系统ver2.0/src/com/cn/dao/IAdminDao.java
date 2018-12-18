package com.cn.dao;

import java.util.Map;

import com.cn.bean.Admin;

/**
 * ����Ա�ӿ�
 * @author Sherlock
 *
 */
public interface IAdminDao {
	
	/**
	 * ��ӹ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return ����ӵ��е�����
	 */
	public int doAdmin(Admin vo);
	
	/**
	 * ���ݹ���ɾ������Ա��Ϣ
	 * @param id ����
	 * @return ��ɾ�����е�����
	 */
	public int delAdminById(int id);
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return ���޸ĵ��е�����
	 */
	public int updateAdmin(Admin vo);
	
	/**
	 * ���ݹ��Ų�ѯ����Ա��Ϣ
	 * @param id ����
	 * @return ����Ա����
	 */
	public Admin findAdminById(int id);
	
	/**
	 * ���ݹ��Ÿ���ѧ������
	 * @param id ����
	 * @param pwd �޸ĵ�����
	 * @return ���޸ĵ��е�����
	 */
	public int updatePasswordById(int id,String pwd);
	
	/**
	 * ���ݹ������ù���Ա���루����Ϊ123456��
	 * @param id ����
	 * @return ���޸ĵ��е�����
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * �������й���Ա
	 * @return ��ѯ�Ĺ���Ա����
	 */
	public Map<Integer,Admin> findAllAdmin();
	
	/**
	 * ���ݹ���������������ѯ����Ա����Ϊ��˵���޴�����
	 * @param id ����
	 * @param pwd ���������
	 * @return ����Ա����
	 */
	public Admin findAdminByIdAndPwd(int id,String pwd);
}
