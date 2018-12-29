package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Term;
import com.cn.service.CheckNameService;
import com.cn.service.ServiceStudent;

/**
 * 	ѧ���γ̰��ŵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentCoursesController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameService checkNameService;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	��ѧ�ڷ������ѧ��ѡ����
	 * @param request ����
	 * @return ��ת��ѧ���γ̰���ҳ��
	 */
	@RequestMapping(value="/studentCourses")
	public String studentCourses(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//��ת��ѧ���γ̰���
		return "student/student_courses";
	}
	
	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * @param request ����
	 * @param termId �ӱ���ȡ��ѧ��id
	 * @param curriculum �ӱ���ȡ�Ŀγ����ʡ�0��ʾ�������ʣ�1��ʾרҵ�Σ�2��ʾѡ�޿�
	 * @return ��ת��ѧ���γ̰���ҳ��
	 */
	@RequestMapping(value="/studentSearchAllCourses")
	public String studentSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//���ѧ�ڵ�����
		String term = checkNameService.searchNameByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		if(curriculum==0) { //���ʲ���
			//��ѯ��ѧ�ڵ����пγ�
			List<Curriculum> resultList = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
			//�ѽ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
		} else if(curriculum==1) { //רҵ��
			List<Courses> resultList = serviceStudent.searchAllCoursesByStudentidAndTermid(student.getId(), termId);
			//��רҵ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
		}
		else if(curriculum==2) { //ѡ�޿�
			Elective resultList = serviceStudent.searchElectiveByStudentidAndTermid(student.getId(), termId);
			//��ѡ�޿��б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
		}
		return "student/student_courses";
	}
}
