package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Cet;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.service.ServiceAdmin;
import com.cn.utils.GetTermUtils;

/**
 * 	����Ա��ῼ�Գɼ�����Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminGradeCetController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	
	@RequestMapping(value="/adminGradecet")
	public String adminGradeCet(HttpServletRequest request) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//��ת������Ա��ῼ�Գɼ�����ҳ��
		return "admin/admin_gradecet";
	}
	
	@RequestMapping(value="/adminSelectGradecetBycetidAndStudentidForGradecet")
	public String adminSelectGradecetBycetidAndStudentidForGradecet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//����ѧ������ῼ��id�����ῼ�Գɼ�
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//���ҳ���ѡ�����ῼ��
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//����ѧ����ѧ������
		Student student = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid());
		request.setAttribute("studentName", student.getName());
		//��ת������Ա�鿴��ῼ�Գɼ�����ҳ��
		return "admin/admin_gradecet";
	}
	
	@RequestMapping(value="/adminModifyGradecet")
	public String adminModifyGradecet(HttpServletRequest request,Integer studentid,Integer cetid,
			Integer cetscore) {
		//����ѧ������ῼ��id���ҳ���ῼ�Գɼ�
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		//�������ĳɼ�
		gradecet.setCetscore(cetscore);
		//�޸���ῼ�Գɼ�
		serviceAdmin.modifyGradeCet(gradecet);
		//�ض��򵽹���Ա��ῼ�Գɼ�����ҳ��
		return "redirect:adminGradecet";
	}
	
	@RequestMapping(value="/adminCheckGradecet")
	public String adminCheckGradecet(HttpServletRequest request) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//��ת������Ա�鿴��ῼ�Գɼ�ҳ��
		return "admin/admin_checkgradecet";
	}
	
	@RequestMapping(value="/adminSelectGradecetBycetidAndStudentidForCheckGradecet")
	public String adminSelectCetByGradecetidAndStudentidForCheckGradecet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//����ѧ������ῼ��id�����ῼ�Գɼ�
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//���ҳ���ѡ�����ῼ��
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//����ѧ����ѧ������
		Student student = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid());
		request.setAttribute("studentName", student.getName());
		//��ת������Ա�鿴��ῼ�Գɼ�ҳ��
		return "admin/admin_checkgradecet";
	}

}
