package com.cn.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	进入学生社会考试的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentCetController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	//
	@RequestMapping(value="/studentCet")
	public String studentCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		
		//跳转到学生社会考试页面
		return "student/student_cet";
	}
	
	//
	@RequestMapping(value="/studentGradeCet")
	public String studentGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//找到该学生的所有社会考试
		List<Gradecet> list = serviceStudent.searchAllGradeCetByStudentid(student.getId());
		request.setAttribute("list", list);
		//跳转到学生社会考试页面
		return "student/student_gradecet";
	}
	
}
