package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		//重定向到管理员录入专业课页面
		return "admin/admin_stuscoremodify";
	}
	
	/**
	 * 	显示已选择课程的所有学生成绩
	 * 
	 * @param request 请求
	 * @return 重定向到教师成绩管理页面
	 */
	@RequestMapping(value = "/adminSelectStuscore/{id}/{coursesid}")
	public String adminSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
			@PathVariable("coursesid")Integer coursesid) {
//		if (coursesid!=0) { //选择的是专业课
//			curriculum = checkNameUtils.searchByCoursesId(id);
//			//根据专业课id查找所有学生成绩
//			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
//			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
//		} else { //选择的是选修课
//			curriculum = checkNameUtils.searchByElectiveId(id);
//			//根据选修课id查找所有学生成绩
//			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
//			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
//		}
//		request.setAttribute("curriculum", curriculum);
//		request.setAttribute("list", list);
//		request.setAttribute("resultList", resultList);
		//重定向到教师学生成绩管理页面
		return "redirect:/adminStuscore";
	}

}
