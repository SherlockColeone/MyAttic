package com.yueqian.dao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.User;

public class UserDao extends HibernateDaoSupport{
	
	public int addUser(User vo) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String str = (String) session.save(vo);
				if (str!=null) {
					return 1;
				}
				else {
					return 0;
				}
			}
		});
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 根据用户名和密码查询出来的用户
	 */
	public User login(String username, String password) {
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * from user WHERE username=? AND password = ?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0, username);
				query.setParameter(1, password);
				query.addEntity(User.class);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
	}
	
	public int delUser(int id) {
		
		return 0;
	}
	
	public int updateUser(User vo) {
		
		return 0;
	}
}
