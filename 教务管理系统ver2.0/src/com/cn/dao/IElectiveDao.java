package com.cn.dao;

import java.util.Map;

import com.cn.bean.Elective;

/**
 * 选修课程类接口
 * @author Sherlock
 *
 */
public interface IElectiveDao {
	/**
	 * 添加选修课程信息
	 * @param vo 选修课程对象
	 * @return 已添加的列的数量
	 */
	public int doElective(Elective vo);
	
	/**
	 * 根据选修课id删除选修课程信息
	 * @param id 选修课id
	 * @return 已删除的列的数量
	 */
	public int delElectiveById(int id);
	
	/**
	 * 修改选修课程信息
	 * @param vo 选修课程对象
	 * @return 已修改的列的数量
	 */
	public int updateElective(Elective vo);
	
	/**
	 * 根据选修课id查询选修课程信息
	 * @param id 选修课id
	 * @return 选修课程对象
	 */
	public Elective findElectiveById(int id);
	
	/**
	 * 查找所有选修课程
	 * @return 所有的选修课程集合
	 */
	public Map<Integer,Elective> findAllElective();

	/**
	 * 根据学期id查找所有选修课程
	 * @param termid
	 * @return 一个学期所有选修课程集合
	 */
	public Map<Integer,Elective> findAllElectiveByTermid(int termid);
	
	/**
	 * 根据学期id和教室工号查找所有选修课程
	 * @param termid 学期id
	 * @param teacherid 教室工号
	 * @return 一个学期某位教师的选修课程集合
	 */
	public Map<Integer,Elective> findAllElectiveByTermidAndTeacherid(int termid,int teacherid);
}
