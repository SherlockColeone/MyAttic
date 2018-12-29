package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.bean.Term;
import com.cn.service.CheckNameService;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ���γ̱�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentCurriculumController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * ��ȡ2018-2019��һѧ�ڸ�ѧ���Ŀα�
	 * @param request ����
	 * @return ��ת��ѧ���γ̱�ҳ��
	 */
	@RequestMapping(value="/studentCurriculum")
	public String studentCurriculum(HttpServletRequest request) {
		//��ѧ���б���ӵ���ͼ��
		termList = serviceStudent.searchAllTerm();
		request.setAttribute("termList", termList);
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		Map<Integer, Curriculum> mapCurriculum = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), 1);
		List<Curriculum> resultList = new ArrayList<>();
		for (Curriculum curriculum : mapCurriculum.values()) {
			resultList.add(curriculum);
		}
		request.setAttribute("resultList", resultList);
		//��ת��ѧ���γ̱�ҳ��
		return "student/student_curriculum";
	}
	
	/**
	 * ��ȡ��ѧ��ĳ��ѧ�ڵĿγ̱�
	 * @param request ����
	 * @return ��ת��ѧ���γ̱�ҳ��
	 */
	@RequestMapping(value="/studentSearchCurriculum")
	public String studentSearchCurriculum(HttpServletRequest request,Integer termId) {
		//��ѧ���б���ӵ���ͼ��
		termList = serviceStudent.searchAllTerm();
		request.setAttribute("termList", termList);
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		Map<Integer, Curriculum> mapCurriculum = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
		List<Curriculum> resultList = new ArrayList<>();
		for (Curriculum curriculum : mapCurriculum.values()) {
			resultList.add(curriculum);
		}
		request.setAttribute("resultList", resultList);
		//��ת��ѧ���γ̱�ҳ��
		return "student/student_curriculum";
	}
}
