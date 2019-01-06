package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ��ѡ�����ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentElectiveController {
	@Autowired
	private ServiceStudent serviceStudent;	
	
	@RequestMapping(value="/studentElective")
	public String studentCourses(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		
		//��ת��ѧ����������
		return "student/student_elective";
	}
	
}
