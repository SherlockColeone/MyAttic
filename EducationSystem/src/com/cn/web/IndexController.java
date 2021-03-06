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
import com.cn.utils.GetTermUtils;

/**
 * 	进入首页与三种身份个人中心的控制器
 * @author Sherlock
 *
 */

@Controller
public class IndexController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher seriveTeacher;
	@Autowired
	private ServiceAdmin serivceAdmin;
	
	/**
	 * 	进入首页的控制器
	 * @return 进入首页登录JSP页面
	 */
	@RequestMapping(value="/index")
	public String index() {
		//进入首页登录JSP页面
		return "login";
	}
	
	/**
	 * 	进入学生个人中心的控制器
	 * @param mv ModelAndView
	 * @param student 获取表单封装的学生对象
	 * @param request 请求对象
	 * @return 重定向到学生首页界面
	 */
	@RequestMapping(value="/studentLogin")
	public String studentLogin(ModelAndView mv,Student student,HttpServletRequest request) {
		//逻辑层登录获取学生个人信息
		student = serviceStudent.studentLogin(student.getId(), student.getPassword());
		if(student==null) {
			//添加警告提示
			String warning = "账号不存在或密码输入错误！请重新输入！";
			mv.addObject("warning",warning);
			request.setAttribute("warning", warning);
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			//把学生对象存入session域中
			session.setAttribute("student", student);
			//获取当前学期并存入session中
			String term = GetTermUtils.getCurrentTerm();
			session.setAttribute("term", term);
			//重定向到学生首页界面
			return "redirect:studentHome";
		}
	}
	
	/**
	 * 	进入教师个人中心的控制器
	 * @param mv ModelAndView
	 * @param teacher 获取表单封装的教师对象
	 * @param request 请求对象
	 * @return 重定向到教师首页界面
	 */
	@RequestMapping(value="/teacherLogin")
	public String teacherLogin(ModelAndView mv,Teacher teacher,HttpServletRequest request) {
		//逻辑层获取教师个人信息
		teacher = seriveTeacher.teacherLogin(teacher.getId(), teacher.getPassword());
		if(teacher==null) {
			//添加警告提示
			String warning = "账号不存在或密码输入错误！请重新输入！";
			mv.addObject("warning",warning);
			request.setAttribute("warning", warning);
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			//把教师对象存入session域中
			session.setAttribute("teacher", teacher);
			//获取当前学期并存入session中
			String term = GetTermUtils.getCurrentTerm();
			session.setAttribute("term", term);
			//重定向到教师首页界面
			return "redirect:teacherHome";
		}
	}
	
	/**
	 * 	进入管理员个人中心的控制器
	 * @param mv ModelAndView
	 * @param admin 获取表单封装的管理员对象
	 * @param request 请求对象
	 * @return 重定向到管理员首页界面
	 */
	@RequestMapping(value="/adminLogin")
	public String adminLogin(ModelAndView mv,Admin admin,HttpServletRequest request) {
		//逻辑层获取管理员个人信息
		admin = serivceAdmin.adminLogin(admin.getId(), admin.getPassword());
		if(admin==null) {
			//添加警告提示
			String warning = "账号不存在或密码输入错误！请重新输入！";
			mv.addObject("warning",warning);
			request.setAttribute("warning", warning);
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			//把管理员对象存入session域中
			session.setAttribute("admin", admin);
			//获取当前学期并存入session中
			String term = GetTermUtils.getCurrentTerm();
			session.setAttribute("term", term);
			//重定向到管理员首页界面
			return "redirect:adminHome";
		}
	}
	
}
