package com.cn.dbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 连接数据库
 * @author Sherlock
 *
 */
public class BaseDao {
	private String driverClass = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/edusystem?characterEncoding=utf-8";
	private String user = "root";
	private String password = "123456";
	
	/**
	 * 获得数据库的连接
	 * @return 数据库的连接
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn Connection对象
	 * @param ps PreparedStatement对象
	 * @param rs ResultSet对象
	 */
	public void closeResource(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新（增、删、改）数据
	 * @param sql sql语句
	 * @param objs 需要处理的占位符，传入若干个Object对象
	 * @return 已更新的列的数量
	 */
	public int update(String sql,Object... objs) {
		int i = 0;
		Connection conn = getConnection();
		PreparedStatement ps = null;
		if(conn!=null) {
			try {
				ps = conn.prepareStatement(sql);
				if(objs!=null&&objs.length>0) {
					for (int j = 0; j < objs.length; j++) {
						ps.setObject(j+1, objs[j]);
					}
				}
				i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			finally {
				closeResource(conn, ps, null);
			}
		}
		return i;
	}
	
	/**
	 * 执行查询数据
	 * @param sql sql语句
	 * @param clazz 要查询的表的实体类（是类不是对象）
	 * @param objs 需要处理的占位符
	 * @return 查询出来的数据集合
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T>Map<Integer,T> query(String sql,Class clazz,Object... objs){
		Map<Integer,T> map = new HashMap<>();
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(conn!=null) {
			try {
				ps = conn.prepareStatement(sql);
				if(objs!=null&&objs.length>0) {
					for (int i = 0; i < objs.length; i++) {
						ps.setObject(i+1, objs[i]);
					}
				}
				rs = ps.executeQuery();
				ResultSetMetaData rm = rs.getMetaData();
				int num = rm.getColumnCount();
				while(rs.next()) {
					Object obj = clazz.newInstance();
					Integer id = 0;
					for (int i = 1; i <= num; i++) {
						String name = rm.getColumnName(i);
						Field f = clazz.getDeclaredField(name);
						f.setAccessible(true);
						Object object = rs.getObject(i);
						f.set(obj, object);
						//当反射到id的列时，获取id
						if(i==1) {
							id = (Integer)object;
						}
					}
					//将对象存储到map集合中，id为键，对象为值
					map.put(id, (T)obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeResource(conn, ps, rs);
			}
		}
		return map;
	}
}
