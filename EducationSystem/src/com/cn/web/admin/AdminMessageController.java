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
	 * 	����ǰ̨����ݡ�id����������ʾ������Ϣ
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
		if (identityResult==1) { //����ǹ���Ա
			Admin admin = user.getAdmin();
			//�������ʱû�����룬���Ҫ��Ĭ�ϵ�����123456
			admin.setPassword("123456");
			//ͬʱҪ�������
			admin.setIdentity(1);
			serviceAdmin.addAdmin(admin);
		} else if(identityResult==2) { //����ǽ�ʦ
			Teacher teacher = user.getTeacher();
			teacher.setPassword("123456");
			teacher.setIdentity(2);
			serviceAdmin.addTeacher(teacher);
		} else if(identityResult==3) { //�����ѧ��
			Student student = user.getStudent();
			student.setPassword("123456");
			student.setIdentity(3);
			serviceAdmin.addStudent(student);
		}
		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminDeleteMessage")
	public String adminDeleteManage(HttpServletRequest request, User user, Integer identityResult) {
		if (identityResult==1) { //����ǹ���Ա
			serviceAdmin.delAdminByAdminid(user.getAdmin().getId());
		} else if(identityResult==2) { //����ǽ�ʦ
			serviceAdmin.delTeacherByTeacherid(user.getTeacher().getId());
		} else if(identityResult==3) { //�����ѧ��
			serviceAdmin.delStudentByStudentid(user.getStudent().getId());
		}
		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

	@RequestMapping(value = "/adminModifyMessage")
	public String adminModifyMessage(HttpServletRequest request, User user, Integer identityResult) {
		if (identityResult==1) { //����ǹ���Ա
			serviceAdmin.modifyAdmin(user.getAdmin());
		} else if(identityResult==2) { //����ǽ�ʦ
			serviceAdmin.modifyTeacher(user.getTeacher());
		} else if(identityResult==3) { //�����ѧ��
			serviceAdmin.modifyStudent(user.getStudent());
		}
		// ��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}

}
