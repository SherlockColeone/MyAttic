package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Teacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	�������Ա������Ϣ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminMessageController {
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/adminMessage")
	public String adminMessage() {
		//��ת������Ա������Ϣҳ��
		return "admin/admin_message";
	}
	
	@RequestMapping(value="/adminModifyMessage")
	public String adminModifyMessage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ����Ա����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ������ѧԺ������
		String academy = checkNameUtils.searchByAcademyId(teacher.getAcademyid());
		//�Ѷ���ѧԺ�����ַ�����ͼ��
		request.setAttribute("academy",academy);
		//��ת������Ա������Ϣ
		return "admin/admin_messagemodify";
	}
	
}
