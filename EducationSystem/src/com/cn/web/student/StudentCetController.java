package com.cn.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ����ῼ�ԵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentCetController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	//
	@RequestMapping(value="/studentCet")
	public String studentCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		
		//��ת��ѧ����ῼ��ҳ��
		return "student/student_cet";
	}
	
	//
	@RequestMapping(value="/studentGradeCet")
	public String studentGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//�ҵ���ѧ����������ῼ��
		List<Gradecet> list = serviceStudent.searchAllGradeCetByStudentid(student.getId());
		request.setAttribute("list", list);
		//��ת��ѧ����ῼ��ҳ��
		return "student/student_gradecet";
	}
	
}
