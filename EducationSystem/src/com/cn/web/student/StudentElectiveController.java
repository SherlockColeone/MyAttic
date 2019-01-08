package com.cn.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;
import com.cn.utils.GetCurrentTermUtils;

/**
 * 	进入学生选课中心的控制器
 * @author Sherlock
 *
 */
@Controller
public class StudentElectiveController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	@RequestMapping(value="/studentElective")
	public String studentElective(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//获取当前学期的所有选修课
		List<Curriculum> list = serviceStudent.searchAllElectiveResultByStudentidAndTermid(student.getId(), 
				GetCurrentTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		if (serviceStudent.searchAllTempElectiveByStudentid(student.getId()).size()>0) {
			//标记已选择选修课
			request.setAttribute("iselected", 1);			
		} else {
			request.setAttribute("iselected", 0);
		}
		//跳转到学生选课中心页面
		return "student/student_elective";
	}
	
	@RequestMapping(value="/studentSelectElective")
	public String studentSelectElective(HttpServletRequest request,Integer id) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//把选修课记录添加到数据库中
		serviceStudent.addTempElectiveByStudentid(student.getId(), id);
		//跳转到学生选课中心页面
		return "redirect:studentElective";
	}
	
}
