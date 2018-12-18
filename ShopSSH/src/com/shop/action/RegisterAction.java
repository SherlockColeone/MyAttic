package com.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.User;
import com.shop.utils.UUIDUtlis;
import com.yueqian.service.UserService;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	private User user;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//判断两次密码是否一致
		
		//传导逻辑层
		userService = (UserService) ac.getBean("UserService");
		
		// 自己手动封装一些表单中没有字段信息
		user.setUid(UUIDUtlis.getUUID());
		user.setTelephone(null);
		user.setState(0);
		user.setCode(null);
		//传到逻辑层
		userService.addUser(user);
		return SUCCESS;
	}

	@Override
	public User getModel() {		
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
