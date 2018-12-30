package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;

/**
 * 	进入学生密码管理的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentPasswordController {
	
	@RequestMapping(value="/studentPassword")
	public String studentPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把学生添加到视图中
		request.setAttribute("studentId", student.getId());
		//跳转到学生个人中心
		return "student/student_password";
	}
	
	@RequestMapping(value="/studentPassword")
	public String studentModifyPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把学生添加到视图中
		request.setAttribute("studentId", student.getId());
		//跳转到学生个人中心
		return "student/student_password";
	}
}
