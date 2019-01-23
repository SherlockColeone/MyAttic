package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanEvaluation;
import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	进入教师评价结果的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	/**
	 * 	跳转到教师评价结果页面
	 * @param request 请求
	 * @return 跳转到教师评价结果页面
	 */
	@RequestMapping(value="/teacherEvaluation")
	public String teacherEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacher", teacher);
		//找到该教师的所有教学评价
		serviceTeacher.searchAllEvaluationByTeacherid(teacher.getId());
		//转换成
		
		
		request.setAttribute("list", teacher);
		//跳转到教师评价结果页面
		return "teacher/teacher_evaluation";
	}
	
}
