package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;

/**
 * 	进入密码管理的控制器
 * @author Sherlock
 *
 */

@Controller
public class PasswordController {
	
	@RequestMapping(value="/password")
	public String password(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取用户对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//把用户账号添加到视图中
		request.setAttribute("studentId", student.getId());
		//跳转到学生个人中心
		return "student/student_password";
	}
	
	@RequestMapping(value="/modifyPassword")
	public String modifyPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把学生添加到视图中
		request.setAttribute("studentId", student.getId());
		//跳转到学生个人中心
		return "student/student_password";
	}
}
