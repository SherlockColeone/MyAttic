package com.yueqian.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.User;
import com.yueqian.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public Boolean addUser(User user) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ac.getBean("UserDao");
		// 调用dao层
		int i = userDao.addUser(user);
		return i > 0 ? true : false;
	}

	public User login(String username, String password) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ac.getBean("UserDao");
		return userDao.login(username, password);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
