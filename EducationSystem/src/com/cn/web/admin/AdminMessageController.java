package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Teacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	进入管理员个人信息的控制器
 * @author Sherlock
 *
 */

@Controller
public class AdminMessageController {
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/adminMessage")
	public String adminMessage() {
		//跳转到管理员个人信息页面
		return "admin/admin_message";
	}
	
	@RequestMapping(value="/adminModifyMessage")
	public String adminModifyMessage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//从session域中获取管理员对象
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//查询出二级学院的名字
		String academy = checkNameUtils.searchByAcademyId(teacher.getAcademyid());
		//把二级学院的名字放入视图中
		request.setAttribute("academy",academy);
		//跳转到管理员个人信息
		return "admin/admin_messagemodify";
	}
	
}
