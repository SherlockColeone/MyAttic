package com.cn.demo;

import java.sql.Connection;

import org.junit.Test;

import com.cn.dbc.BaseDao;

/**
 * ���ݿ������������
 * @author Sherlock
 *
 */
public class Demo0 {
	BaseDao bd = new BaseDao();
	
	/**
	 * ����getConnection()����
	 */
	@Test
	public void test1() {
		Connection conn = bd.getConnection();
		if(conn!=null) {
			System.out.println("���ӳɹ���");
		}
	}
	
}
