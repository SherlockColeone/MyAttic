package com.shop.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.shop.domain.User;

public class LoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session域
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if(user!=null) { //若用户不为空
			//拦截器放行
			return invocation.invoke();
		}
		else {
			return "goLogin";
		}
	}

}
