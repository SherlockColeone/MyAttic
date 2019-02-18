package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculumarrange;
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
		//跳转到查看教师调课页面
		return "admin/admin_checkcurriculumarrange";
	}
	
	@RequestMapping(value="/adminSearchCurriculumarrange")
	public String adminSearchCurriculumarrange(HttpServletRequest request,Integer teacherid) {		
		//查询该教师所有调课
		List<Curriculumarrange> list = serviceAdmin.searchAllCurriculumArrangeByTeacherid(teacherid);
		request.setAttribute("list", list);
		//设置教师工号
		request.setAttribute("teacherid", teacherid);
		//跳转到教师调课管理页面
		return "admin/admin_checkcurriculumarrange";
	}	
}
