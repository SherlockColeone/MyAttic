package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanArrange;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	进入教师调课通知的控制器
 * @author Sherlock
 *
 */

@Controller
public class TeacherCurriculumarrangeController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/teacherCurriculumarrange")
	public String teacherCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查询该教师所有已批准的调课
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacheridPermitted(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//查询该教师所有未批准或不批准的调课
		List<Curriculumarrange> listCurr2 = serviceTeacher.searchAllCurriculumArrangeByTeacheridNotpermitAndPermitting(teacher.getId());
		List<BeanArrange> list2 = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr2);		
		request.setAttribute("list2", list2);
		//跳转到查看调课通知页面
		return "teacher/teacher_curriculumarrange";
	}
	
	@RequestMapping(value="/teacherModifyCurriculumarrange")
	public String teacherModifyCurriculumarrange(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		//从session域中获取教师对象
//		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//查询该教师所有调课
//		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
//		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
//		request.setAttribute("list", list);
		//跳转到申请调课页面
		return "teacher/teacher_modifycurriculumarrange";
	}
	
	@RequestMapping(value="/teacherCurriculumarrangeSubmit")
	public String teacherCurriculumarrangeSubmit(HttpServletRequest request,Curriculumarrange arrange,
			Integer nature) {
		if (nature==0) {  //若性质为专业课
			//将id的值赋给专业课id
			arrange.setCoursesid(arrange.getId());
			//选修课id设置为0
			arrange.setElectiveid(0);
			//id设置为null
			arrange.setId(null);
		} else {  //若性质为选修课
			//将id的值赋给选修课id
			arrange.setElectiveid(arrange.getId());
			//专业课id设置为0
			arrange.setCoursesid(0);
			//id设置为null
			arrange.setId(null);
		}		
		HttpSession session = request.getSession();
		//从session域中获取教师对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//设置教师工号
		arrange.setTeacherid(teacher.getId());
		//设置为调课为未批准
		arrange.setPermit(0);
		//添加调课
		serviceTeacher.addCurriculumArrange(arrange);
		//跳转到申请调课页面
		return "redirect:teacherModifyCurriculumarrange";
	}
	
}
