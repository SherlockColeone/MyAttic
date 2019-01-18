package com.cn.web.teacher;

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
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;

/**
 * 	教师课程安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherCoursesController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	将学期放入表单的学期选项中
	 * @param request 请求
	 * @return 跳转到教师课程安排页面
	 */
	@RequestMapping(value="/teacherCourses")
	public String studentCourses(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//跳转到教师课程安排
		return "student/student_courses";
	}
	
	/**
	 * 	根据选择的条件查询出课程安排
	 * @param request 请求
	 * @param termId 从表单获取的学期id
	 * @param curriculum 从表单获取的课程性质。0表示不限性质；1表示专业课；2表示选修课
	 * @return 跳转到教师课程安排页面
	 */
	@RequestMapping(value="/teacherSearchAllCourses")
	public String studentSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Student student = (Student) session.getAttribute("student");
		if(curriculum==0) { //性质不限
			//查询该学期的所有课程
			List<Curriculum> resultList = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
			//把结果列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","不限性质");
		} 
		else if(curriculum==1) { //专业课
			List<Courses> resultList = serviceStudent.searchAllCoursesByStudentidAndTermid(student.getId(), termId);
			//把专业课列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","专业课");
		}
		else if(curriculum==2) { //选修课
			List<Curriculum> resultList = new ArrayList<>();
			List<Elective> list = serviceStudent.searchAllElectiveByStudentidAndTermid(student.getId(), termId);
			for (Elective elective : list) {
				Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getTeacher(), null,
						0, elective.getId());
				resultList.add(curr);
			}			
			//把选修课列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","选修课");
		}
		return "student/student_courses";
	}
}
