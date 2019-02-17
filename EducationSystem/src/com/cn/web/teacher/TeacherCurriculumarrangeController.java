package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanArrange;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ����֪ͨ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCurriculumarrangeController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/teacherCurriculumarrange")
	public String teacherCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ�ý�ʦ���е���
		
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		
		request.setAttribute("list", list);
		//��ת���鿴����֪ͨҳ��
		return "teacher/teacher_curriculumarrange";
	}
	
	@RequestMapping(value="/teacherModifyCurriculumarrange")
	public String teacherModifyCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ�ý�ʦ���е���
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//��ת���������ҳ��
		return "teacher/teacher_modifycurriculumarrange";
	}
	
}
