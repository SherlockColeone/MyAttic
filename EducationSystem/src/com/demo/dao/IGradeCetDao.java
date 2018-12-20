package com.demo.dao;

import java.util.Map;

import com.cn.bean.GradeCet;

/**
 * 社会考试成绩类接口
 * @author Sherlock
 *
 */
public interface IGradeCetDao {
	
	/**
	 * 添加社会考试成绩信息
	 * @param vo 社会考试成绩对象
	 * @return 已添加的列的数量
	 */
	public int doGradeCet(GradeCet vo);
	
	/**
	 * 根据社会考试成绩id删除社会考试成绩信息
	 * @param id 社会考试成绩id
	 * @return 已删除的列的数量
	 */
	public int delGradeCetById(int id);
	
	/**
	 * 修改社会考试成绩信息
	 * @param vo 社会考试成绩对象
	 * @return 已修改的列的数量
	 */
	public int updateGradeCet(GradeCet vo);
	
	/**
	 * 根据社会考试成绩id查询社会考试成绩信息
	 * @param id 社会考试成绩id
	 * @return 社会考试成绩对象
	 */
	public GradeCet findGradeCetById(int id);
	
	/**
	 * 查找所有社会考试成绩
	 * @return 所有的社会考试成绩集合
	 */
	public Map<Integer,GradeCet> findAllGradeCet();
	
	/**
	 * 根据学号查询学生的所有社会考试成绩信息
	 * @param studentid 学号
	 * @return 该学生的社会考试成绩集合
	 */
	public Map<Integer,GradeCet> findAllGradeCetByStudentid(int studentid);
	
	/**
	 * 根据学号与社会考试id查询学生的社会考试成绩信息
	 * @param studentid 学号
	 * @param cetid 社会考试id
	 * @return 社会考试成绩对象
	 */
	public GradeCet findGradeCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * 根据考场编号查询该考场的社会考试成绩信息
	 * @param classroomid 考场编号
	 * @return 该考场的社会考试成绩集合
	 */
	public Map<Integer,GradeCet> findAllGradeCetByClassroomid(int classroomid);
	
	/**
	 * 根据监考老师工号查询该考场的社会考试成绩信息
	 * @param teacherid 监考老师工号
	 * @return 该监考老师的社会考试成绩集合
	 */
	public Map<Integer,GradeCet> findAllGradeCetByTeacherid(int teacherid);
}
