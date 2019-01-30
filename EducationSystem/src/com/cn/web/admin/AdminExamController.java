package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Exam;
import com.cn.service.ServiceAdmin;

/**
 * 	进入管理员考试安排管理的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminExamController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminExam")
	public String adminExam(HttpServletRequest request) {
		//跳转到管理员查看考试安排页面
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminExamModify")
	public String adminExamModify(HttpServletRequest request) {
		//跳转到管理员考试安排管理页面
		return "admin/admin_exammodify";
	}
	
	@RequestMapping(value="/adminCheckExam")
	public String adminCheckExam(HttpServletRequest request,Integer inputId) {
		Exam exam = serviceAdmin.searchExamByExamid(inputId);
		request.setAttribute("exam", exam);
		//跳转到管理员查看考试安排页面
		return "admin/admin_exam";
	}
	
	@RequestMapping(value="/adminCheckExamForModify")
	public String adminCheckExamForModify(HttpServletRequest request,Integer inputId,Integer operate) {
		//标记需要进行的操作
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Exam exam = new Exam();
		if (operate!=1) { //进行的是删除或修改操作
			exam = serviceAdmin.searchExamByExamid(inputId);
		}		
		request.setAttribute("exam", exam);
		//跳转到管理员考试安排管理页面
		return "admin/admin_exammodify";
	}
	
	@RequestMapping(value="/adminInsertExam")
	public String adminInsertExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.addExam(exam);
		//跳转到管理员考试安排管理页面
		return "redirect:adminExamModify";
	}
	
	@RequestMapping(value="/adminDeleteExam")
	public String adminDeleteExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.delAdminByAdminid(exam.getId());
		//跳转到管理员考试安排管理页面
		return "redirect:adminExamModify";
	}
	
	@RequestMapping(value="/adminModifyExam")
	public String adminModifyExam(HttpServletRequest request,Exam exam) {
		serviceAdmin.modifyExam(exam);
		//跳转到管理员考试安排管理页面
		return "redirect:adminExamModify";
	}
}
