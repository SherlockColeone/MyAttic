package com.demo.dao;

import java.util.Map;

import com.cn.bean.Courses;

/**
 * רҵ�γ���ӿ�
 * @author Sherlock
 *
 */
public interface ICoursesDao {
	
	/**
	 * ���רҵ�γ���Ϣ
	 * @param vo רҵ�γ̶���
	 * @return ����ӵ��е�����
	 */
	public int doCourses(Courses vo);
	
	/**
	 * ����רҵ��idɾ��רҵ�γ���Ϣ
	 * @param id רҵ��id
	 * @return ��ɾ�����е�����
	 */
	public int delCoursesById(int id);
	
	/**
	 * �޸�רҵ�γ���Ϣ
	 * @param vo רҵ�γ̶���
	 * @return ���޸ĵ��е�����
	 */
	public int updateCourses(Courses vo);
	
	/**
	 * ����רҵ��id��ѯרҵ�γ���Ϣ
	 * @param id רҵ��id
	 * @return רҵ�γ̶���
	 */
	public Courses findCoursesById(int id);
	
	/**
	 * ��������רҵ�γ�
	 * @return ���е�רҵ�γ̼���
	 */
	public Map<Integer,Courses> findAllCourses();
	
	/**
	 * ����ѧ��id�Ͱ༶id��������רҵ�γ�
	 * @param termid ѧ��id
	 * @param classesid �༶id
	 * @return һ��ѧ��ĳ���༶��רҵ�γ̼���
	 */
	public Map<Integer,Courses> findAllCoursesByTermidAndClassesId(int termid,int classesid);
	
	/**
	 * ����ѧ��id�ͽ�ʦ���Ų�������רҵ�γ�
	 * @param termid ѧ��id
	 * @param teacherid ��ʦ����
	 * @return һ��ѧ��ĳλ��ʦ��רҵ�γ̼���
	 */
	public Map<Integer,Courses> findAllCoursesByTermidAndTeacherid(int termid,int teacherid);
}
