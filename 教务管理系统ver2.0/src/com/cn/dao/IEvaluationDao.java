package com.cn.dao;

import java.util.Map;

import com.cn.bean.Evaluation;

/**
 * 教学评价类接口
 * @author Sherlock
 *
 */
public interface IEvaluationDao {
	
	/**
	 * 添加教学评价信息
	 * @param vo 教学评价对象
	 * @return 已添加的列的数量
	 */
	public int doEvaluation(Evaluation vo);
	
	/**
	 * 根据id删除教学评价信息
	 * @param id id
	 * @return 已删除的列的数量
	 */
	public int delEvaluationById(int id);
	
	/**
	 * 修改教学评价信息
	 * @param vo 教学评价对象
	 * @return 已修改的列的数量
	 */
	public int updateEvaluation(Evaluation vo);
	
	/**
	 * 根据id查询教学评价信息
	 * @param id id
	 * @return 教学评价对象
	 */
	public Evaluation findEvaluationById(int id);
	
	/**
	 * 查找所有教学评价
	 * @return 所有的教学评价集合
	 */
	public Map<Integer,Evaluation> findAllEvaluation();
	
	/**
	 * 根据教师工号查询教学评价
	 * @param teacherid 教师工号
	 * @return 该教师的所有教学评价
	 */
	public Map<Integer,Evaluation> findAllEvaluationByteacherid(int teacherid);
}
