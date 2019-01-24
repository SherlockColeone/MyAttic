package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanArrange;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	进入教师调课通知的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumarrangeController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/adminCurriculumarrange")
	public String adminCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查询该教师所有调课
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//跳转到教师调课通知页面
		return "admin/admin_curriculumarrange";
	}
	
	@RequestMapping(value="/adminCheckCurriculumarrange")
	public String adminCheckCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查询该教师所有调课
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//跳转到教师调课通知页面
		return "admin/admin_curriculumarrange";
	}
	
}
