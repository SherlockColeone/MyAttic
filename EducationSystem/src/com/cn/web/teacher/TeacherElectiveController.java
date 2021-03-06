package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.utils.GetTermUtils;

/**
 * 	进入教师选修课安排的控制器
 * @author Sherlock
 *
 */
@Controller
public class TeacherElectiveController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	//学生名单集合
	private List<Curriculum> studentList = new ArrayList<>();
	//已选择的选修课
	private Elective elective = new Elective();
	
	@RequestMapping(value="/teacherElective")
	public String teacherElective(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教師对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");		
		//获取当前学期该教师的所有选修课
		List<Elective> listElective = serviceTeacher.searchAllElectiveByTeacheridAndTermid(teacher.getId(),
				GetTermUtils.getCurrentTermiId());
		List<Curriculum> list = serviceTeacher.changeElectiveListIntoCurriculumList(listElective);
		request.setAttribute("list", list);
		request.setAttribute("studentList", studentList);
		request.setAttribute("elective", elective);
		//跳转到教師選修課安排页面
		return "teacher/teacher_elective";
	}
	
	@RequestMapping(value="/teacherSearchAllStudent/{electiveid}")
	public String teacherSelectElective(HttpServletRequest request,@PathVariable("electiveid")Integer electiveid) {
		//根据选修课id查找该课程所有学生
		List<Student> listStudent = serviceTeacher.searchAllStudentByElectiveid(electiveid);
		//将该学生集合转换成课程集合并赋值到全局变量
		studentList = serviceTeacher.changeStudentListIntoCurriculumList(listStudent);
		//重定向到教師選修課安排页面
		return "redirect:/teacherElective";
	}
	
}
