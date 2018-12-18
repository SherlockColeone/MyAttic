package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.User;
import com.yueqian.service.UserService;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		
		HttpSession session = req.getSession();
		
		
		// 获取浏览器中存储的cookie信息
		Cookie[] cookies = req.getCookies();
		String cookie_username = null;
		String cookie_password = null;
		if(cookies!=null)
		{
			// 遍历
			for (Cookie cookie : cookies) {
				 if("cookie_username".equals(cookie.getName()))
				 {
					 // 如果相等，说明找到了我们存储的cookie信息
					cookie_username =  cookie.getValue();
					 
				 }
				 if("cookie_password".equals(cookie.getName()))
				 {
					 cookie_password =  cookie.getValue();
				 }
			}
		}
		
		// 判断
		if(cookie_username!=null&&cookie_password!=null)
		{
			UserService service = new UserService();
			User user = null;
			user = service.login(cookie_username,cookie_password);	
		  //将user信息存储在session中
			session.setAttribute("user", user);
		}
		
		
		// 放行请求
	   chain.doFilter(req, rep);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
