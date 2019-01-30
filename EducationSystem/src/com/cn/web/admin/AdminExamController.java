package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Exam;
import com.cn.service.ServiceAdmin;

/**
 * 	�������Ա���԰��Ź���Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminExamController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminExam")
	public String adminExam(HttpServletRequest request) {
		//��ת������Ա�鿴���԰���ҳ��
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminExamModify")
	public String adminExamModify(HttpServletRequest request) {
		//��ת������Ա���԰��Ź���ҳ��
		return "admin/admin_exammodify";
	}
	
	@RequestMapping(value="/adminCheckExam")
	public String adminCheckExam(HttpServletRequest request,Integer inputId) {
		Exam exam = serviceAdmin.searchExamByExamid(inputId);
		request.setAttribute("exam", exam);
		//��ת������Ա�鿴���԰���ҳ��
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminCheckExamForModify")
	public String adminCheckExamForModify(HttpServletRequest request,Integer inputId,Integer operate) {
		//�����Ҫ���еĲ���
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Exam exam = new Exam();
		if (operate!=1) { //���е���ɾ�����޸Ĳ���
			exam = serviceAdmin.searchExamByExamid(inputId);
		}		
		request.setAttribute("exam", exam);
		//��ת������Ա���԰��Ź���ҳ��
		return "admin/admin_exammodify";
	}
	
	@RequestMapping(value="/adminInsertExam")
	public String adminInsertExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.addExam(exam);
		//��ת������Ա���԰��Ź���ҳ��
		return "redirect:adminExamModify";
	}
	
	@RequestMapping(value="/adminDeleteExam")
	public String adminDeleteExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.delAdminByAdminid(exam.getId());
		//��ת������Ա���԰��Ź���ҳ��
		return "redirect:adminExamModify";
	}
	
	@RequestMapping(value="/adminModifyExam")
	public String adminModifyExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.modifyExam(exam);
		//��ת������Ա���԰��Ź���ҳ��
		return "redirect:adminExamModify";
	}
}
