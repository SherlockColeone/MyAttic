package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Exam;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入考试安排（学生）的控制器
 * @author Sherlock
 *
 */

@Controller
public class StudentExamController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/studentExam")
	public String studentExam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		String classes = checkNameUtils.searchByClassesId(student.getClassesid());
		request.setAttribute("classes", classes);
		//查询本班所有考试
		List<Exam> list = serviceStudent.searchAllExamByClassesid(student.getClassesid());
		List<Curriculum> listResult = new ArrayList<>();
		for (Exam exam : list) {
			//找到每个课程对应的名称
			String name = checkNameUtils.searchByCoursesId(exam.getCoursesid());
			Curriculum temp = new Curriculum(exam.getId(), name, null, null, exam.getExamtime(), null, exam.getPlace(), null, exam.getClassesid(), null, null, exam.getCoursesid(), null, classes);		
			listResult.add(temp);
		}				
		request.setAttribute("list", listResult);
		//跳转到学生密码管理页面
		return "student/student_exam";
	}
	
}
