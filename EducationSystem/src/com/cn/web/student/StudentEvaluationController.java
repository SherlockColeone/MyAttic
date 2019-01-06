package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ����ʦ���۵Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentEvaluationController {
	@Autowired
	private ServiceStudent serviceStudent;	
	
	@RequestMapping(value="/studentEvaluation")
	public String studentEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		
		//��ת��ѧ����ʦ����ҳ�棨ѡ���ʦ��
		return "student/student_evaluation";
	}
	
	@RequestMapping(value="/studentEvaluationForm")
	public String studentEvaluationForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		
		//��ת��ѧ����ʦ����ҳ�棨ѡ���ʦ��
		return "student/student_evaluationform";
	}
	
}
