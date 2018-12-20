package com.demo.dao;

import java.util.Map;

import com.cn.bean.EnrollCet;

/**
 * 社会考试报名报名类接口
 * @author Sherlock
 *
 */
public interface IEnrollCetDao {
	
	/**
	 * 添加社会考试报名信息
	 * @param vo 社会考试报名对象
	 * @return 已添加的列的数量
	 */
	public int doEnrollCet(EnrollCet vo);
	
	/**
	 * 根据社会考试报名id删除社会考试报名信息
	 * @param id 社会考试报名id
	 * @return 已删除的列的数量
	 */
	public int delEnrollCetById(int id);
	
	/**
	 * 修改社会考试报名信息
	 * @param vo 社会考试报名对象
	 * @return 已修改的列的数量
	 */
	public int updateEnrollCet(EnrollCet vo);
	
	/**
	 * 根据社会考试报名id查询社会考试报名信息
	 * @param id 社会考试报名id
	 * @return 社会考试报名对象
	 */
	public EnrollCet findEnrollCetById(int id);
	
	/**
	 * 查找所有社会考试报名
	 * @return 所有的社会考试报名集合
	 */
	public Map<Integer,EnrollCet> findAllEnrollCet();
	
	/**
	 * 根据考生学号查找所有社会考试报名
	 * @param studentid 考生学号
	 * @return 所有考生的社会考试报名集合
	 */
	public Map<Integer,EnrollCet> findAllEnrollCetByStudentid(int studentid);
	
	/**
	 * 根据学号和社会考试id查询社会考试报名信息
	 * @param studentid 学号
	 * @param cetid 社会考试id
	 * @return 社会考试报名信息对象
	 */
	public EnrollCet findEnrollCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * 清空所有社会考试报名
	 * @return 已删除的列的数量
	 */
	public int delAllEnrollCet();
	
	/**
	 * 根据社会考试id查找所有社会考试报名
	 * @param cetid 社会考试id
	 * @return 所有考生的社会考试报名集合
	 */
	public Map<Integer,EnrollCet> findAllEnrollCetByCetid(int cetid);
}
