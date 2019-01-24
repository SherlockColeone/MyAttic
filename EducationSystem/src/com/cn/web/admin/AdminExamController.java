package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Exam;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入考试安排（教师）的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminExamController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/adminExam")
	public String adminExam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacherName", teacher.getName());
		//查询该教师需要监考的所有考试
		List<Exam> list = serviceTeacher.searchAllExamByTeacherid(teacher.getId());
		List<Curriculum> listResult = new ArrayList<>();
		for (Exam exam : list) {
			//找到每个课程对应的名称
			String name = checkNameUtils.searchByCoursesId(exam.getCoursesid());
			Curriculum temp = new Curriculum(name, exam.getExamtime(), exam.getPlace(), exam.getCoursesid(),
					checkNameUtils.searchByClassesId(exam.getClassesid()));		
			listResult.add(temp);
		}				
		request.setAttribute("list", listResult);
		//跳转到教师考试安排页面
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminCheckExam")
	public String adminCheckExam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacherName", teacher.getName());
		//查询该教师需要监考的所有考试
		List<Exam> list = serviceTeacher.searchAllExamByTeacherid(teacher.getId());
		List<Curriculum> listResult = new ArrayList<>();
		for (Exam exam : list) {
			//找到每个课程对应的名称
			String name = checkNameUtils.searchByCoursesId(exam.getCoursesid());
			Curriculum temp = new Curriculum(name, exam.getExamtime(), exam.getPlace(), exam.getCoursesid(),
					checkNameUtils.searchByClassesId(exam.getClassesid()));		
			listResult.add(temp);
		}				
		request.setAttribute("list", listResult);
		//跳转到教师考试安排页面
		return "admin/admin_exam";
	}
	
}
