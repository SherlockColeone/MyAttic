package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;

/**
 * 	��ʦ�γ̰��ŵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCoursesController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	��ѧ�ڷ������ѧ��ѡ����
	 * @param request ����
	 * @return ��ת����ʦ�γ̰���ҳ��
	 */
	@RequestMapping(value="/teacherCourses")
	public String studentCourses(HttpServletRequest request) {
		termList = serviceStudent.searchAllTerm();
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//��ת����ʦ�γ̰���
		return "student/student_courses";
	}
	
	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * @param request ����
	 * @param termId �ӱ���ȡ��ѧ��id
	 * @param curriculum �ӱ���ȡ�Ŀγ����ʡ�0��ʾ�������ʣ�1��ʾרҵ�Σ�2��ʾѡ�޿�
	 * @return ��ת����ʦ�γ̰���ҳ��
	 */
	@RequestMapping(value="/teacherSearchAllCourses")
	public String studentSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//���ѧ�ڵ�����
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Student student = (Student) session.getAttribute("student");
		if(curriculum==0) { //���ʲ���
			//��ѯ��ѧ�ڵ����пγ�
			List<Curriculum> resultList = serviceStudent.searchCurriculumByStudentidAndTermid(student.getId(), termId);
			//�ѽ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","��������");
		} 
		else if(curriculum==1) { //רҵ��
			List<Courses> resultList = serviceStudent.searchAllCoursesByStudentidAndTermid(student.getId(), termId);
			//��רҵ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","רҵ��");
		}
		else if(curriculum==2) { //ѡ�޿�
			List<Curriculum> resultList = new ArrayList<>();
			List<Elective> list = serviceStudent.searchAllElectiveByStudentidAndTermid(student.getId(), termId);
			for (Elective elective : list) {
				Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getTeacher(), null,
						0, elective.getId());
				resultList.add(curr);
			}			
			//��ѡ�޿��б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","ѡ�޿�");
		}
		return "student/student_courses";
	}
}
