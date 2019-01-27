package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.utils.GetTermUtils;

/**
 * 	����Աѡ�ι���Ŀ�����
 * @author Sherlock
 *
 */
@Controller
public class AdminElectiveController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	//ѧ����������
	private List<Curriculum> studentList = new ArrayList<>();
	//��ѡ���ѡ�޿�
	private Elective elective = new Elective();
	
	@RequestMapping(value="/adminElective")
	public String adminElective(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�̎�����
		Teacher teacher = (Teacher) session.getAttribute("teacher");		
		//��ȡ��ǰѧ�ڸý�ʦ������ѡ�޿�
		List<Elective> listElective = serviceTeacher.searchAllElectiveByTeacheridAndTermid(teacher.getId(),
				GetTermUtils.getCurrentTermiId());
		List<Curriculum> list = serviceTeacher.changeElectiveListIntoCurriculumList(listElective);
		request.setAttribute("list", list);
		request.setAttribute("studentList", studentList);
		request.setAttribute("elective", elective);
		//��ת���̎��x���n����ҳ��
		return "admin/admin_elective";
	}
	
	@RequestMapping(value="/adminCheckElective")
	public String adminCheckElective(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ�̎�����
		Teacher teacher = (Teacher) session.getAttribute("teacher");		
		//��ȡ��ǰѧ�ڸý�ʦ������ѡ�޿�
		List<Elective> listElective = serviceTeacher.searchAllElectiveByTeacheridAndTermid(teacher.getId(),
				GetTermUtils.getCurrentTermiId());
		List<Curriculum> list = serviceTeacher.changeElectiveListIntoCurriculumList(listElective);
		request.setAttribute("list", list);
		request.setAttribute("studentList", studentList);
		request.setAttribute("elective", elective);
		//��ת���̎��x���n����ҳ��
		return "admin/admin_elective";
	}
	
	@RequestMapping(value="/adminSearchAllStudent/{electiveid}")
	public String adminSelectElective(HttpServletRequest request,@PathVariable("electiveid")Integer electiveid) {
		//����ѡ�޿�id���Ҹÿγ�����ѧ��
		List<Student> listStudent = serviceTeacher.searchAllStudentByElectiveid(electiveid);
		//����ѧ������ת���ɿγ̼��ϲ���ֵ��ȫ�ֱ���
		studentList = serviceTeacher.changeStudentListIntoCurriculumList(listStudent);
		//�ض��򵽽̎��x���n����ҳ��
		return "redirect:/adminElective";
	}
	
}
