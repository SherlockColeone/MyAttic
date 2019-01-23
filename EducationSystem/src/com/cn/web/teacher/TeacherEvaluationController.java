package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanEvaluation;
import com.cn.bean.Evaluation;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ���۽���Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
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
		List<Evaluation> listEvaluation = serviceTeacher.searchAllEvaluationByTeacherid(teacher.getId());
		//��ͳ���������Ž���ͼ��
		request.setAttribute("sum", listEvaluation.size());
		//ת����BeanEvaluation����ʽ
		List<BeanEvaluation> list = serviceTeacher.GetStatisticsByListEvaluation(listEvaluation);
		request.setAttribute("list", list);
		//��ת����ʦ���۽��ҳ��
		return "teacher/teacher_evaluation";
	}
	
}
