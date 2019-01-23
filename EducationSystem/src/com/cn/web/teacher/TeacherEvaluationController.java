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
import com.cn.bean.Teacher;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	�����ʦ���۽���Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	/**
	 * 	��ת����ʦ���۽��ҳ��
	 * @param request ����
	 * @return ��ת����ʦ���۽��ҳ��
	 */
	@RequestMapping(value="/teacherEvaluation")
	public String teacherEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacher", teacher);
		//�ҵ��ý�ʦ�����н�ѧ����
		serviceTeacher.searchAllEvaluationByTeacherid(teacher.getId());
		//ת����
		
		
		request.setAttribute("list", teacher);
		//��ת����ʦ���۽��ҳ��
		return "teacher/teacher_evaluation";
	}
	
}
