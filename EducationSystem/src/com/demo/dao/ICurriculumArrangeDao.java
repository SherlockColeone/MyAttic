package com.demo.dao;

import java.util.Map;

import com.cn.bean.CurriculumArrange;

/**
 * 调课安排类接口
 * @author Sherlock
 *
 */
public interface ICurriculumArrangeDao {
	
	/**
	 * 添加调课安排信息
	 * @param vo 调课安排对象
	 * @return 已添加的列的数量
	 */
	public int doCurriculumArrange(CurriculumArrange vo);
	
	/**
	 * 根据专业课id删除调课安排信息
	 * @param id 专业课id
	 * @return 已删除的列的数量
	 */
	public int delCurriculumArrangeById(int id);
	
	/**
	 * 修改调课安排信息
	 * @param vo 调课安排对象
	 * @return 已修改的列的数量
	 */
	public int updateCurriculumArrange(CurriculumArrange vo);
	
	/**
	 * 根据专业课id查询调课安排信息
	 * @param id 专业课id
	 * @return 调课安排对象
	 */
	public CurriculumArrange findCurriculumArrangeById(int id);
	
	/**
	 * 查找所有调课安排
	 * @return 所有的调课安排集合
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrange();
	
	/**
	 * 根据班级id查询调课安排
	 * @param classesid 班级id
	 * @return 所有的调课安排集合
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrangeByClassesid(int classesid);
	
	/**
	 * 根据教师查询调课安排
	 * @param teacherid 教师工号
	 * @return 所有的调课安排集合
	 */
	public Map<Integer,CurriculumArrange> findAllCurriculumArrangeByTeacherid(int teacherid);
	
	/**
	 * 根据id修改是否批准
	 * @param id 调课安排id
	 * @param permit 是否批准调课
	 * @return 已修改的列的数量
	 */
	public int updatePermitById(int id,int permit);
	
	/**
	 * 清空所有调课安排
	 * @return 已删除的列的数量
	 */
	public int delAllCurriculumArrange();
}
