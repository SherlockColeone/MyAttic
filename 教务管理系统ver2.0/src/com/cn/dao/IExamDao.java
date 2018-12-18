package com.cn.dao;

import java.util.Map;

import com.cn.bean.Exam;

/**
 * 考试类接口
 * @author Sherlock
 *
 */
public interface IExamDao {
	
	/**
	 * 添加考试信息
	 * @param vo 考试对象
	 * @return 已添加的列的数量
	 */
	public int doExam(Exam vo);
	
	/**
	 * 根据id删除考试信息
	 * @param id 考试id
	 * @return 已删除的列的数量
	 */
	public int delExamById(int id);
	
	/**
	 * 修改考试信息
	 * @param vo 考试对象
	 * @return 已修改的列的数量
	 */
	public int updateExam(Exam vo);
	
	/**
	 * 根据id查询考试信息
	 * @param id 考试id
	 * @return 考试对象
	 */
	public Exam findExamById(int id);
	
	/**
	 * 查找所有考试
	 * @return 查询的考试集合
	 */
	public Map<Integer,Exam> findAllExam();
	
	/**
	 * 根据班级编号查找所有考试
	 * @param classesid 班级编号
	 * @return 一个班的考试集合
	 */
	public Map<Integer,Exam> findAllExamByClassesid(int classesid);
	
	/**
	 * 根据监考老师工号查找所有考试
	 * @param teacherid 监考老师工号
	 * @return 某位监考老师的考试集合
	 */
	public Map<Integer,Exam> findAllExamByTeacherid(int teacherid);
	
	/**
	 * 清空所有考试信息
	 * @return 已删除的列的数量
	 */
	public int delAllExam();
}
