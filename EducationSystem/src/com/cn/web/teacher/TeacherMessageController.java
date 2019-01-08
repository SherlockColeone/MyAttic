package com.cn.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ�������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherMessageController {
	@Autowired
	ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/teacherMessage")
	public String teacherMessage(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//�ѽ�ʦ��ӵ���ͼ��
		mv.addObject("teacher", teacher);
		//��ת����ʦ��������
		return "teacher/teacher_home";
	}
	
}
