package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Term;
import com.cn.service.CheckNameService;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ���ɼ���ѧ�����Ŀ�����
 * 
 * @author Sherlock
 *
 */

@Controller
public class StudentStuscoreController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameService checkNameService;

	public List<Term> termList = new ArrayList<>();

	/**
	 * 	��ѧ�ڷ������ѧ��ѡ����
	 * 
	 * @param request ����
	 * @return ��ת��ѧ���ɼ���ѯҳ��
	 */
	@RequestMapping(value = "/studentStuscore")
	public String studentStudentscore(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		// ��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList", termList);
		// ��ת��ѧ����������
		return "student/student_stuscore";
	}

	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * 
	 * @param request    ����
	 * @param termId     �ӱ���ȡ��ѧ��id
	 * @return ��ת��ѧ���ɼ���ѯҳ��
	 */
	@RequestMapping(value = "/studentSearchAllStuscore")
	public String studentSearchAllStuscore(HttpServletRequest request, Integer termId) {
		// ��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList", termList);
		// ���ѧ�ڵ�����
		String term = checkNameService.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ѯ��ѧ�ڵ����гɼ�
		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(student.getId(), termId);
		//�ѽ���б���ӵ���ͼ��
		request.setAttribute("resultList",resultList);
		return "student/student_stuscore";
	}
}
