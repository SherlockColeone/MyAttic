package com.cn.web.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;
import com.cn.utils.GetCurrentTermUtils;

/**
 * 	����ѧ��ѡ�����ĵĿ�����
 * @author Sherlock
 *
 */
@Controller
public class StudentElectiveController {
	@Autowired
	private ServiceStudent serviceStudent;
	
	@RequestMapping(value="/studentElective")
	public String studentElective(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ȡ��ǰѧ�ڵ�����ѡ�޿�
		List<Curriculum> list = serviceStudent.searchAllElectiveResultByStudentidAndTermid(student.getId(), 
				GetCurrentTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		if (serviceStudent.searchAllTempElectiveByStudentid(student.getId()).size()>0) {
			//�����ѡ��ѡ�޿�
			request.setAttribute("iselected", 1);			
		} else {
			request.setAttribute("iselected", 0);
		}
		//��ת��ѧ��ѡ������ҳ��
		return "student/student_elective";
	}
	
	@RequestMapping(value="/studentSelectElective")
	public String studentSelectElective(HttpServletRequest request,Integer id) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ѡ�޿μ�¼��ӵ����ݿ���
		serviceStudent.addTempElectiveByStudentid(student.getId(), id);
		//��ת��ѧ��ѡ������ҳ��
		return "redirect:studentElective";
	}
	
}
