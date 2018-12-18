package com.cn.dao;

import java.util.Map;

import com.cn.bean.Term;

/**
 * 学期类接口
 * @author Sherlock
 *
 */
public interface ITermDao {
	
	/**
	 * 根据学期id查询学期信息
	 * @param id 学期id
	 * @return 学期对象
	 */
	public Term findTermById(int id);
	
	/**
	 * 查找所有学期
	 * @return 查询的学期集合
	 */
	public Map<Integer,Term> findAllTerm();
}
