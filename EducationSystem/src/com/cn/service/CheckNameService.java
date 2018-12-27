package com.cn.service;

/**
 * 	���ڰ�idת�������֣���������ѧԺ��רҵ���༶
 * @author Sherlock
 *
 */
public interface CheckNameService {
	/**
	 * 	���ݶ���ѧԺ��id��ѯ����ѧԺ������
	 * @param academyId ����ѧԺid
	 * @return ����ѧԺ������
	 */
	public String searchNameByAcademyId(Integer academyId);
	
	/**
	 * 	����רҵ��id��ѯרҵ������
	 * @param majorId רҵid
	 * @return רҵ������
	 */
	public String searchNameByMajorId(Integer majorId);
	
	/**
	 * 	���ݰ༶��id��ѯ�༶������
	 * @param classesId �༶id
	 * @return �༶������
	 */
	public String searchNameByClassesId(Integer classesId);
}
