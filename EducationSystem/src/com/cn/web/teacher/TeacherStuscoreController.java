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
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入学生成绩（学生）的控制器
 * 
 * @author Sherlock
 *
 */

@Controller
public class TeacherStuscoreController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;

	public List<Term> termList = new ArrayList<>();

	/**
	 * 	将学期放入表单的学期选项中
	 * 
	 * @param request 请求
	 * @return 跳转到学生成绩查询页面
	 */
	@RequestMapping(value = "/teacherStuscore")
	public String studentStudentscore(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		// 把学期列表添加到视图中
		request.setAttribute("termList", termList);
		// 跳转到学生个人中心
		return "student/student_stuscore";
	}

	/**
	 * 	根据选择的条件查询出课程安排
	 * 
	 * @param request    请求
	 * @param termId     从表单获取的学期id
	 * @return 跳转到学生成绩查询页面
	 */
	@RequestMapping(value = "/teacherSearchAllStuscore")
	public String studentSearchAllStuscore(HttpServletRequest request, Integer termId) {
		// 把学期列表添加到视图中
		request.setAttribute("termList", termList);
		// 查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//查询该学期的所有成绩
		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(student.getId(), termId);
		//把结果列表添加到视图中
		request.setAttribute("resultList",resultList);
		return "student/student_stuscore";
	}
}
