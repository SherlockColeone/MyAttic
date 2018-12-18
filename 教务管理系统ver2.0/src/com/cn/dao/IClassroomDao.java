package com.cn.dao;

import java.util.Map;

import com.cn.bean.Classroom;

/**
 * 课室类接口
 * @author Sherlock
 *
 */
public interface IClassroomDao {
	
	/**
	 * 根据课室id查询课室信息
	 * @param id 课室id
	 * @return 课室对象
	 */
	public Classroom findClassroomById(int id);
	
	/**
	 * 查找所有课室
	 * @return 查询的课室集合
	 */
	public Map<Integer,Classroom> findAllClassroom();
}
