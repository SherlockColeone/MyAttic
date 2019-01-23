package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Teacher;
import com.cn.utils.CheckNameUtils;

/**
 * 	�����ʦ������Ϣ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminMessageController {
	@Autowired
	private CheckNameUtils checkNameUtils;
	
	@RequestMapping(value="/adminMessage")
	public String adminMessage(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ������ѧԺ������
		String academy = checkNameUtils.searchByAcademyId(teacher.getAcademyid());
		//�ѽ�ʦ������Ϣ���ӵ���ͼ��
		mv.addObject("teacher", teacher);
		//�Ѷ���ѧԺ�����ַ�����ͼ��
		request.setAttribute("academy",academy);
		//��ת����ʦ������Ϣ
		return "admin/admin_message";
	}
	
}