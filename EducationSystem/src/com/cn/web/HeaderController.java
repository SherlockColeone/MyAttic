package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;

/**
 * 	header�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class HeaderController {
	
	/**
	 * 	����header�Ŀ�����
	 * @return ����header
	 */
	@RequestMapping(value="/header")
	public String header(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		//������ӵ���ͼ��
		mv.addObject("student", student);
		mv.addObject("teacher", teacher);
		mv.addObject("admin", admin);
		//����header
		return "header";
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session�����Ƴ�����
		session.removeAttribute("student");
		session.removeAttribute("teacher");
		session.removeAttribute("admin");
		return "redirect:index";
	}
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request) {
		
		return "";
	}
	
}
