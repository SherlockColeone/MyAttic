package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;

/**
 * 	进入三种身份首页的控制器
 * @author Sherlock
 *
 */

@Controller
public class LoginController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher seriveTeacher;
	@Autowired
	private ServiceAdmin serivceAdmin;
	
	@RequestMapping(value="/studentLogin")
	public String studentLogin(ModelAndView mv,Student student,HttpServletRequest request) {
		//逻辑层登录获取学生个人信息
		student = serviceStudent.studentLogin(student.getId(), student.getPassword());
		HttpSession session = request.getSession();
		//把学生对象存入session域中
		session.setAttribute("student", student);
		//重定向学生首页界面
		return "redirect:studentHome";
	}
	
	@RequestMapping(value="/teacherLogin")
	public String teacherLogin(ModelAndView mv,Teacher teacher,HttpServletRequest request) {
		//逻辑层获取教师个人信息
		teacher = seriveTeacher.teacherLogin(teacher.getId(), teacher.getPassword());
		HttpSession session = request.getSession();
		//把教师对象存入session域中
		session.setAttribute("teacher", teacher);
		//跳到教师首页界面
		return "redirect:teacherHome";
	}
	
	@RequestMapping(value="/adminLogin")
	public String adminLogin(ModelAndView mv,Admin admin,HttpServletRequest request) {
		//逻辑层获取管理员个人信息
		admin = serivceAdmin.adminLogin(admin.getId(), admin.getPassword());
		HttpSession session = request.getSession();
		//把管理员对象存入session域中
		session.setAttribute("admin", admin);
		//跳到管理员首页界面
		return "redirect:adminHome";
	}
	
}
