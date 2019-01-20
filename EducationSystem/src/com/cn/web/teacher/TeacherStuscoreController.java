package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入学生成绩管理（教师）的控制器
 * 
 * @author Sherlock
 *
 */

@Controller
public class TeacherStuscoreController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;

	public List<Term> termList = new ArrayList<>();

	/**
	 * 	显示该教师目前学期的所有课程显示
	 * 
	 * @param request 请求
	 * @return 跳转到教师成绩管理页面
	 */
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStudentscore(HttpServletRequest request) {
		
//		termList = serviceStudent.searchAllTerm();
//		// 把学期列表添加到视图中
//		request.setAttribute("termList", termList);
		// 跳转到教师个人中心
		return "teacher/teacher_stuscore";
	}

	/**
	 * 	根据选择的条件查询出课程安排
	 * 
	 * @param request    请求
	 * @param termId     从表单获取的学期id
	 * @return 跳转到教师成绩查询页面
	 */
	@RequestMapping(value = "/teacherSearchAllStuscore")
	public String teacherSearchAllStuscore(HttpServletRequest request, Integer termId) {
		// 把学期列表添加到视图中
		request.setAttribute("termList", termList);
		// 查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//查询该学期的所有成绩
//		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(teacher.getId(), termId);
//		//把结果列表添加到视图中
//		request.setAttribute("resultList",resultList);
		return "teacher/teacher_stuscore";
	}
}
