package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;

/**
 * 	�����������Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class PasswordController {
	
	@RequestMapping(value="/password")
	public String password(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�û�����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//���û��˺���ӵ���ͼ��
		request.setAttribute("studentId", student.getId());
		//��ת��ѧ����������
		return "student/student_password";
	}
	
	@RequestMapping(value="/modifyPassword")
	public String modifyPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ѧ����ӵ���ͼ��
		request.setAttribute("studentId", student.getId());
		//��ת��ѧ����������
		return "student/student_password";
	}
}
