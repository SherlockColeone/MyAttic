package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
import com.cn.service.ServiceTeacher;

/**
 * 	进入教师社会考试的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherCetController {
	@Autowired
	private ServiceTeacher serviceTeacher;
		
	/**
	 * 进入教师社会考试管理页面
	 * @param request 请求
	 * @return 跳转到教师社会考试管理页面
	 */
	@RequestMapping(value="/teacherGradeCet")
	public String teacherGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//设置准考证号
//		request.setAttribute("studentId", student.getId());
//		//找到该教师的所有社会考试成绩
//		List<BeanCet> listScore = serviceTeacher.searchAllGradeCetScoreByTeacherid(student.getId());		
//		request.setAttribute("listScore", listScore);
//		//找到该教师的所有社会考试报名
//		List<BeanCet> listApply = serviceTeacher.searchAllGradeCetApplyByTeacherid(student.getId());		
//		request.setAttribute("listApply", listApply);
		//跳转到教师社会考试页面
		return "teacher/teacher_gradecet";
	}
	
	/**
	 * 进入教师社会考试报名页面
	 * @param request 请求
	 * @return 跳转到教师社会考试报名页面
	 */
	@RequestMapping(value="/teacherCet")
	public String teacherCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//查找当前学期所有的社会考试
//		List<BeanCet> list = serviceTeacher.searchAllBeanCetByCurrentTerm();
//		request.setAttribute("list", list);		
//		//设置准考证号
//		request.setAttribute("studentId", student.getId());		
		//跳转到教师社会考试报名页面
		return "teacher/teacher_cet";
	}
	
	/**
	 * 处理教师社会考试报名
	 * @param request 请求
	 * @return 重定向到教师社会考试成绩页面
	 */
	@RequestMapping(value="/teacherApplyCet/{cetId}")
	public String teacherApplyCet(HttpServletRequest request,@PathVariable("cetId")Integer cetId) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher student = (Teacher) session.getAttribute("student");
//		//在社会考试成绩表中添加教师的信息
//		serviceTeacher.addGradecetApplyByTeacheridAndCetid(student.getId(), cetId);
		//重定向到教师社会考试成绩页面（PS：由于本方法带参数，因此重定向时需要带上/）
		return "redirect:/teacherGradeCet";
	}
	
}
