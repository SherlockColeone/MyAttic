package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Student;
import com.cn.service.CheckNameService;

/**
 * 	����ѧ��ѧ����Ϣ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentMessageController {
	@Autowired
	private CheckNameService checkNameService;
	
	@RequestMapping(value="/studentMessage")
	public String studentMessage(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ѯ������ѧԺ��רҵ���༶������
		String academy = checkNameService.searchNameByAcademyId(student.getAcademyid());
		String major = checkNameService.searchNameByMajorId(student.getMajorid());
		String classes = checkNameService.searchNameByClassesId(student.getClassesid());
		//��ѧ��������Ϣ��ӵ���ͼ��
		mv.addObject("student", student);
		//�Ѷ���ѧԺ��רҵ���༶�����ַ�����ͼ��
		request.setAttribute("academy",academy);
		request.setAttribute("major",major);
		request.setAttribute("classes",classes);
		//��ת��ѧ����������
		return "student/student_message";
	}
	
}
