package com.demo.dao;

import java.util.Map;

import com.cn.bean.Academy;

/**
 * 二级学院类接口
 * @author Sherlock
 *
 */
public interface IAcademyDao {
	
	/**
	 * 根据二级学院id查询二级学院信息
	 * @param id 二级学院id
	 * @return 二级学院对象
	 */
	public Academy findAcademyById(int id);
	
	/**
	 * 查找所有二级学院
	 * @return 查询的二级学院集合
	 */
	public Map<Integer,Academy> findAllAcademy();
}
