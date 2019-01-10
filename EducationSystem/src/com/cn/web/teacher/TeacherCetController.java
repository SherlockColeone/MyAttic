package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	����ѧ����ῼ�ԵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCetController {
	@Autowired
	private ServiceStudent serviceStudent;
		
	/**
	 * ����ѧ����ῼ�Գɼ�ҳ��
	 * @param request ����
	 * @return ��ת��ѧ����ῼ��ҳ��
	 */
	@RequestMapping(value="/studentGradeCet")
	public String studentGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//����׼��֤��
		request.setAttribute("studentId", student.getId());
		//�ҵ���ѧ����������ῼ�Գɼ�
		List<BeanCet> listScore = serviceStudent.searchAllGradeCetScoreByStudentid(student.getId());		
		request.setAttribute("listScore", listScore);
		//�ҵ���ѧ����������ῼ�Ա���
		List<BeanCet> listApply = serviceStudent.searchAllGradeCetApplyByStudentid(student.getId());		
		request.setAttribute("listApply", listApply);
		//��ת��ѧ����ῼ��ҳ��
		return "student/student_gradecet";
	}
	
	/**
	 * ����ѧ����ῼ�Ա���ҳ��
	 * @param request ����
	 * @return ��ת��ѧ����ῼ�Ա���ҳ��
	 */
	@RequestMapping(value="/studentCet")
	public String studentCet(HttpServletRequest request) {
		//���ҵ�ǰѧ�����е���ῼ��
		List<BeanCet> list = serviceStudent.searchAllBeanCetByCurrentTerm();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//����׼��֤��
		request.setAttribute("studentId", student.getId());		
		//��ת��ѧ����ῼ�Ա���ҳ��
		return "student/student_cet";
	}
	
	/**
	 * ����ѧ����ῼ�Ա���
	 * @param request ����
	 * @return �ض���ѧ����ῼ�Գɼ�ҳ��
	 */
	@RequestMapping(value="/studentApplyCet/{cetId}")
	public String studentApplyCet(HttpServletRequest request,@PathVariable("cetId")Integer cetId) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//����ῼ�Գɼ��������ѧ������Ϣ
		serviceStudent.addGradecetApplyByStudentidAndCetid(student.getId(), cetId);
		//�ض���ѧ����ῼ�Գɼ�ҳ�棨PS�����ڱ�����������������ض���ʱ��Ҫ����/��
		return "redirect:/studentGradeCet";
	}
	
}
