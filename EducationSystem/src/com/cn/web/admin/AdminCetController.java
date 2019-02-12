package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Cet;
import com.cn.bean.Classroom;
import com.cn.bean.Gradecet;
import com.cn.service.ServiceAdmin;
import com.cn.utils.GetTermUtils;

/**
 * 	管理员社会考试安排的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminCetController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminCet")
	public String adminCet(HttpServletRequest request) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//跳转到管理员社会考试管理页面
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCet")
	public String adminSelectCetByCetidAndStudentidForCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//查找出已选择的社会考试
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//根据学号与社会考试id查找社会考试成绩
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//查找出考生的姓名
		String studentName = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid()).getName();
		request.setAttribute("studentName", studentName);
		//查找出所有的课室
		List<Classroom> classroomList = serviceAdmin.searchAllClassroom();
		request.setAttribute("classroomList", classroomList);
		//设置课室id
		request.setAttribute("classroom", gradecet.getClassroomid());
		//跳转到管理员社会考试管理页面
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminModifyCet")
	public String adminModifyCet(HttpServletRequest request,Integer studentid,Integer classroomid) {
		//将地点与学号设置到一个社会考试成绩对象中
		Gradecet gradecet = new Gradecet();
		gradecet.setStudentid(studentid);
		gradecet.setClassroomid(classroomid);
		//修改社会考试成绩
		serviceAdmin.modifyGradeCet(gradecet);
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//跳转到管理员社会考试管理页面
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminCheckCet")
	public String adminCheckCet(HttpServletRequest request) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//跳转到管理员查看社会考试页面
		return "admin/admin_checkcet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCheckCet")
	public String adminSelectCetByCetidAndStudentidForCheckCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//获取当前学期的所有社会考试
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//查找出已选择的社会考试
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//根据学号与社会考试id查找社会考试成绩
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//查找出考生的姓名
		String studentName = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid()).getName();
		request.setAttribute("studentName", studentName);
		//查找出课室
		Classroom classroom = serviceAdmin.searchClassroomByClassroomid(gradecet.getClassroomid());
		request.setAttribute("classroom", classroom.getName());
		//跳转到管理员查看社会考试页面
		return "admin/admin_checkcet";
	}

}
