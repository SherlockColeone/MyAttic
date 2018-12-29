package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Term;
import com.cn.service.CheckNameService;
import com.cn.service.ServiceStudent;

/**
 * 	学生课程安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentCoursesController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameService checkNameService;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	将学期放入表单的学期选项中
	 * @param request 请求
	 * @return 跳转到学生课程安排页面
	 */
	@RequestMapping(value="/studentCourses")
	public String studentCourses(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//跳转到学生课程安排
		return "student/student_courses";
	}
	
	/**
	 * 	根据选择的条件查询出课程安排
	 * @param request 请求
	 * @param termId 从表单获取的学期id
	 * @param curriculum 从表单获取的课程性质。0表示不限性质；1表示专业课；2表示选修课
	 * @return 跳转到学生课程安排页面
	 */
	@RequestMapping(value="/studentSearchAllCourses")
	public String studentSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//查出学期的名字
		String term = checkNameService.searchNameByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		if(curriculum==0) { //性质不限
			//查询该学期的所有课程
			List<Curriculum> resultList = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
			//把结果列表添加到视图中
			request.setAttribute("resultList",resultList);
		} else if(curriculum==1) { //专业课
			List<Courses> resultList = serviceStudent.searchAllCoursesByStudentidAndTermid(student.getId(), termId);
			//把专业课列表添加到视图中
			request.setAttribute("resultList",resultList);
		}
		else if(curriculum==2) { //选修课
			Elective resultList = serviceStudent.searchElectiveByStudentidAndTermid(student.getId(), termId);
			//把选修课列表添加到视图中
			request.setAttribute("resultList",resultList);
		}
		return "student/student_courses";
	}
}
