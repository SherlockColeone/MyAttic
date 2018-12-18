package com.cn.dao;

import java.util.Map;

import com.cn.bean.Cet;

/**
 * 社会考试类接口
 * @author Sherlock
 *
 */
public interface ICetDao {
	
	/**
	 * 添加社会考试信息
	 * @param vo 社会考试对象
	 * @return 已添加的列的数量
	 */
	public int doCet(Cet vo);
	
	/**
	 * 根据社会考试id删除社会考试信息
	 * @param id 社会考试id
	 * @return 已删除的列的数量
	 */
	public int delCetById(int id);
	
	/**
	 * 修改社会考试信息
	 * @param vo 社会考试对象
	 * @return 已修改的列的数量
	 */
	public int updateCet(Cet vo);
	
	/**
	 * 根据社会考试id查询社会考试信息
	 * @param id 社会考试id
	 * @return 社会考试对象
	 */
	public Cet findCetById(int id);
	
	/**
	 * 查找所有社会考试
	 * @return 所有的社会考试集合
	 */
	public Map<Integer,Cet> findAllCet();
	
	/**
	 * 查找所有社会考试
	 * @param termid 学期id
	 * @return 所有的社会考试集合
	 */
	public Map<Integer,Cet> findAllCetByTermid(int termid);
}
