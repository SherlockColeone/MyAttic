package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	进入学生教师评价的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentEvaluationController {
	@Autowired
	private ServiceStudent serviceStudent;	
	
	@RequestMapping(value="/studentEvaluation")
	public String studentEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		
		//跳转到学生教师评价页面（选择教师）
		return "student/student_evaluation";
	}
	
	@RequestMapping(value="/studentEvaluationForm")
	public String studentEvaluationForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		
		//跳转到学生教师评价页面（选择教师）
		return "student/student_evaluationform";
	}
	
}
