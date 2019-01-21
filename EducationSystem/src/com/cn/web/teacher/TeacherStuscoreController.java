package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.BeanStuscore;
import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	进入学生成绩管理（教师）的控制器
 * 
 * @author Sherlock
 *
 */

@Controller
public class TeacherStuscoreController {
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
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStuscore(HttpServletRequest request) {
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
		return "teacher/teacher_modifystuscore";
	}
	
	/**
	 * 	显示已选择课程的所有学生成绩
	 * 
	 * @param request 请求
	 * @return 跳转到教师成绩管理页面
	 */
	@RequestMapping(value = "/teacherSelectStuscore/{id}/{coursesid}")
	public String teacherSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
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
		// 跳转到教师学生成绩管理页面
		return "redirect:/teacherStuscore";
	}

	/**
	 * 	根据选择的条件查询出课程安排
	 * 
	 * @param request    请求
	 * @param termId     从表单获取的学期id
	 * @return 跳转到教师成绩查询页面
	 */
	@RequestMapping(value = "/teacherModifyStuscore")
	public String teacherModifyStuscore(HttpServletRequest request, Integer termId) {
		
		// 查出学期的名字
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//查询该学期的所有成绩
//		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(teacher.getId(), termId);
//		//把结果列表添加到视图中
//		request.setAttribute("resultList",resultList);
		return "teacher/teacher_stuscore";
	}
}
