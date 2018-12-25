package com.cn.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Teacher;

/**
 * 	进入教师个人中心的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherHomeController {
	
	@RequestMapping(value="/teacherHome")
	public String teacherHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//把教师添加到视图中
		mv.addObject("teacher", teacher);
		//跳转到教师个人中心
		return "teacher/teacher_home";
	}
	
}
