package com.cn.dao;

import java.util.Map;

import com.cn.bean.StuScore;

/**
 * 学生成绩类接口
 * @author Sherlock
 *
 */
public interface IStuScoreDao {
	
	/**
	 * 添加学生成绩信息
	 * @param vo 学生成绩对象
	 * @return 已添加的列的数量
	 */
	public int doStuScore(StuScore vo);
	
	/**
	 * 根据id删除学生成绩信息
	 * @param id id
	 * @return 已删除的列的数量
	 */
	public int delStuScoreById(int id);
	
	/**
	 * 修改学生成绩信息
	 * @param vo 学生成绩对象
	 * @return 已修改的列的数量
	 */
	public int updateStuScore(StuScore vo);
	
	/**
	 * 根据id查询学生成绩信息
	 * @param id id
	 * @return 学生成绩对象
	 */
	public StuScore findStuScoreById(int id);
	
	/**
	 * 查找所有学生成绩
	 * @return 所有的学生成绩集合
	 */
	public Map<Integer,StuScore> findAllStuScore();
	
	/**
	 * 根据学期id和学号查找所有学生成绩
	 * @param termid 学期id
	 * @param studentid 学号
	 * @return 一个学期某位学生的学生成绩集合
	 */
	public Map<Integer,StuScore> findAllStuScoreByTermidAndStudentid(int termid,int studentid);
	
	/**
	 * 根据专业课id查询学生成绩信息
	 * @param coursesid 专业课id
	 * @return 该专业课的学生成绩集合
	 */
	public Map<Integer,StuScore> findAllStuScoreByCoursesid(int coursesid);
	
	/**
	 * 根据选修课id查询学生成绩信息
	 * @param electiveid 选修课id
	 * @return 该选修课的学生成绩集合
	 */
	public Map<Integer,StuScore> findAllStuScoreByElectiveid(int electiveid);
}
