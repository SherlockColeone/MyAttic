package com.cn.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanArrange;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	进入学生调课通知的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentCurriculumarrangeController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	@RequestMapping(value="/studentCurriculumarrange")
	public String studentCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//根据学生的班级查询所有调课
		List<BeanArrange> list = serviceStudent.searchAllCurriculumarrangeByClassesid(student.getClassesid());
		request.setAttribute("list", list);
		//跳转到学生调课通知页面
		return "student/student_curriculumarrange";
	}
	
}
