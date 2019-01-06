package com.cn.web.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Exam;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;
import com.cn.utils.CheckNameUtils;

/**
 * 	���뿼�԰��ţ�ѧ�����Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentExamController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/studentExam")
	public String studentExam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		String classes = checkNameUtils.searchByClassesId(student.getClassesid());
		request.setAttribute("classes", classes);
		//��ѯ�������п���
		List<Exam> list = serviceStudent.searchAllExamByClassesid(student.getClassesid());
		List<Curriculum> listResult = new ArrayList<>();
		for (Exam exam : list) {
			//�ҵ�ÿ���γ̶�Ӧ������
			String name = checkNameUtils.searchByCoursesId(exam.getCoursesid());
			Curriculum temp = new Curriculum(exam.getId(), name, null, null, exam.getExamtime(), null, exam.getPlace(), null, exam.getClassesid(), null, null, exam.getCoursesid(), null, classes);		
			listResult.add(temp);
		}				
		request.setAttribute("list", listResult);
		//��ת��ѧ���������ҳ��
		return "student/student_exam";
	}
	
}
