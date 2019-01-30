package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanStuscore;
import com.cn.bean.Curriculum;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
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
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;

	//用于显示该教师该学期的所有课程
	private List<Curriculum> list = new ArrayList<>();
	//用于显示该专业课下所有学生成绩
	private List<BeanStuscore> resultList = new ArrayList<>();
	//用于显示已选择的课程
	private String curriculum = "";

	/**
	 * 	显示该教师目前学期的所有课程
	 * 
	 * @param request 请求
	 * @return 跳转到教师成绩管理页面
	 */
	@RequestMapping(value = "/adminStuscore")
	public String adminStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查找该教师该学期的所有课程
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		// 跳转到教师学生成绩管理页面
		return "admin/admin_modifystuscore";
	}

	/**
	 * 	跳转到教师查询成绩的页面
	 * 
	 * @param request 请求
	 * @return 跳转到教师查询成绩页面
	 */
	@RequestMapping(value = "/adminCheckStuscore")
	public String adminCheckStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查找该教师该学期的所有课程
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		// 跳转到教师查询成绩页面
		return "admin/admin_checkstuscore";
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
		if (coursesid!=0) { //选择的是专业课
			curriculum = checkNameUtils.searchByCoursesId(id);
			//根据专业课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { //选择的是选修课
			curriculum = checkNameUtils.searchByElectiveId(id);
			//根据选修课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//重定向到教师学生成绩管理页面
		return "redirect:/adminStuscore";
	}
	

	
	/**
	 * 	显示已选择课程的所有学生成绩
	 * 
	 * @param request 请求
	 * @return 重定向到教师查询成绩页面
	 */
	@RequestMapping(value = "/adminCheckSelectStuscore/{id}/{coursesid}")
	public String adminCheckSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
			@PathVariable("coursesid")Integer coursesid) {
		if (coursesid!=0) { //选择的是专业课
			curriculum = checkNameUtils.searchByCoursesId(id);
			//根据专业课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { //选择的是选修课
			curriculum = checkNameUtils.searchByElectiveId(id);
			//根据选修课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//重定向到教师学生查询成绩页面
		return "redirect:/adminCheckStuscore";
	}
}
