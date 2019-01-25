package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.bean.User;
import com.cn.service.ServiceAdmin;

/**
 * 进入管理员个人信息的控制器
 * 
 * @author Sherlock
 *
 */

@Controller
public class AdminMessageController {
	@Autowired
	private ServiceAdmin serviceAdmin;

	@RequestMapping(value = "/adminMessage")
	public String adminMessage(HttpServletRequest request) {
		// 跳转到管理员个人信息页面
		return "admin/admin_message";
	}

	@RequestMapping(value = "/adminMessageManage")
	public String adminMessageManage(HttpServletRequest request) {
		// 跳转到管理员个人信息页面
		return "admin/admin_messagemodify";
	}

	/**
	 * 根据前台的身份、id、操作来显示个人信息
	 * 
	 * @param request  请求
	 * @param identity 身份
	 * @param id       学号或工号
	 * @param operate  操作
	 * @return 跳转到管理员个人信息页面
	 */
	@RequestMapping(value = "/adminSearchUser")
	public String adminSearchUser(HttpServletRequest request, Integer identity, Integer id, Integer operate) {
		// 身份的标记
		int identityResult = identity;
		// 操作的标记
		int manageResult = operate;
		Admin admin = new Admin();
		Teacher teacher = new Teacher();
		Student student = new Student();
		if (operate != 1) { //若进行添加操作则不需要进行查询
			if (identity == 1) { // 管理员身份
				admin = serviceAdmin.searchAdminByAdminid(id);
			} else if (identity == 2) { // 教师身份
				teacher = serviceAdmin.searchTeacherByTeacherid(id);
			} else if (identity == 3) { // 学生身份
				student = serviceAdmin.searchStudentByStudentid(id);
			}
		}
		request.setAttribute("admin", admin);
		request.setAttribute("teacher", teacher);
		request.setAttribute("student", student);
		// 设置身份与操作
		request.setAttribute("identityResult", identityResult);
		request.setAttribute("manageResult", manageResult);
		// 跳转到管理员个人信息页面
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminInsertMessage")
	public String adminInsertManage(HttpServletRequest request, User user, Integer identityResult) {

		// 跳转到管理员个人信息
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminDeleteMessage")
	public String adminDeleteManage(HttpServletRequest request, User user) {

		// 跳转到管理员个人信息
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminModifyMessage")
	public String adminModifyMessage(HttpServletRequest request, User user) {

		// 跳转到管理员个人信息
		return "admin/admin_messagemodify";
	}

}
