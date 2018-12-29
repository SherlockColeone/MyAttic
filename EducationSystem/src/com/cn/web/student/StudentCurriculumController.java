package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.bean.Term;
import com.cn.service.CheckNameService;
import com.cn.service.ServiceStudent;

/**
 * 	进入学生课程表的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentCurriculumController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 获取2018-2019第一学期该学生的课表
	 * @param request 请求
	 * @return 跳转到学生课程表页面
	 */
	@RequestMapping(value="/studentCurriculum")
	public String studentCurriculum(HttpServletRequest request) {
		//把学期列表添加到视图中
		termList = serviceStudent.searchAllTerm();
		request.setAttribute("termList", termList);
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		Map<Integer, Curriculum> mapCurriculum = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), 1);
		List<Curriculum> resultList = new ArrayList<>();
		for (Curriculum curriculum : mapCurriculum.values()) {
			resultList.add(curriculum);
		}
		request.setAttribute("resultList", resultList);
		//跳转到学生课程表页面
		return "student/student_curriculum";
	}
	
	/**
	 * 获取该学生某个学期的课程表
	 * @param request 请求
	 * @return 跳转到学生课程表页面
	 */
	@RequestMapping(value="/studentSearchCurriculum")
	public String studentSearchCurriculum(HttpServletRequest request,Integer termId) {
		//把学期列表添加到视图中
		termList = serviceStudent.searchAllTerm();
		request.setAttribute("termList", termList);
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		Map<Integer, Curriculum> mapCurriculum = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
		List<Curriculum> resultList = new ArrayList<>();
		for (Curriculum curriculum : mapCurriculum.values()) {
			resultList.add(curriculum);
		}
		request.setAttribute("resultList", resultList);
		//跳转到学生课程表页面
		return "student/student_curriculum";
	}
}
