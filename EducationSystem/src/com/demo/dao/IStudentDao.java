package com.demo.dao;

import java.util.Map;

import com.cn.bean.Student;

/**
 * 学生类接口
 * @author Sherlock
 *
 */
public interface IStudentDao {
	
	/**
	 * 添加学生学籍信息
	 * @param vo 学生对象
	 * @return 已添加的列的数量
	 */
	public int doStudent(Student vo);
	
	/**
	 * 根据学号删除学生学籍信息
	 * @param id 学号
	 * @return 已删除的列的数量
	 */
	public int delStudentById(int id);
	
	/**
	 * 修改学生学籍信息
	 * @param vo 学生对象
	 * @return 已修改的列的数量
	 */
	public int updateStudent(Student vo);
	
	/**
	 * 根据学号查询学生信息
	 * @param id 学号
	 * @return 学生对象
	 */
	public Student findStudentById(int id);
	
	/**
	 * 根据班级编号查询该班级的学生名单
	 * @param classid 班级编号
	 * @return 班级的学生集合
	 */
	public Map<Integer,Student> findAllStudentByClassesid(int classesid);
	
	/**
	 * 根据学号更改学生密码
	 * @param id 学号
	 * @param newPwd 修改的密码
	 * @return 已修改的列的数量
	 */
	public int updatePasswordById(int id,String newPwd);
	
	/**
	 * 根据学号重置学生密码（重置为123456）
	 * @param id 学号
	 * @return 已修改的列的数量
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * 根据学号与输入的密码查询学生，若为空说明无此数据
	 * @param id 学号
	 * @param pwd 输入的密码
	 * @return 学生对象
	 */
	public Student findStudentByIdAndPwd(int id,String pwd);
}
