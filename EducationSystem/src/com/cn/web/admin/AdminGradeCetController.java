package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Cet;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.service.ServiceAdmin;
import com.cn.utils.GetTermUtils;

/**
 * 	管理员社会考试成绩管理的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminGradeCetController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminGradecet")
	public String adminGradeCet(HttpServletRequest request) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//跳转到管理员社会考试成绩管理页面
		return "admin/admin_gradecet";
	}
	
	@RequestMapping(value="/adminSelectGradecetBycetidAndStudentidForGradecet")
	public String adminSelectGradecetBycetidAndStudentidForGradecet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//根据学号与社会考试id查出社会考试成绩
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//查找出已选择的社会考试
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//设置学号与学生姓名
		Student student = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid());
		request.setAttribute("studentName", student.getName());
		//跳转到管理员查看社会考试成绩管理页面
		return "admin/admin_gradecet";
	}
	
	@RequestMapping(value="/adminModifyGradecet")
	public String adminModifyGradecet(HttpServletRequest request,Integer studentid,Integer cetid,
			Integer cetscore) {
		//根据学号与社会考试id查找出社会考试成绩
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		//设置它的成绩
		gradecet.setCetscore(cetscore);
		//修改社会考试成绩
		serviceAdmin.modifyGradeCet(gradecet);
		//重定向到管理员社会考试成绩管理页面
		return "redirect:adminGradecet";
	}
	
	@RequestMapping(value="/adminCheckGradecet")
	public String adminCheckGradecet(HttpServletRequest request) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//跳转到管理员查看社会考试成绩页面
		return "admin/admin_checkgradecet";
	}
	
	@RequestMapping(value="/adminSelectGradecetBycetidAndStudentidForCheckGradecet")
	public String adminSelectCetByGradecetidAndStudentidForCheckGradecet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//根据学号与社会考试id查出社会考试成绩
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//查找出已选择的社会考试
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//设置学号与学生姓名
		Student student = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid());
		request.setAttribute("studentName", student.getName());
		//跳转到管理员查看社会考试成绩页面
		return "admin/admin_checkgradecet";
	}

}
