package com.cn.dao;

import java.util.Map;

import com.cn.bean.TempElective;

/**
 * 选课报名记录类接口
 * @author Sherlock
 *
 */
public interface ITempElectiveDao {
	
	/**
	 * 添加选课报名记录信息
	 * @param vo 选课报名记录对象
	 * @return 已添加的列的数量
	 */
	public int doTempElective(TempElective vo);
	
	/**
	 * 根据选课报名记录id删除选课报名记录信息
	 * @param id 选课报名记录id
	 * @return 已删除的列的数量
	 */
	public int delTempElectiveById(int id);
	
	/**
	 * 修改选课报名记录信息
	 * @param vo 选课报名记录对象
	 * @return 已修改的列的数量
	 */
	public int updateTempElective(TempElective vo);
	
	/**
	 * 根据选课报名记录id查询选课报名记录信息
	 * @param id 选课报名记录id
	 * @return 选课报名记录对象
	 */
	public TempElective findTempElectiveById(int id);
	
	/**
	 * 查找所有选课报名记录
	 * @return 所有的选课报名记录集合
	 */
	public Map<Integer,TempElective> findAllTempElective();
	
	/**
	 * 根据考生学号查找所有选课报名记录
	 * @param studentid 学号
	 * @return 所有学生的选课报名记录集合
	 */
	public Map<Integer,TempElective> findAllTempElectiveByStudentid(int studentid);
	
	/**
	 * 根据选修课id查找所有选课报名记录
	 * @param electiveid 选修课id
	 * @return 所有学生的选课报名记录集合
	 */
	public Map<Integer,TempElective> findAllTempElectiveByElectiveid(int electiveid);
}
