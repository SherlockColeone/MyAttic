package com.cn.utils;

/**
 * 	���ڰ�idת�������֣��������е�ʵ����
 * @author Sherlock
 *
 */
public interface CheckNameUtils {	
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
	
	/**
	 *	 �����ڵ�����ת�������ڼ��������ؿգ���˵�������ѳ���1-7
	 * @param day ��������
	 * @return �������ڼ�
	 */
	public String transformDay(Integer day);
	
	/**
	 * 	���ݽ�ʦ���Ų�ѯ��ʦ������
	 * @param teacherId ��ʦid
	 * @return ��ʦ������
	 */
	public String searchByTeacherId(Integer teacherId);
}
