package com.cn.web.admin;

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
 * 	�����ʦ����֪ͨ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumarrangeController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/adminCurriculumarrange")
	public String adminCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ�ý�ʦ���е���
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//��ת����ʦ����֪ͨҳ��
		return "admin/admin_curriculumarrange";
	}
	
}