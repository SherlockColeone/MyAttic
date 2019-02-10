package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanElective;
import com.cn.bean.Courses;
import com.cn.bean.Stuscore;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	进入管理员专业课管理、查询学生成绩的控制器
 * 
 * @author Sherlock
 *
 */

@Controller
public class AdminStuscoreController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private GetTermUtils getTermUtils;
	@Autowired
	private CheckNameUtils checkNameUtils;

	@RequestMapping(value = "/adminStuscore")
	public String adminStuscore(HttpServletRequest request) {
		List<Term> termList = getTermUtils.getAllTerms();
		//存入所有的学期
		request.setAttribute("termList", termList);
		// 跳转到管理员查看学生成绩页面
		return "admin/admin_stuscore";
	}

	@RequestMapping(value = "/adminCheckStuscore")
	public String adminCheckStuscore(HttpServletRequest request,Integer studentid,Integer termid) {
		List<Term> termList = getTermUtils.getAllTerms();
		//存入所有的学期
		request.setAttribute("termList", termList);
		//设置学生学号、姓名与学期
		request.setAttribute("studentid", studentid);
		String studentName = checkNameUtils.searchByStudentId(studentid);
		request.setAttribute("studentName", studentName);
		String termName = checkNameUtils.searchByTermid(termid);
		request.setAttribute("termName", termName);
		//根据学号与学期查找成绩集合
		List<Stuscore> resultList = serviceAdmin.searchAllStuscoreByStudentidAndTermid(studentid,termid);
		request.setAttribute("resultList", resultList);
		// 跳转到管理员查看学生成绩页面
		return "admin/admin_stuscore";
	}
		
	@RequestMapping(value = "/adminStuscoremodify")
	public String adminCheckSelectStuscore(HttpServletRequest request) {
		//跳转到管理员录入专业课页面
		return "admin/admin_stuscoremodify";
	}
	
	@RequestMapping(value = "/adminStuscoreCheckClassess")
	public String adminStuscoreCheckClassess(HttpServletRequest request,Integer classesid) {
		List<Courses> coursesList = serviceAdmin.searchAllCoursesByClassesidAndTermid(classesid, GetTermUtils.getCurrentTermiId());
		request.setAttribute("coursesList", coursesList);
		String classesName = checkNameUtils.searchByClassesId(classesid);
		//设置班级名称
		request.setAttribute("classesName", classesName);
		//设置班级编号
		request.setAttribute("classesid", classesid);
		//显示专业课录入的情况
		List<BeanElective> list = serviceAdmin.showBeanCoursesList(classesid,GetTermUtils.getCurrentTermiId());
		//显示专业课录入的情况
		request.setAttribute("list",list);
		//跳转到管理员录入专业课页面
		return "admin/admin_stuscoremodify";
	}
	
	@RequestMapping(value = "/adminAddStuscore")
	public String adminAddStuscore(HttpServletRequest request,String result,Integer classesid) {
		//将表单传输过来的字符串结果分割成多个选修课编号
		List<Integer> idList = serviceAdmin.splitResult(result);
		//进行添加		
		serviceAdmin.addStuscoreByElectiveidListAndClassesid(idList,classesid);
		//重定向到管理员录入专业课页面
		return "redirect:adminStuscoremodify";
	}

}
