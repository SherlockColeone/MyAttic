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

/**
 * 	header的控制器
 * @author Sherlock
 *
 */

@Controller
public class HeaderController {
	@Autowired
	private HttpServletRequest req;
	
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
		//将对象添加到视图中，因为页面会对null进行判断，所以三个对象都能直接添加进去
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
	
	public int identify() {
		HttpSession session = req.getSession();
		//从session域中获取对象
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		if(student!=null) { //当前身份是学生
			return 3;
		}
		if(teacher!=null) { //当前身份是教师
			return 2;
		}
		if(admin!=null) { //当前身份是管理员
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request) {
		if(identify()==3) { //跳到学生个人中心
			return "redirect:studentHome";
		}
		else if(identify()==2) { //跳到教师个人中心
			return "redirect:teacherHome";
		}
		else if(identify()==1) { //跳到管理员个人中心
			return "redirect:adminHome";
		}
		else { //需要重新登录
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/message")
	public String message(HttpServletRequest request) {
		if(identify()==3) { //跳到学生个人信息
			return "redirect:studentMessage";
		}
		else if(identify()==2) { //跳到教师个人信息
			return "redirect:teacherMessage";
		}
		else if(identify()==1) { //跳到管理员个人信息
			return "redirect:adminMessage";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/courses")
	public String courses(HttpServletRequest request) {
		if(identify()==3) { //跳到学生课程安排
			return "redirect:studentCourses";
		}
		else if(identify()==2) { //跳到教师课程安排
			return "redirect:teacherCourses";
		}
		else if(identify()==1) { //跳到管理员课程安排
			return "redirect:adminCourses";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/stuscore")
	public String stuscore(HttpServletRequest request) {
		if(identify()==3) { //跳到学生个人成绩
			return "redirect:studentStuscore";
		}
		else if(identify()==2) { //跳到学生成绩（教师）
			return "redirect:teacherStuscore";
		}
		else if(identify()==1) { //跳到学生成绩（管理员）
			return "redirect:adminStuscore";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/exam")
	public String exam(HttpServletRequest request) {
		if(identify()==3) { //跳到学生考试安排
			return "redirect:studentExam";
		}
		else if(identify()==2) { //跳到教师考试安排
			return "redirect:teacherExam";
		}
		else if(identify()==1) { //跳到管理员考试安排
			return "redirect:adminExam";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/elective")
	public String elective(HttpServletRequest request) {
		if(identify()==3) { //跳到学生选课中心
			return "redirect:studentElective";
		}
		else if(identify()==2) { //跳到教师选课中心
			return "redirect:teacherElective";
		}
		else if(identify()==1) { //跳到管理员选课中心
			return "redirect:adminElective";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/pwd")
	public String password(HttpServletRequest request) {
		if(identify()!=0) { //证明当前已登录
			//跳转到密码管理
			return "redirect:password";
		}
		else {  //证明当前未登录
			return "redirect:index";
		}
	}
	
}
