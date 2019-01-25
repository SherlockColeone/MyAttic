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
 * �������Ա������Ϣ�Ŀ�����
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
		// ��ת������Ա������Ϣҳ��
		return "admin/admin_message";
	}

	@RequestMapping(value = "/adminMessageManage")
	public String adminMessageManage(HttpServletRequest request) {
		// ��ת������Ա������Ϣҳ��
		return "admin/admin_messagemodify";
	}

	/**
	 * ����ǰ̨����ݡ�id����������ʾ������Ϣ
	 * 
	 * @param request  ����
	 * @param identity ���
	 * @param id       ѧ�Ż򹤺�
	 * @param operate  ����
	 * @return ��ת������Ա������Ϣҳ��
	 */
	@RequestMapping(value = "/adminSearchUser")
	public String adminSearchUser(HttpServletRequest request, Integer identity, Integer id, Integer operate) {
		// ��ݵı��
		int identityResult = identity;
		// �����ı��
		int manageResult = operate;
		Admin admin = new Admin();
		Teacher teacher = new Teacher();
		Student student = new Student();
		if (operate != 1) { //��������Ӳ�������Ҫ���в�ѯ
			if (identity == 1) { // ����Ա���
				admin = serviceAdmin.searchAdminByAdminid(id);
			} else if (identity == 2) { // ��ʦ���
				teacher = serviceAdmin.searchTeacherByTeacherid(id);
			} else if (identity == 3) { // ѧ�����
				student = serviceAdmin.searchStudentByStudentid(id);
			}
		}
		request.setAttribute("admin", admin);
		request.setAttribute("teacher", teacher);
		request.setAttribute("student", student);
		// ������������
		request.setAttribute("identityResult", identityResult);
		request.setAttribute("manageResult", manageResult);
		// ��ת������Ա������Ϣҳ��
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminInsertMessage")
	public String adminInsertManage(HttpServletRequest request, User user, Integer identityResult) {

		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminDeleteMessage")
	public String adminDeleteManage(HttpServletRequest request, User user) {

		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminModifyMessage")
	public String adminModifyMessage(HttpServletRequest request, User user) {

		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

}
