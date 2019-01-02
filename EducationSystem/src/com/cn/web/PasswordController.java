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
		//���ݲ�ͬ��ݽ����޸����벢���û��˺���ӵ���ͼ��
		if(student!=null) { //ѧ��
			request.setAttribute("id", student.getId());
			//��ȡ�޸ĵķ���ֵ
			int result = serviceStudent.modifyStudentPwd(student.getId(), pwd, newPwd);
			//������ֵ����
			request.setAttribute("result", result);
//			if(num>0) {
//				result = "�޸�����ɹ���";
//				session.setAttribute("result", result);
//			} else if(num==0) {
//				result = "�޸�����ʧ�ܣ�";
//			} else if(num==-1){
//				result = "ԭʼ���벻��ȷ��";
//			}
		}
		else if(teacher!=null) { //��ʦ
			request.setAttribute("id", teacher.getId());
			int result = serviceTeacher.modifyTeacherPwd(teacher.getId(), rePwd, newPwd);
			request.setAttribute("result", result);
		}
		else if(admin!=null) { //����Ա
			request.setAttribute("id", admin.getId());
			int result = serviceAdmin.modifyAdminPwd(admin.getId(), rePwd, newPwd);
			request.setAttribute("result", result);
		}
		//��ת���������
		return "password";
	}
}
