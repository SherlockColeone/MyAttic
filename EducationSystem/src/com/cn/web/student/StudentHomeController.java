package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Student;

/**
 * 	进入学生个人中心的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentHomeController {
	
	@RequestMapping(value="/studentHome")
	public String studentHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把学生添加到视图中
		mv.addObject("student", student);
		//跳转到学生个人中心
		return "student/student_home";
	}
	
}
