package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculumarrange;
import com.cn.service.ServiceAdmin;

/**
 * 	�����ʦ����֪ͨ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumarrangeController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminCurriculumarrange")
	public String adminCurriculumarrange(HttpServletRequest request) {		
		//��ѯ����δ��׼�ĵ���
		List<Curriculumarrange> list = serviceAdmin.searchAllCurriculumArrangeUnpermit();
		request.setAttribute("list", list);
		//��ת����ʦ���ι���ҳ��
		return "admin/admin_curriculumarrange";
	}
	
	@RequestMapping(value="/adminCurriculumarrangePermit")
	public String adminCurriculumarrangePermit(HttpServletRequest request,Integer id,Integer permit) {
		//����id���ұ��еĵ���
		Curriculumarrange curriculumarrange = serviceAdmin.searchCurriculumarrangeByCurriculumarrangeid(id);
		//�����Ƿ���׼
		curriculumarrange.setPermit(permit);
		//�޸ĸõ�����Ϣ
		serviceAdmin.modifyCurriculumArrange(curriculumarrange);
		//�ض��򵽽�ʦ���ι���ҳ��
		return "redirect:adminCurriculumarrange";
	}	
	
	@RequestMapping(value="/adminCheckCurriculumarrange")
	public String adminCheckCurriculumarrange(HttpServletRequest request) {
		//��ת���鿴��ʦ����ҳ��
		return "admin/admin_checkcurriculumarrange";
	}
	
	@RequestMapping(value="/adminSearchCurriculumarrange")
	public String adminSearchCurriculumarrange(HttpServletRequest request,Integer teacherid) {		
		//��ѯ�ý�ʦ���е���
		List<Curriculumarrange> list = serviceAdmin.searchAllCurriculumArrangeByTeacherid(teacherid);
		request.setAttribute("list", list);
		//���ý�ʦ����
		request.setAttribute("teacherid", teacherid);
		//��ת����ʦ���ι���ҳ��
		return "admin/admin_checkcurriculumarrange";
	}	
}
