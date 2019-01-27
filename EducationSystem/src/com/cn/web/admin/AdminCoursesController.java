package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	管理员课程安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCoursesController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	@RequestMapping(value="/adminCourses")
	public String adminCourses(HttpServletRequest request) {
		//跳转到管理查看课程安排页面
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCoursesModify")
	public String adminCoursesModify(HttpServletRequest request) {
		//跳转到管理员课程安排管理页面
		return "admin/admin_coursesmodify";
	}
	
	//判断课程编号是否需要随机编号
	private Integer checkId(Courses courses) {
		if (courses.getId()==0) {
			return null;
		} else {
			return courses.getId();
		}		
	}
	
	@RequestMapping(value="/adminInsertCourses")
	public String adminInsertCourses(HttpServletRequest request,Courses courses) {
		//设置编号
		courses.setId(checkId(courses));
		//添加课程
		serviceAdmin.addCourses(courses);
		//跳转到管理员课程安排
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminDeleteCourses")
	public String adminDeleteCourses(HttpServletRequest request,Courses courses) {
		//删除课程
		serviceAdmin.delCoursesByCoursesid(courses.getId());
		//跳转到管理员课程安排
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminModifyCourses")
	public String adminModifyCourses(HttpServletRequest request,Courses courses) {
		//设置编号
		courses.setId(checkId(courses));
		//修改课程
		serviceAdmin.modifyCourses(courses);		
		//跳转到管理员课程安排
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminCheckCoursesForCourses")
	public String adminCheckCoursesForCourses(HttpServletRequest request,Integer inputId) {
		Courses courses = serviceAdmin.searchCoursesByCoursesid(inputId);
		//把搜索的课程放到视图中
		request.setAttribute("courses",courses);
		//获取学期名字
		String termName = checkNameUtils.searchByTermid(courses.getTermid());
		request.setAttribute("termName",termName);
		//跳转到管理员查看课程安排
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCheckCoursesForCoursesModify")
	public String adminCheckCoursesForCoursesModify(HttpServletRequest request,Integer inputId,Integer operate) {
		//标记需要进行的操作
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Courses courses = new Courses();
		if (operate!=1) { //进行的是删除或修改操作
			courses = serviceAdmin.searchCoursesByCoursesid(inputId);
		}		
		//把搜索的课程放到视图中
		request.setAttribute("courses",courses);
		//获取所有学期
		List<Term> termList = getTermUtils.getAllTerms();
		request.setAttribute("termList",termList);
		//获取当前的学期id
		Integer currentTermiId = GetTermUtils.getCurrentTermiId();
		request.setAttribute("currentTermiId",currentTermiId);
		//跳转到管理员课程安排管理
		return "admin/admin_coursesmodify";
	}

}
