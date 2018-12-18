package com.shop.admin.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.User;
import com.yueqian.service.UserService;

/**
 * 管理员登录Action
 * @author Sherlock
 *
 */
public class AdminLoginAction implements ModelDriven<User>{
	private User user = new User();
	private UserService userService;
	
	public String login() {
//		ServletContext servletContext = ServletActionContext.getRequest().getServletContext();
//		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService) ac.getBean("UserService");
		//获取session域
		Map<String, Object> session = ActionContext.getContext().getSession();		
		//从业务层找到用户
		user = userService.login(user.getUsername(), user.getPassword());
		//保存user对象
		session.put("user",user);
		return "success";
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
