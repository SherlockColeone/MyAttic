package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Cet;
import com.cn.bean.Classroom;
import com.cn.bean.Gradecet;
import com.cn.service.ServiceAdmin;
import com.cn.utils.GetTermUtils;

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
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//��ת������Ա��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCet")
	public String adminSelectCetByCetidAndStudentidForCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//���ҳ���ѡ�����ῼ��
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//����ѧ������ῼ��id������ῼ�Գɼ�
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//���ҳ�����������
		String studentName = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid()).getName();
		request.setAttribute("studentName", studentName);
		//���ҳ����еĿ���
		List<Classroom> classroomList = serviceAdmin.searchAllClassroom();
		request.setAttribute("classroomList", classroomList);
		//���ÿ���id
		request.setAttribute("classroom", gradecet.getClassroomid());
		//��ת������Ա��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminModifyCet")
	public String adminModifyCet(HttpServletRequest request,Integer studentid,Integer classroomid) {
		//���ص���ѧ�����õ�һ����ῼ�Գɼ�������
		Gradecet gradecet = new Gradecet();
		gradecet.setStudentid(studentid);
		gradecet.setClassroomid(classroomid);
		//�޸���ῼ�Գɼ�
		serviceAdmin.modifyGradeCet(gradecet);
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//��ת������Ա��ῼ�Թ���ҳ��
		return "admin/admin_cet";
	}
	
	@RequestMapping(value="/adminCheckCet")
	public String adminCheckCet(HttpServletRequest request) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//��ת������Ա�鿴��ῼ��ҳ��
		return "admin/admin_checkcet";
	}
	
	@RequestMapping(value="/adminSelectCetByCetidAndStudentidForCheckCet")
	public String adminSelectCetByCetidAndStudentidForCheckCet(HttpServletRequest request,Integer cetid,
			Integer studentid) {
		//��ȡ��ǰѧ�ڵ�������ῼ��
		List<Cet> list = serviceAdmin.searchAllCetByTermid(GetTermUtils.getCurrentTermiId());
		request.setAttribute("list", list);
		//���ҳ���ѡ�����ῼ��
		Cet cet = serviceAdmin.searchCetByCetid(cetid);
		request.setAttribute("cet", cet);
		//����ѧ������ῼ��id������ῼ�Գɼ�
		Gradecet gradecet = serviceAdmin.searchGradecetByStudentidAndCetid(studentid, cetid);
		request.setAttribute("gradecet", gradecet);
		//���ҳ�����������
		String studentName = serviceAdmin.searchStudentByStudentid(gradecet.getStudentid()).getName();
		request.setAttribute("studentName", studentName);
		//���ҳ�����
		Classroom classroom = serviceAdmin.searchClassroomByClassroomid(gradecet.getClassroomid());
		request.setAttribute("classroom", classroom.getName());
		//��ת������Ա�鿴��ῼ��ҳ��
		return "admin/admin_checkcet";
	}

}
