package com.demo.dao;

import java.util.Map;

import com.cn.bean.Classes;

/**
 * 班级类接口
 * @author Sherlock
 *
 */
public interface IClassesDao {
	
	/**
	 * 根据班级id查询班级信息
	 * @param id 班级id
	 * @return 班级对象
	 */
	public Classes findClassesById(int id);
	
	/**
	 * 根据专业id查询所有班级
	 * @param majorid 专业id
	 * @return 班级对象
	 */
	public Map<Integer,Classes> findAllClassesByMajorId(int majorid);
	
	/**
	 * 查找所有班级
	 * @return 查询的班级集合
	 */
	public Map<Integer,Classes> findAllClasses();
	
	/**
	 * 添加班级信息
	 * @param vo 班级对象
	 * @return 已添加的列的数量
	 */
	public int doClasses(Classes vo);
	
	/**
	 * 根据id删除班级信息
	 * @param id 班级id
	 * @return 已删除的列的数量
	 */
	public int delClassesById(int id);
	
	/**
	 * 修改班级信息
	 * @param vo 班级对象
	 * @return 已修改的列的数量
	 */
	public int updateClasses(Classes vo);
}
