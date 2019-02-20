package com.cn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();		
		String error = "页面出现了异常……";
		//显示错误信息
		mv.addObject("error",error);
		//跳转到异常提示页面
		mv.setViewName("excption/error");
		return mv;
	}

}
