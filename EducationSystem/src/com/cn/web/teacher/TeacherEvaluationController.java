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
 * 	进入教师评价结果的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherEvaluationController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	/**
	 * 	跳转到教师评价结果页面
	 * @param request 请求
	 * @return 跳转到教师评价结果页面
	 */
	@RequestMapping(value="/teacherEvaluation")
	public String teacherEvaluation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		request.setAttribute("teacher", teacher);		
		//找到该教师的所有教学评价
		List<Evaluation> listEvaluation = serviceTeacher.searchAllEvaluationByTeacherid(teacher.getId());
		//将统计总人数放进视图中
		request.setAttribute("sum", listEvaluation.size());
		//转换成BeanEvaluation的形式
		List<BeanEvaluation> list = serviceTeacher.GetStatisticsByListEvaluation(listEvaluation);
		request.setAttribute("list", list);
		//跳转到教师评价结果页面
		return "teacher/teacher_evaluation";
	}
	
}
