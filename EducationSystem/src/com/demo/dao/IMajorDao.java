package com.demo.dao;

import java.util.Map;

import com.cn.bean.Major;

/**
 * 专业类接口
 * @author Sherlock
 *
 */
public interface IMajorDao {
	
	/**
	 * 根据专业id查询专业信息
	 * @param id 专业id
	 * @return 专业对象
	 */
	public Major findMajorById(int id);
	
	/**
	 * 根据二级学院id查询所有专业
	 * @param academyid 专业id
	 * @return 专业对象
	 */
	public Map<Integer,Major> findAllMajorByAcademyId(int academyid);
	
	/**
	 * 查找所有专业
	 * @return 查询的专业集合
	 */
	public Map<Integer,Major> findAllMajor();
	
	/**
	 * 添加专业信息
	 * @param vo 专业对象
	 * @return 已添加的列的数量
	 */
	public int doMajor(Major vo);
	
	/**
	 * 根据id删除专业信息
	 * @param id 专业id
	 * @return 已删除的列的数量
	 */
	public int delMajorById(int id);
	
	/**
	 * 修改专业信息
	 * @param vo 专业对象
	 * @return 已修改的列的数量
	 */
	public int updateMajor(Major vo);
}
