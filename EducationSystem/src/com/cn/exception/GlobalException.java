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
		String error = "ҳ��������쳣����";
		//��ʾ������Ϣ
		mv.addObject("error",error);
		//��ת���쳣��ʾҳ��
		mv.setViewName("excption/error");
		return mv;
	}

}
