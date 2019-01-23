package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Exam;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	���뿼�԰��ţ���ʦ���Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminExamController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/adminExam")
	public String adminExam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacherName", teacher.getName());
		//��ѯ�ý�ʦ��Ҫ�࿼�����п���
		List<Exam> list = serviceTeacher.searchAllExamByTeacherid(teacher.getId());
		List<Curriculum> listResult = new ArrayList<>();
		for (Exam exam : list) {
			//�ҵ�ÿ���γ̶�Ӧ������
			String name = checkNameUtils.searchByCoursesId(exam.getCoursesid());
			Curriculum temp = new Curriculum(name, exam.getExamtime(), exam.getPlace(), exam.getCoursesid(),
					checkNameUtils.searchByClassesId(exam.getClassesid()));		
			listResult.add(temp);
		}				
		request.setAttribute("list", listResult);
		//��ת����ʦ���԰���ҳ��
		return "admin/admin_exam";
	}
	
}