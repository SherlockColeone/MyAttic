package com.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.User;
import com.yueqian.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		
		// 接收用户传递过来的参数
		String username = request.getParameter("username");

		String password = request.getParameter("password");
		
		if(username==""||password=="")
		{
			/**
			 * 
			 * 当用户名或者密码为空的时候，后面逻辑就不要走了
			 */
			return;
		}
		
		UserService service = new UserService();
		/**
		 * 
		 * 思考：login方法的返回值是什么？
		 * 
		 * Boolean、   User
		 */
		User user = null;
		user = service.login(username,password);
		if(user!=null)
		{
			
			// 判断用户是否勾选了自动登录按钮
			String autoLoginTag = request.getParameter("autologin");
			if(autoLoginTag!=null)
			{
				// 去实现自动登录的功能
				
				Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
				Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
				
				// 设置cookie的过期时间
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				
				// 将cookie信息写回客户端
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			
			
			 // 成功
			// 将用户信息存储在sesison域中
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index");
			
		}
		else
		{
			// 失败
			/**
			 * 1.将错误信息保存在request域中
			 * 
			 * 2.转发到login.jsp 显示错误信息
			 * 
			 */
			request.setAttribute("errorMsg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
