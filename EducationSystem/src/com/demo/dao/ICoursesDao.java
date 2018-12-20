package com.demo.dao;

import java.util.Map;

import com.cn.bean.Courses;

/**
 * 专业课程类接口
 * @author Sherlock
 *
 */
public interface ICoursesDao {
	
	/**
	 * 添加专业课程信息
	 * @param vo 专业课程对象
	 * @return 已添加的列的数量
	 */
	public int doCourses(Courses vo);
	
	/**
	 * 根据专业课id删除专业课程信息
	 * @param id 专业课id
	 * @return 已删除的列的数量
	 */
	public int delCoursesById(int id);
	
	/**
	 * 修改专业课程信息
	 * @param vo 专业课程对象
	 * @return 已修改的列的数量
	 */
	public int updateCourses(Courses vo);
	
	/**
	 * 根据专业课id查询专业课程信息
	 * @param id 专业课id
	 * @return 专业课程对象
	 */
	public Courses findCoursesById(int id);
	
	/**
	 * 查找所有专业课程
	 * @return 所有的专业课程集合
	 */
	public Map<Integer,Courses> findAllCourses();
	
	/**
	 * 根据学期id和班级id查找所有专业课程
	 * @param termid 学期id
	 * @param classesid 班级id
	 * @return 一个学期某个班级的专业课程集合
	 */
	public Map<Integer,Courses> findAllCoursesByTermidAndClassesId(int termid,int classesid);
	
	/**
	 * 根据学期id和教师工号查找所有专业课程
	 * @param termid 学期id
	 * @param teacherid 教师工号
	 * @return 一个学期某位教师的专业课程集合
	 */
	public Map<Integer,Courses> findAllCoursesByTermidAndTeacherid(int termid,int teacherid);
}
