package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Cet;
import com.cn.bean.Gradecet;
import com.cn.service.ServiceTeacher;

/**
 * 	进入教师社会考试的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCetController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	//用于显示所有社会考试
	private List<Cet> list = new ArrayList<>();
	//用于显示查询的社会考试成绩
	BeanCet beancet = new BeanCet();
		
	/**
	 * 进入教师社会考试管理页面
	 * @param request 请求
	 * @return 跳转到教师社会考试管理页面
	 */
	@RequestMapping(value="/adminGradeCet")
	public String adminGradeCet(HttpServletRequest request) {
		//找到当前学期的所有社会考试
		list = serviceTeacher.searchAllCetByCurrentTermid();
		request.setAttribute("list", list);
		request.setAttribute("beancet", beancet);
		//跳转到教师社会考试管理页面
		return "admin/admin_cet";
	}
	
	/**
	 * 查找某个学生某次社会考试成绩
	 * @param request 请求
	 * @param cetid 社会考试id
	 * @param studentid 学号
	 * @return 跳转到教师社会考试管理页面
	 */
	@RequestMapping(value="/adminCheckGradecet")
	public String adminCheckGradecet(HttpServletRequest request,Integer cetid,Integer studentid) {
		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
		request.setAttribute("beancet", beancet);
		//跳转到教师社会考试管理页面
		return "redirect:/adminGradeCet";
	}

}
