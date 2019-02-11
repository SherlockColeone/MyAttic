package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanCet;
import com.cn.bean.Cet;
import com.cn.bean.Gradecet;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceTeacher;

/**
 * 	����Ա��ῼ�԰��ŵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCetController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminCet")
	public String adminCet(HttpServletRequest request) {
		//��ת������Ա��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCet")
	public String adminSelectCetByCetidAndStudentidForCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
//		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
//		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
//		request.setAttribute("beancet", beancet);
		//��ת������Ա��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminCheckCet")
	public String adminCheckCet(HttpServletRequest request) {
		//��ת������Ա�鿴��ῼ��ҳ��
		return "admin/admin_checkcet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCheckCet")
	public String adminSelectCetByCetidAndStudentidForCheckCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
//		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
//		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
//		request.setAttribute("beancet", beancet);
		//��ת������Ա�鿴��ῼ��ҳ��
		return "admin/admin_checkcet";
	}

}
