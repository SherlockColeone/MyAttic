package com.shop.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shop.domain.User;
import com.shop.utils.UUIDUtlis;
import com.yueqian.service.UserService;

public class RegsiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegsiterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		  
		
		User user = new User();
		user.setUsername(username);
		
		List<>
		
		lis.add
		l
		
		//1.接收用户从客户端传递过来的参数
		request.getParameter("username");
		request.getParameter("password");
		request.getParameter("username");
		request.getParameter("username");*/
		User user = new User();
		
		
		Map<String, String[]> parameterMap = request.getParameterMap();

		// 使用beanUntils将Map参数 封装到JavaBean中
		
		/**
		 * 
		 * 自动封装，前提是 map集合中key 和 javaBean的属性名称要一致!!
		 *  populate(Object bean, Map properties);
		 * 
		 */
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// 自己手动封装一些表单中没有字段信息
		user.setUid(UUIDUtlis.getUUID());
		user.setTelephone(null);
		user.setState(0);
		user.setCode(null);
				
		// 调用service层
		
		UserService service =new UserService();
		Boolean isSuccess = service.addUser(user);
		if(isSuccess)
		{
			// 成功
			System.out.println("添加数据成功~~~");
			
			// 注册成功之后应该跳转界面
			
			/**
			 * 1.跳转的界面应该是哪个界面？  login.jsp
			 * 
			 * 2.跳转界面应该使用转发还是重定向？ 
			 */
		  // request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			// 重定向操作
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			
		}
		else
		{
			// 失败
			System.out.println("添加数据失败~~~");
			
			
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
