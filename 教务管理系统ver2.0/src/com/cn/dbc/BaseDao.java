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
 * �������ݿ�
 * @author Sherlock
 *
 */
public class BaseDao {
	private String driverClass = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/edusystem?characterEncoding=utf-8";
	private String user = "root";
	private String password = "123456";
	
	/**
	 * ������ݿ������
	 * @return ���ݿ������
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
	 * �ر���Դ
	 * @param conn Connection����
	 * @param ps PreparedStatement����
	 * @param rs ResultSet����
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
	 * ���£�����ɾ���ģ�����
	 * @param sql sql���
	 * @param objs ��Ҫ�����ռλ�����������ɸ�Object����
	 * @return �Ѹ��µ��е�����
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
	 * ִ�в�ѯ����
	 * @param sql sql���
	 * @param clazz Ҫ��ѯ�ı��ʵ���ࣨ���಻�Ƕ���
	 * @param objs ��Ҫ�����ռλ��
	 * @return ��ѯ���������ݼ���
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
						//�����䵽id����ʱ����ȡid
						if(i==1) {
							id = (Integer)object;
						}
					}
					//������洢��map�����У�idΪ��������Ϊֵ
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
