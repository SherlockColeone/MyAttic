package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.BeanArrange;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	进入教师调课通知的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherCurriculumarrangeController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	@RequestMapping(value="/teacherCurriculumarrange")
	public String studentCurriculumarrange(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Student student = (Student) session.getAttribute("student");
		//根据教师查询所有调课
		List<BeanArrange> list = serviceStudent.searchAllCurriculumarrangeByClassesid(student.getClassesid());
		request.setAttribute("list", list);
		//跳转到教师调课通知页面
		return "teacher/teacher_curriculumarrange";
	}
	
}
