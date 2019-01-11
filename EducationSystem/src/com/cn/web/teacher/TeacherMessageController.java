package com.cn.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Teacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入教师个人信息的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherMessageController {
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/teacherMessage")
	public String teacherMessage(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查询出二级学院的名字
		String academy = checkNameUtils.searchByAcademyId(teacher.getAcademyid());
		//把教师个人信息添加到视图中
		mv.addObject("teacher", teacher);
		//把二级学院的名字放入视图中
		request.setAttribute("academy",academy);
		//跳转到教师个人信息
		return "teacher/teacher_message";
	}
	
}
