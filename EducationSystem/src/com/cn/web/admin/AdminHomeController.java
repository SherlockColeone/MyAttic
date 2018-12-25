package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;

/**
 * 	进入管理员个人中心的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminHomeController {
	
	@RequestMapping(value="/adminHome")
	public String adminHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Admin admin = (Admin) session.getAttribute("admin");
		//把管理员添加到视图中
		mv.addObject("admin", admin);
		//跳转到管理员个人中心
		return "teacher/teacher_home";
	}
	
}
