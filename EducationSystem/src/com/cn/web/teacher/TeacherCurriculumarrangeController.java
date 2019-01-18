package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.BeanArrange;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	�����ʦ����֪ͨ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCurriculumarrangeController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	@RequestMapping(value="/teacherCurriculumarrange")
	public String studentCurriculumarrange(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Student student = (Student) session.getAttribute("student");
		//���ݽ�ʦ��ѯ���е���
		List<BeanArrange> list = serviceStudent.searchAllCurriculumarrangeByClassesid(student.getClassesid());
		request.setAttribute("list", list);
		//��ת����ʦ����֪ͨҳ��
		return "teacher/teacher_curriculumarrange";
	}
	
}
