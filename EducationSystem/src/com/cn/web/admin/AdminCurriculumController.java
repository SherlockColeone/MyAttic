package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	进入管理员查看课程表的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	@RequestMapping(value="/adminCurriculum")
	public String adminCurriculum(HttpServletRequest request) {
		//把学期列表添加到视图中
		termList = getTermUtils.getAllTerms();
		request.setAttribute("termList", termList);
		//查出学期的名字
		String term = "2018-09-2019-01";
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("admin");
		List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(), teacher.getId());
		request.setAttribute("resultList", resultList);
		//跳转到教师课程表页面
		return "admin/admin_curriculum";
	}
	
	/**
	 * 获取该教师某个学期的课程表
	 * @param request 请求
	 * @return 跳转到教师课程表页面
	 */
	@RequestMapping(value="/adminSearchCurriculum")
	public String adminSearchCurriculum(HttpServletRequest request,Integer termId) {
		//把学期列表添加到视图中
		termList = getTermUtils.getAllTerms();
		request.setAttribute("termList", termList);
		// 查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(termId, teacher.getId());
		request.setAttribute("resultList", resultList);
		//跳转到教师课程表页面
		return "admin/admin_curriculum";
	}
}
