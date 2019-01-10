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
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetCurrentTermUtils;

/**
 * 	进入学生教师评价的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	/**
	 * 跳转到选择教师的页面
	 * @param request 请求
	 * @return 跳转到学生教师评价页面（选择教师）
	 */
	@RequestMapping(value="/studentEvaluation")
	public String studentEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//根据当前学期与学号找到所有任课老师
		List<Stuscore> stuScore = serviceStudent.searchAllStuScoreByStudentidAndTermid(student.getId(),
				GetCurrentTermUtils.getCurrentTermiId());
		List<Curriculum> list = new ArrayList<>();
		for (Stuscore score : stuScore) {
			if(score.getCouresid()!=0) { //专业课
				Courses courses = serviceStudent.searchCoursesByCoursesId(score.getCouresid());
				//检查是否已评价该教师
				Integer check = serviceStudent.checkEvaluationByStudentidAndTeacherid(student.getId(), courses.getTeacherid());
				//termid的属性用于放置是否已评价
				Curriculum curriculum = new Curriculum(courses.getName(), courses.getTeacher(), check, courses.getTeacherid(),
						courses.getId(), 0);
				list.add(curriculum);
			}
			else { //选修课
				Elective elective = serviceStudent.searchElectiveById(score.getElectiveid());
				//检查是否已评价该教师
				Integer check = serviceStudent.checkEvaluationByStudentidAndTeacherid(student.getId(), elective.getTeacherid());
				//termid的属性用于放置是否已评价
				Curriculum curriculum = new Curriculum(elective.getName(), elective.getTeacher(), check, elective.getTeacherid(),
						0, elective.getId());
				list.add(curriculum);
			}			
		}
		request.setAttribute("list", list);
		//跳转到学生教师评价页面（选择教师）
		return "student/student_evaluation";
	}
	
	/**
	 * 跳转到填写评价的页面
	 * @param request 请求
	 * @return 跳转到学生教师评价页面（填写评价）
	 */
	@RequestMapping(value="/studentEvaluationForm/{teacherid}")
	public String studentEvaluationForm(HttpServletRequest request,@PathVariable("teacherid")Integer teacherid) {
		String teacherName = checkNameUtils.searchByTeacherId(teacherid);
		//把教师工号与姓名传到页面
		request.setAttribute("teacherid", teacherid);
		request.setAttribute("teacherName", teacherName);
		//跳转到学生教师评价页面（填写评价）
		return "student/student_evaluationform";
	}
	
	/**
	 * 提交教师评价
	 * @param request 请求
	 * @param content 教师评价内容
	 * @return 重定向到学生教师评价页面（选择教师）
	 */
	@RequestMapping(value="/studentEvaluationSubmit")
	public String studentEvaluationSubmit(HttpServletRequest request,BeanEvaluation content) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把表单的内容与学生学号添加进去
		serviceStudent.addEvaluationByStudentidAndContent(student.getId(), content);
		//重定向到学生教师评价页面（选择教师）
		return "redirect:studentEvaluation";
	}
	
}
