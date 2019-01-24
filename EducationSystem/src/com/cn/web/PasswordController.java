package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;

/**
 * 	�����������Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class PasswordController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/password")
	public String password(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�û�����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//���ݲ�ͬ��ݰ��û��˺���ӵ���ͼ��
		if(student!=null) { //ѧ��
			request.setAttribute("id", student.getId());
		}
		else if(teacher!=null) { //��ʦ
			request.setAttribute("id", teacher.getId());
		}
		else if(admin!=null) { //����Ա
			request.setAttribute("id", admin.getId());
		}
		//��ת���������ҳ��
		return "password";
	}
	
	@RequestMapping(value="/modifyPassword")
	public String modifyPassword(HttpServletRequest request,String pwd,String newPwd) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�û�����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		
		//���ݲ�ͬ��ݽ����޸����벢���û��˺���ӵ���ͼ��
		if(student!=null) { //ѧ��
			request.setAttribute("id", student.getId());
			//��ȡ�޸ĵķ���ֵ
			int result = serviceStudent.modifyStudentPwd(student.getId(), pwd, newPwd);
			//������ֵ����
			request.setAttribute("result", result);
		}
		else if(teacher!=null) { //��ʦ
			request.setAttribute("id", teacher.getId());
			int result = serviceTeacher.modifyTeacherPwd(teacher.getId(), pwd, newPwd);
			request.setAttribute("result", result);
		}
		else if(admin!=null) { //����Ա
			request.setAttribute("id", admin.getId());
			int result = serviceAdmin.modifyAdminPwd(admin.getId(), pwd, newPwd);
			request.setAttribute("result", result);
		}
		//��ת���������ҳ��
		return "password";
	}
	
	@RequestMapping(value="/resetPassword")
	public String resetPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�û�����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//���ݲ�ͬ��ݰ��û��˺���ӵ���ͼ��
		if(student!=null) { //ѧ��
			request.setAttribute("id", student.getId());
		}
		else if(teacher!=null) { //��ʦ
			request.setAttribute("id", teacher.getId());
		}
		else if(admin!=null) { //����Ա
			request.setAttribute("id", admin.getId());
		}
		//��ת���������ҳ��
		return "password";
	}
}
