package com.cn.dao;

import java.util.Map;

import com.cn.bean.Teacher;

/**
 * 教师类接口
 * @author Sherlock
 *
 */
public interface ITeacherDao {
	
	/**
	 * 添加教师信息
	 * @param vo 教师对象
	 * @return 已添加的列的数量
	 */
	public int doTeacher(Teacher vo);
	
	/**
	 * 根据工号删除教师信息
	 * @param id 工号
	 * @return 已删除的教师的列数量
	 */
	public int delTeacherById(int id);
	
	/**
	 * 修改教师信息
	 * @param vo 教师对象
	 * @return 已修改的教师的列数量
	 */
	public int updateTeacher(Teacher vo);
	
	/**
	 * 根据工号查询教师信息
	 * @param id 工号
	 * @return 教师对象
	 */
	public Teacher findTeacherById(int id);
	
	/**
	 * 根据班级编号查询该班级的教师名单
	 * @param academyid 二级学院编号
	 * @return 二级学院的所有教师集合
	 */
	public Map<Integer,Teacher> findAllTeacherByAcademyid(int academyid);
	
	/**
	 * 根据工号更改学生密码
	 * @param id 工号
	 * @param pwd 修改的密码
	 * @return 已修改的列的数量
	 */
	public int updatePasswordById(int id,String pwd);
	
	/**
	 * 根据工号重置教师密码（重置为123456）
	 * @param id 工号
	 * @return 已修改的列的数量
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * 根据工号与输入的密码查询教师，若为空说明无此数据
	 * @param id 工号
	 * @param pwd 输入的密码
	 * @return 教师对象
	 */
	public Teacher findTeacherByIdAndPwd(int id,String pwd);
}
