package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ��ῼ�ԵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCetController {
	@Autowired
	private ServiceTeacher serviceTeacher;
		
	/**
	 * �����ʦ��ῼ�Թ���ҳ��
	 * @param request ����
	 * @return ��ת����ʦ��ῼ�Թ���ҳ��
	 */
	@RequestMapping(value="/teacherGradeCet")
	public String teacherGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//����׼��֤��
//		request.setAttribute("studentId", student.getId());
//		//�ҵ��ý�ʦ��������ῼ�Գɼ�
//		List<BeanCet> listScore = serviceTeacher.searchAllGradeCetScoreByTeacherid(student.getId());		
//		request.setAttribute("listScore", listScore);
//		//�ҵ��ý�ʦ��������ῼ�Ա���
//		List<BeanCet> listApply = serviceTeacher.searchAllGradeCetApplyByTeacherid(student.getId());		
//		request.setAttribute("listApply", listApply);
		//��ת����ʦ��ῼ��ҳ��
		return "teacher/teacher_gradecet";
	}
	
	/**
	 * �����ʦ��ῼ�Ա���ҳ��
	 * @param request ����
	 * @return ��ת����ʦ��ῼ�Ա���ҳ��
	 */
	@RequestMapping(value="/teacherCet")
	public String teacherCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//���ҵ�ǰѧ�����е���ῼ��
//		List<BeanCet> list = serviceTeacher.searchAllBeanCetByCurrentTerm();
//		request.setAttribute("list", list);		
//		//����׼��֤��
//		request.setAttribute("studentId", student.getId());		
		//��ת����ʦ��ῼ�Ա���ҳ��
		return "teacher/teacher_cet";
	}
	
	/**
	 * �����ʦ��ῼ�Ա���
	 * @param request ����
	 * @return �ض��򵽽�ʦ��ῼ�Գɼ�ҳ��
	 */
	@RequestMapping(value="/teacherApplyCet/{cetId}")
	public String teacherApplyCet(HttpServletRequest request,@PathVariable("cetId")Integer cetId) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher student = (Teacher) session.getAttribute("student");
//		//����ῼ�Գɼ�������ӽ�ʦ����Ϣ
//		serviceTeacher.addGradecetApplyByTeacheridAndCetid(student.getId(), cetId);
		//�ض��򵽽�ʦ��ῼ�Գɼ�ҳ�棨PS�����ڱ�����������������ض���ʱ��Ҫ����/��
		return "redirect:/teacherGradeCet";
	}
	
}
