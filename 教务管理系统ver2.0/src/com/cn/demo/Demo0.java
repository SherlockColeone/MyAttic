package com.cn.demo;

import java.sql.Connection;

import org.junit.Test;

import com.cn.dbc.BaseDao;

/**
 * 数据库连接类测试类
 * @author Sherlock
 *
 */
public class Demo0 {
	BaseDao bd = new BaseDao();
	
	/**
	 * 测试getConnection()方法
	 */
	@Test
	public void test1() {
		Connection conn = bd.getConnection();
		if(conn!=null) {
			System.out.println("连接成功！");
		}
	}
	
}
