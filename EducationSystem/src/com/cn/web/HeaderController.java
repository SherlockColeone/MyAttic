package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;

/**
 * 	header的控制器
 * @author Sherlock
 *
 */

@Controller
public class HeaderController {
	
	/**
	 * 	进入header的控制器
	 * @return 进入header
	 */
	@RequestMapping(value="/header")
	public String header(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//对象添加到视图中
		mv.addObject("student", student);
		mv.addObject("teacher", teacher);
		mv.addObject("admin", admin);
		//进入header
		return "header";
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//在session域中移除对象
		session.removeAttribute("student");
		session.removeAttribute("teacher");
		session.removeAttribute("admin");
		return "redirect:index";
	}
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request) {
		
		return "";
	}
	
}
