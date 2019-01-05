package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Student;
import com.cn.service.CheckNameService;

/**
 * 	进入学生学籍信息的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentMessageController {
	@Autowired
	private CheckNameService checkNameService;
	
	@RequestMapping(value="/studentMessage")
	public String studentMessage(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//查询出二级学院、专业、班级的名字
		String academy = checkNameService.searchByAcademyId(student.getAcademyid());
		String major = checkNameService.searchByMajorId(student.getMajorid());
		String classes = checkNameService.searchByClassesId(student.getClassesid());
		//把学生个人信息添加到视图中
		mv.addObject("student", student);
		//把二级学院、专业、班级的名字放入视图中
		request.setAttribute("academy",academy);
		request.setAttribute("major",major);
		request.setAttribute("classes",classes);
		//跳转到学生学籍信息页面
		return "student/student_message";
	}
	
}
