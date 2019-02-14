package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.service.ServiceAdmin;

/**
 * 	进入教师调课通知的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumarrangeController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminCurriculumarrange")
	public String adminCurriculumarrange(HttpServletRequest request) {
//		//查询该教师所有调课
//		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
//		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
//		request.setAttribute("list", list);
		//跳转到教师调课管理页面
		return "admin/admin_curriculumarrange";
	}
	
	@RequestMapping(value="/adminCheckCurriculumarrange")
	public String adminCheckCurriculumarrange(HttpServletRequest request) {
//		//查询该教师所有调课
//		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
//		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
//		request.setAttribute("list", list);
		//跳转到查看教师调课页面
		return "admin/admin_checkcurriculumarrange";
	}
	
}
