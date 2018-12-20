package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

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
public class LoginController extends AbstractController{
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher seriveTeacher;
	@Autowired
	private ServiceAdmin serivceAdmin;

	@Override
	@RequestMapping(value="/login")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/studentLogin")
	public String studentLogin(ModelAndView mv,Student student) {
		//逻辑层登录
		student = serviceStudent.studentLogin(student.getId(), student.getPassword());
		mv.addObject("student",student);
		//跳到学生首页界面
		return "student_home";
	}
	
	@RequestMapping(value="/teacherLogin")
	public String teacherLogin(ModelAndView mv,Teacher teacher) {
		//逻辑层登录
		teacher = seriveTeacher.teacherLogin(teacher.getId(), teacher.getPassword());
		mv.addObject("teacher",teacher);
		//跳到教师首页界面
		return "teacher_home";
	}
	
	@RequestMapping(value="/adminLogin")
	public String adminLogin(ModelAndView mv,Admin admin) {
		//逻辑层登录
		admin = serivceAdmin.adminLogin(admin.getId(), admin.getPassword());
		mv.addObject("admin",admin);
		//跳到教师首页界面
		return "admin_home";
	}
	
}
