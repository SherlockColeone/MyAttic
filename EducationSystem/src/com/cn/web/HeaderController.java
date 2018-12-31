package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private HttpServletRequest req;
	
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
		//��������ӵ���ͼ�У���Ϊҳ����null�����жϣ���������������ֱ����ӽ�ȥ
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
	
	public int identify() {
		HttpSession session = req.getSession();
		//��session���л�ȡ����
		Student student = (Student) session.getAttribute("student");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Admin admin = (Admin) session.getAttribute("admin");
		if(student!=null) { //��ǰ�����ѧ��
			return 3;
		}
		if(teacher!=null) { //��ǰ����ǽ�ʦ
			return 2;
		}
		if(admin!=null) { //��ǰ����ǹ���Ա
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request) {
		if(identify()==3) { //����ѧ����������
			return "redirect:studentHome";
		}
		else if(identify()==2) { //������ʦ��������
			return "redirect:teacherHome";
		}
		else if(identify()==1) { //��������Ա��������
			return "redirect:adminHome";
		}
		else { //��Ҫ���µ�¼
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/message")
	public String message(HttpServletRequest request) {
		if(identify()==3) { //����ѧ��������Ϣ
			return "redirect:studentMessage";
		}
		else if(identify()==2) { //������ʦ������Ϣ
			return "redirect:teacherMessage";
		}
		else if(identify()==1) { //��������Ա������Ϣ
			return "redirect:adminMessage";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/courses")
	public String courses(HttpServletRequest request) {
		if(identify()==3) { //����ѧ���γ̰���
			return "redirect:studentCourses";
		}
		else if(identify()==2) { //������ʦ�γ̰���
			return "redirect:teacherCourses";
		}
		else if(identify()==1) { //��������Ա�γ̰���
			return "redirect:adminCourses";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/stuscore")
	public String stuscore(HttpServletRequest request) {
		if(identify()==3) { //����ѧ�����˳ɼ�
			return "redirect:studentStuscore";
		}
		else if(identify()==2) { //����ѧ���ɼ�����ʦ��
			return "redirect:teacherStuscore";
		}
		else if(identify()==1) { //����ѧ���ɼ�������Ա��
			return "redirect:adminStuscore";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/exam")
	public String exam(HttpServletRequest request) {
		if(identify()==3) { //����ѧ�����԰���
			return "redirect:studentExam";
		}
		else if(identify()==2) { //������ʦ���԰���
			return "redirect:teacherExam";
		}
		else if(identify()==1) { //��������Ա���԰���
			return "redirect:adminExam";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/elective")
	public String elective(HttpServletRequest request) {
		if(identify()==3) { //����ѧ��ѡ������
			return "redirect:studentElective";
		}
		else if(identify()==2) { //������ʦѡ������
			return "redirect:teacherElective";
		}
		else if(identify()==1) { //��������Աѡ������
			return "redirect:adminElective";
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/pwd")
	public String password(HttpServletRequest request) {
		if(identify()!=0) { //֤����ǰ�ѵ�¼
			//��ת���������
			return "redirect:password";
		}
		else {  //֤����ǰδ��¼
			return "redirect:index";
		}
	}
	
}
