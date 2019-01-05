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
	public String searchByAcademyId(Integer academyId);
	
	/**
	 * 	����רҵ��id��ѯרҵ������
	 * @param majorId רҵid
	 * @return רҵ������
	 */
	public String searchByMajorId(Integer majorId);
	
	/**
	 * 	���ݰ༶��id��ѯ�༶������
	 * @param classesId �༶id
	 * @return �༶������
	 */
	public String searchByClassesId(Integer classesId);
	
	/**
	 * 	����ѧ�ڵ�id��ѯѧ�ڵ�����
	 * @param termid ѧ��id
	 * @return ѧ�ڵ�����
	 */
	public String searchByTermid(Integer termId);
	
	/**
	 * 	����רҵ�ε�id��ѯרҵ�ε�����
	 * @param coursesId רҵ��id
	 * @return רҵ�ε�����
	 */
	public String searchByCoursesId(Integer coursesId);
	
	/**
	 * 	������ῼ�Ե�id��ѯ��ῼ�Ե�����
	 * @param cetId ��ῼ��id
	 * @return ��ῼ�Ե�����
	 */
	public String searchByCetId(Integer cetId);
	
	/**
	 * 	���ݿ��ҵ�id��ѯ���ҵ�����
	 * @param classroomId ����id
	 * @return ���ҵ�����
	 */
	public String searchByClassroomId(Integer classroomId);
}
