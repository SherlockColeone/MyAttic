package com.cn.dao;

import java.util.Map;

import com.cn.bean.Admin;

/**
 * 管理员接口
 * @author Sherlock
 *
 */
public interface IAdminDao {
	
	/**
	 * 添加管理员信息
	 * @param vo 管理员对象
	 * @return 已添加的列的数量
	 */
	public int doAdmin(Admin vo);
	
	/**
	 * 根据工号删除管理员信息
	 * @param id 工号
	 * @return 已删除的列的数量
	 */
	public int delAdminById(int id);
	
	/**
	 * 修改管理员信息
	 * @param vo 管理员对象
	 * @return 已修改的列的数量
	 */
	public int updateAdmin(Admin vo);
	
	/**
	 * 根据工号查询管理员信息
	 * @param id 工号
	 * @return 管理员对象
	 */
	public Admin findAdminById(int id);
	
	/**
	 * 根据工号更改学生密码
	 * @param id 工号
	 * @param pwd 修改的密码
	 * @return 已修改的列的数量
	 */
	public int updatePasswordById(int id,String pwd);
	
	/**
	 * 根据工号重置管理员密码（重置为123456）
	 * @param id 工号
	 * @return 已修改的列的数量
	 */
	public int updateInitPasswordById(int id);
	
	/**
	 * 查找所有管理员
	 * @return 查询的管理员集合
	 */
	public Map<Integer,Admin> findAllAdmin();
	
	/**
	 * 根据工号与输入的密码查询管理员，若为空说明无此数据
	 * @param id 工号
	 * @param pwd 输入的密码
	 * @return 管理员对象
	 */
	public Admin findAdminByIdAndPwd(int id,String pwd);
}
