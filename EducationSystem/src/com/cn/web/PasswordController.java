package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;

/**
 * 	进入密码管理的控制器
 * @author Sherlock
 *
 */

@Controller
public class PasswordController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/password")
	public String password(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取用户对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//根据不同身份把用户账号添加到视图中
		if(student!=null) { //学生
			request.setAttribute("id", student.getId());
		}
		else if(teacher!=null) { //教师
			request.setAttribute("id", teacher.getId());
		}
		else if(admin!=null) { //管理员
			request.setAttribute("id", admin.getId());
		}
		//跳转到密码管理页面
		return "password";
	}
	
	@RequestMapping(value="/modifyPassword")
	public String modifyPassword(HttpServletRequest request,String pwd,String newPwd) {
		HttpSession session = request.getSession();
		//从session域中获取用户对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		
		//根据不同身份进行修改密码并把用户账号添加到视图中
		if(student!=null) { //学生
			request.setAttribute("id", student.getId());
			//获取修改的返回值
			int result = serviceStudent.modifyStudentPwd(student.getId(), pwd, newPwd);
			//将返回值传到
			request.setAttribute("result", result);
		}
		else if(teacher!=null) { //教师
			request.setAttribute("id", teacher.getId());
			int result = serviceTeacher.modifyTeacherPwd(teacher.getId(), pwd, newPwd);
			request.setAttribute("result", result);
		}
		else if(admin!=null) { //管理员
			request.setAttribute("id", admin.getId());
			int result = serviceAdmin.modifyAdminPwd(admin.getId(), pwd, newPwd);
			request.setAttribute("result", result);
		}
		//跳转到密码管理页面
		return "password";
	}
	
	@RequestMapping(value="/resetPassword")
	public String resetPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取用户对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//根据不同身份把用户账号添加到视图中
		if(student!=null) { //学生
			request.setAttribute("id", student.getId());
		}
		else if(teacher!=null) { //教师
			request.setAttribute("id", teacher.getId());
		}
		else if(admin!=null) { //管理员
			request.setAttribute("id", admin.getId());
		}
		//跳转到密码管理页面
		return "password";
	}
}
