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
	
	/**
	 * 	����ѧ�ڵ�id��ѯѧ�ڵ�����
	 * @param termid ѧ��id
	 * @return ѧ�ڵ�����
	 */
	public String searchNameByTermid(Integer termId);
	
	/**
	 * 	����רҵ�ε�id��ѯרҵ�ε�����
	 * @param coursesid רҵ��id
	 * @return רҵ�ε�����
	 */
	public String searchNameByCoursesId(Integer coursesid);
}
