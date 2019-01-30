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
 * 	进入管理员考试安排管理的控制器
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
		//跳转到管理员查看考试安排页面
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminExamModify")
	public String adminExamModify(HttpServletRequest request) {
		//跳转到管理员考试安排管理页面
		return "admin/admin_exammodify";
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
		//跳转到管理员查看考试安排页面
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminCheckExamForModify")
	public String adminCheckExamForModify(HttpServletRequest request) {
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
		//跳转到管理员考试安排管理页面
		return "admin/admin_exammodify";
	}
	
}
