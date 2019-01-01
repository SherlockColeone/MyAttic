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
		//��ת���������
		return "password";
	}
	
	@RequestMapping(value="/modifyPassword")
	public String modifyPassword(HttpServletRequest request,String pwd,String newPwd,String rePwd) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�û�����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//���ݲ�ͬ��ݽ����޸�����
		if(student!=null) { //ѧ��
			request.setAttribute("studentId", student.getId());
			serviceStudent.modifyStudentPwd(student.getId(), pwd, newPwd);
		}
		else if(teacher!=null) { //��ʦ
			request.setAttribute("teacherId", teacher.getId());
//			serviceTeacher.checkAndModifyTeacherPwd(teacher.getId(), pwd, newPwd, rePwd);
		}
		else if(admin!=null) { //����Ա
			request.setAttribute("adminId", admin.getId());
//			serviceAdmin.checkAndModifyAdminPwd(admin.getId(), pwd, newPwd, rePwd);
		}
		//��ת���������
		return "password";
	}
}
