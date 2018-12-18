package com.shop.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.User;
import com.yueqian.service.UserService;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = user.getUsername();
		String password = user.getPassword();
		//当不输入用户名或密码时不走逻辑层
		if(username=="" || password==""){
			request.setAttribute("errorMsg", "请输入用户名或密码！");
			return "goLogin";
		}
		userService = (UserService) ac.getBean("UserService");
		//用户登录
		user = userService.login(username, password);
		HttpServletResponse response = ServletActionContext.getResponse();
		if(user!=null) { //登陆成功
			//判断是否勾选自动登录
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null) { //勾选了自动登录
//				// 去实现自动登录的功能				
//				Cookie cookie_username = new Cookie("cookie_username",username);
//				Cookie cookie_password = new Cookie("cookie_password",password);
//				
//				// 设置cookie的过期时间
//				cookie_username.setMaxAge(60*60);
//				cookie_password.setMaxAge(60*60);
//				
//				// 将cookie信息写回客户端
//				response.addCookie(cookie_username);
//				response.addCookie(cookie_password);
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		else { //登录失败
			request.setAttribute("errorMsg", "登录失败");
			return "goLogin";
		}
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
