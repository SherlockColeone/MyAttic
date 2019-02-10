package com.cn.web.teacher;

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
 * 进入学生成绩管理（教师）的控制器
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

	// 用于显示该教师该学期的所有课程
	private List<Curriculum> list = new ArrayList<>();
	// 用于显示该专业课下所有学生成绩
	private List<BeanStuscore> resultList = new ArrayList<>();
	// 用于显示已选择的课程
	private String curriculum = "";
	//用于显示课程编号
	private int curriculumId = 0;
	//用于显示课程类型
	private int type = 2;

	/**
	 * 显示该教师目前学期的所有课程
	 * 
	 * @param request 请求
	 * @return 跳转到教师成绩管理页面
	 */
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		// 查找该教师该学期的所有课程
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		request.setAttribute("curriculumId", curriculumId);
		request.setAttribute("type", type);
		//将该五个变量设置为初始值，避免其他方法调用已存入的值
		list = new ArrayList<>();
		resultList = new ArrayList<>();
		curriculum = "";
		curriculumId = 0;
		type = 2;
		// 跳转到教师学生成绩管理页面
		return "teacher/teacher_modifystuscore";
	}

	/**
	 * 显示已选择课程的所有学生成绩
	 * 
	 * @param request 请求
	 * @return 重定向到教师成绩管理页面
	 */
	@RequestMapping(value = "/teacherSelectStuscore/{id}/{coursesid}")
	public String teacherSelectStuscore(HttpServletRequest request, @PathVariable("id") Integer id,
			@PathVariable("coursesid") Integer coursesid) {
		if (coursesid != 0) { // 选择的是专业课
			curriculum = checkNameUtils.searchByCoursesId(id);
			// 根据专业课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
			// 设置专业课标记，0为专业课
			type = 0;
		} else { // 选择的是选修课
			curriculum = checkNameUtils.searchByElectiveId(id);
			// 根据选修课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
			// 设置选修课标记，1为选修课
			type = 1;
		}
		// 设置课程名称
		request.setAttribute("curriculum", curriculum);
		// 设置课程id
		curriculumId = id;
		// 重定向到教师学生成绩管理页面（由于该方法的url已改变，不能用跳转）
		return "redirect:/teacherStuscore";
	}

	/**
	 * 添加或修改该课程的学生成绩
	 * 
	 * @param request      请求
	 * @param curriculumId 课程id（专业课id或选修课id）
	 * @param type         课程类型，0为专业课，1为选修课
	 * @param result       学号加上成绩的字符串
	 * @return 跳转到教师成绩查询页面
	 */
	@RequestMapping(value = "/teacherModifyStuscore")
	public String teacherModifyStuscore(HttpServletRequest request, Integer type, Integer curriculumId, 
			String result) {
		if (type==0) { //专业课
			//上传专业课成绩
			serviceTeacher.modifyStuScoreByCoursesidAndResult(curriculumId, result);
		} else if(type==1) { //选修课
			//上传选修课成绩
			serviceTeacher.modifyStuScoreByElectiveidAndResult(curriculumId, result);
		}		
		return "redirect:/teacherCheckStuscore";
	}

	/**
	 * 跳转到教师查询成绩的页面
	 * 
	 * @param request 请求
	 * @return 跳转到教师查询成绩页面
	 */
	@RequestMapping(value = "/teacherCheckStuscore")
	public String teacherCheckStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		// 查找该教师该学期的所有课程
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//将该三个变量设置为初始值，避免其他方法调用已存入的值
		list = new ArrayList<>();
		resultList = new ArrayList<>();
		curriculum = "";
		// 跳转到教师查询成绩页面
		return "teacher/teacher_checkstuscore";
	}

	/**
	 * 显示已选择课程的所有学生成绩
	 * 
	 * @param request 请求
	 * @return 重定向到教师查询成绩页面
	 */
	@RequestMapping(value = "/teacherCheckSelectStuscore/{id}/{coursesid}")
	public String teacherCheckSelectStuscore(HttpServletRequest request, @PathVariable("id") Integer id,
			@PathVariable("coursesid") Integer coursesid) {
		if (coursesid != 0) { // 选择的是专业课
			curriculum = checkNameUtils.searchByCoursesId(id);
			// 根据专业课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { // 选择的是选修课
			curriculum = checkNameUtils.searchByElectiveId(id);
			// 根据选修课id查找所有学生成绩
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		// 重定向到教师学生查询成绩页面（由于该方法的url已改变，不能用跳转）
		return "redirect:/teacherCheckStuscore";
	}
}
