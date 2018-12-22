package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;

/**
 * 	�������������ҳ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class LoginController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher seriveTeacher;
	@Autowired
	private ServiceAdmin serivceAdmin;
	
	@RequestMapping(value="/studentLogin")
	public String studentLogin(ModelAndView mv,Student student,HttpServletRequest request) {
		//�߼����¼��ȡѧ��������Ϣ
		student = serviceStudent.studentLogin(student.getId(), student.getPassword());
		HttpSession session = request.getSession();
		//��ѧ���������session����
		session.setAttribute("student", student);
		//�ض���ѧ����ҳ����
		return "redirect:studentHome";
	}
	
	@RequestMapping(value="/teacherLogin")
	public String teacherLogin(ModelAndView mv,Teacher teacher,HttpServletRequest request) {
		//�߼����ȡ��ʦ������Ϣ
		teacher = seriveTeacher.teacherLogin(teacher.getId(), teacher.getPassword());
		HttpSession session = request.getSession();
		//�ѽ�ʦ�������session����
		session.setAttribute("teacher", teacher);
		//������ʦ��ҳ����
		return "redirect:teacherHome";
	}
	
	@RequestMapping(value="/adminLogin")
	public String adminLogin(ModelAndView mv,Admin admin,HttpServletRequest request) {
		//�߼����ȡ����Ա������Ϣ
		admin = serivceAdmin.adminLogin(admin.getId(), admin.getPassword());
		HttpSession session = request.getSession();
		//�ѹ���Ա�������session����
		session.setAttribute("admin", admin);
		//��������Ա��ҳ����
		return "redirect:adminHome";
	}
	
}
