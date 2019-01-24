package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	教师课程安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCoursesController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	将学期放入表单的学期选项中
	 * @param request 请求
	 * @return 跳转到教师课程安排页面
	 */
	@RequestMapping(value="/adminCourses")
	public String adminCourses(HttpServletRequest request) {
		termList = getTermUtils.getAllTerms();
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//跳转到教师课程安排
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCheckCourses")
	public String adminCheckCourses(HttpServletRequest request) {
		termList = getTermUtils.getAllTerms();
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//跳转到教师课程安排
		return "admin/admin_courses";
	}
	
	/**
	 * 	根据选择的条件查询出课程安排
	 * @param request 请求
	 * @param termId 从表单获取的学期id
	 * @param curriculum 从表单获取的课程性质。0表示不限性质；1表示专业课；2表示选修课
	 * @return 跳转到教师课程安排页面
	 */
	@RequestMapping(value="/adminSearchAllCourses")
	public String adminSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//把学期列表添加到视图中
		request.setAttribute("termList",termList);
		//查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");		
		if(curriculum==0) { //性质不限
			//查询该学期的所有课程
			List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(termId, teacher.getId());
			//把结果列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","不限性质");
		} 
		else if(curriculum==1) { //专业课
			List<Courses> resultList = serviceTeacher.searchAllCoursesByTeacheridAndTermid(teacher.getId(), termId);
			//把专业课列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","专业课");
		}
		else if(curriculum==2) { //选修课
			List<Curriculum> resultList = new ArrayList<>();
			List<Elective> list = serviceTeacher.searchAllElectiveByTeacheridAndTermid(teacher.getId(), termId);
			//由于选修课缺少某些属性无法在页面中显示，因此转换成总课程对象显示
			for (Elective elective : list) {
				Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getTeacher(), null,
						0, elective.getId());
				resultList.add(curr);
			}			
			//把选修课列表添加到视图中
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","选修课");
		}
		return "admin/admin_courses";
	}
}
