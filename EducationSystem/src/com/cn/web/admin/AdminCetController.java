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
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ��ῼ�ԵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCetController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	//������ʾ������ῼ��
	private List<Cet> list = new ArrayList<>();
	//������ʾ��ѯ����ῼ�Գɼ�
	BeanCet beancet = new BeanCet();
		
	/**
	 * �����ʦ��ῼ�Թ���ҳ��
	 * @param request ����
	 * @return ��ת����ʦ��ῼ�Թ���ҳ��
	 */
	@RequestMapping(value="/adminGradeCet")
	public String adminGradeCet(HttpServletRequest request) {
		//�ҵ���ǰѧ�ڵ�������ῼ��
		list = serviceTeacher.searchAllCetByCurrentTermid();
		request.setAttribute("list", list);
		request.setAttribute("beancet", beancet);
		//��ת����ʦ��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	/**
	 * ����ĳ��ѧ��ĳ����ῼ�Գɼ�
	 * @param request ����
	 * @param cetid ��ῼ��id
	 * @param studentid ѧ��
	 * @return ��ת����ʦ��ῼ�Թ���ҳ��
	 */
	@RequestMapping(value="/adminCheckGradecet")
	public String adminCheckGradecet(HttpServletRequest request,Integer cetid,Integer studentid) {
		Gradecet gradeCet = serviceTeacher.searchGradeCetByStudentidAndCetid(studentid, cetid);
		beancet = serviceTeacher.changeGradecetIntoBeanCetByStudentid(gradeCet, studentid);
		request.setAttribute("beancet", beancet);
		//��ת����ʦ��ῼ�Թ���ҳ��
		return "redirect:/adminGradeCet";
	}

}
