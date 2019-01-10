package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Student;
import com.cn.service.ServiceStudent;

/**
 * 	进入学生社会考试的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherCetController {
	@Autowired
	private ServiceStudent serviceStudent;
		
	/**
	 * 进入学生社会考试成绩页面
	 * @param request 请求
	 * @return 跳转到学生社会考试页面
	 */
	@RequestMapping(value="/studentGradeCet")
	public String studentGradeCet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//设置准考证号
		request.setAttribute("studentId", student.getId());
		//找到该学生的所有社会考试成绩
		List<BeanCet> listScore = serviceStudent.searchAllGradeCetScoreByStudentid(student.getId());		
		request.setAttribute("listScore", listScore);
		//找到该学生的所有社会考试报名
		List<BeanCet> listApply = serviceStudent.searchAllGradeCetApplyByStudentid(student.getId());		
		request.setAttribute("listApply", listApply);
		//跳转到学生社会考试页面
		return "student/student_gradecet";
	}
	
	/**
	 * 进入学生社会考试报名页面
	 * @param request 请求
	 * @return 跳转到学生社会考试报名页面
	 */
	@RequestMapping(value="/studentCet")
	public String studentCet(HttpServletRequest request) {
		//查找当前学期所有的社会考试
		List<BeanCet> list = serviceStudent.searchAllBeanCetByCurrentTerm();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//设置准考证号
		request.setAttribute("studentId", student.getId());		
		//跳转到学生社会考试报名页面
		return "student/student_cet";
	}
	
	/**
	 * 处理学生社会考试报名
	 * @param request 请求
	 * @return 重定向到学生社会考试成绩页面
	 */
	@RequestMapping(value="/studentApplyCet/{cetId}")
	public String studentApplyCet(HttpServletRequest request,@PathVariable("cetId")Integer cetId) {
		HttpSession session = request.getSession();
		//从session域中获取学生对象
		Student student = (Student) session.getAttribute("student");
		//在社会考试成绩表中添加学生的信息
		serviceStudent.addGradecetApplyByStudentidAndCetid(student.getId(), cetId);
		//重定向到学生社会考试成绩页面（PS：由于本方法带参数，因此重定向时需要带上/）
		return "redirect:/studentGradeCet";
	}
	
}
