package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanEvaluation;
import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetCurrentTermUtils;

/**
 * 	����ѧ����ʦ���۵Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	/**
	 * ��ת��ѡ���ʦ��ҳ��
	 * @param request ����
	 * @return ��ת��ѧ����ʦ����ҳ�棨ѡ���ʦ��
	 */
	@RequestMapping(value="/studentEvaluation")
	public String studentEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//���ݵ�ǰѧ����ѧ���ҵ������ο���ʦ
		List<Stuscore> stuScore = serviceStudent.searchAllStuScoreByStudentidAndTermid(student.getId(),
				GetCurrentTermUtils.getCurrentTermiId());
		List<Curriculum> list = new ArrayList<>();
		for (Stuscore score : stuScore) {
			if(score.getCouresid()!=0) { //רҵ��
				Courses courses = serviceStudent.searchCoursesByCoursesId(score.getCouresid());
				//����Ƿ������۸ý�ʦ
				Integer check = serviceStudent.checkEvaluationByStudentidAndTeacherid(student.getId(), courses.getTeacherid());
				//termid���������ڷ����Ƿ�������
				Curriculum curriculum = new Curriculum(courses.getName(), courses.getTeacher(), check, courses.getTeacherid(),
						courses.getId(), 0);
				list.add(curriculum);
			}
			else { //ѡ�޿�
				Elective elective = serviceStudent.searchElectiveById(score.getElectiveid());
				//����Ƿ������۸ý�ʦ
				Integer check = serviceStudent.checkEvaluationByStudentidAndTeacherid(student.getId(), elective.getTeacherid());
				//termid���������ڷ����Ƿ�������
				Curriculum curriculum = new Curriculum(elective.getName(), elective.getTeacher(), check, elective.getTeacherid(),
						0, elective.getId());
				list.add(curriculum);
			}			
		}
		request.setAttribute("list", list);
		//��ת��ѧ����ʦ����ҳ�棨ѡ���ʦ��
		return "student/student_evaluation";
	}
	
	/**
	 * ��ת����д���۵�ҳ��
	 * @param request ����
	 * @return ��ת��ѧ����ʦ����ҳ�棨��д���ۣ�
	 */
	@RequestMapping(value="/studentEvaluationForm/{teacherid}")
	public String studentEvaluationForm(HttpServletRequest request,@PathVariable("teacherid")Integer teacherid) {
		String teacherName = checkNameUtils.searchByTeacherId(teacherid);
		//�ѽ�ʦ��������������ҳ��
		request.setAttribute("teacherid", teacherid);
		request.setAttribute("teacherName", teacherName);
		//��ת��ѧ����ʦ����ҳ�棨��д���ۣ�
		return "student/student_evaluationform";
	}
	
	/**
	 * �ύ��ʦ����
	 * @param request ����
	 * @param content ��ʦ��������
	 * @return �ض���ѧ����ʦ����ҳ�棨ѡ���ʦ��
	 */
	@RequestMapping(value="/studentEvaluationSubmit")
	public String studentEvaluationSubmit(HttpServletRequest request,BeanEvaluation content) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//�ѱ���������ѧ��ѧ����ӽ�ȥ
		serviceStudent.addEvaluationByStudentidAndContent(student.getId(), content);
		//�ض���ѧ����ʦ����ҳ�棨ѡ���ʦ��
		return "redirect:studentEvaluation";
	}
	
}
