package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	����ѧ���ɼ�������ʦ���Ŀ�����
 * 
 * @author Sherlock
 *
 */

@Controller
public class TeacherStuscoreController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;

	public List<Term> termList = new ArrayList<>();

	/**
	 * 	��ʾ�ý�ʦĿǰѧ�ڵ����пγ���ʾ
	 * 
	 * @param request ����
	 * @return ��ת����ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStudentscore(HttpServletRequest request) {
		
//		termList = serviceStudent.searchAllTerm();
//		// ��ѧ���б���ӵ���ͼ��
//		request.setAttribute("termList", termList);
		// ��ת����ʦ��������
		return "teacher/teacher_stuscore";
	}

	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * 
	 * @param request    ����
	 * @param termId     �ӱ���ȡ��ѧ��id
	 * @return ��ת����ʦ�ɼ���ѯҳ��
	 */
	@RequestMapping(value = "/teacherSearchAllStuscore")
	public String teacherSearchAllStuscore(HttpServletRequest request, Integer termId) {
		// ��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList", termList);
		// ���ѧ�ڵ�����
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//��ѯ��ѧ�ڵ����гɼ�
//		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(teacher.getId(), termId);
//		//�ѽ���б���ӵ���ͼ��
//		request.setAttribute("resultList",resultList);
		return "teacher/teacher_stuscore";
	}
}
