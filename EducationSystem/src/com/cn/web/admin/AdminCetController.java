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
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceTeacher;

/**
 * 	管理员社会考试安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCetController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminCet")
	public String adminCet(HttpServletRequest request) {
		//跳转到管理员社会考试管理页面
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCet")
	public String adminSelectCetByCetidAndStudentidForCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
//		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
//		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
//		request.setAttribute("beancet", beancet);
		//跳转到管理员社会考试管理页面
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminCheckCet")
	public String adminCheckCet(HttpServletRequest request) {
		//跳转到管理员查看社会考试页面
		return "admin/admin_checkcet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCheckCet")
	public String adminSelectCetByCetidAndStudentidForCheckCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
//		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
//		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
//		request.setAttribute("beancet", beancet);
		//跳转到管理员查看社会考试页面
		return "admin/admin_checkcet";
	}

}
