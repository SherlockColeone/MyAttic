package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanElective;
import com.cn.bean.Courses;
import com.cn.bean.Stuscore;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	�������Աרҵ�ι�����ѯѧ���ɼ��Ŀ�����
 * 
 * @author Sherlock
 *
 */

@Controller
public class AdminStuscoreController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private GetTermUtils getTermUtils;
	@Autowired
	private CheckNameUtils checkNameUtils;

	@RequestMapping(value = "/adminStuscore")
	public String adminStuscore(HttpServletRequest request) {
		List<Term> termList = getTermUtils.getAllTerms();
		//�������е�ѧ��
		request.setAttribute("termList", termList);
		// ��ת������Ա�鿴ѧ���ɼ�ҳ��
		return "admin/admin_stuscore";
	}

	@RequestMapping(value = "/adminCheckStuscore")
	public String adminCheckStuscore(HttpServletRequest request,Integer studentid,Integer termid) {
		List<Term> termList = getTermUtils.getAllTerms();
		//�������е�ѧ��
		request.setAttribute("termList", termList);
		//����ѧ��ѧ�š�������ѧ��
		request.setAttribute("studentid", studentid);
		String studentName = checkNameUtils.searchByStudentId(studentid);
		request.setAttribute("studentName", studentName);
		String termName = checkNameUtils.searchByTermid(termid);
		request.setAttribute("termName", termName);
		//����ѧ����ѧ�ڲ��ҳɼ�����
		List<Stuscore> resultList = serviceAdmin.searchAllStuscoreByStudentidAndTermid(studentid,termid);
		request.setAttribute("resultList", resultList);
		// ��ת������Ա�鿴ѧ���ɼ�ҳ��
		return "admin/admin_stuscore";
	}
		
	@RequestMapping(value = "/adminStuscoremodify")
	public String adminCheckSelectStuscore(HttpServletRequest request) {
		//��ת������Ա¼��רҵ��ҳ��
		return "admin/admin_stuscoremodify";
	}
	
	@RequestMapping(value = "/adminStuscoreCheckClassess")
	public String adminStuscoreCheckClassess(HttpServletRequest request,Integer classesid) {
		List<Courses> coursesList = serviceAdmin.searchAllCoursesByClassesidAndTermid(classesid, GetTermUtils.getCurrentTermiId());
		request.setAttribute("coursesList", coursesList);
		String classesName = checkNameUtils.searchByClassesId(classesid);
		//���ð༶����
		request.setAttribute("classesName", classesName);
		//���ð༶���
		request.setAttribute("classesid", classesid);
		//��ʾרҵ��¼������
		List<BeanElective> list = serviceAdmin.showBeanCoursesList(classesid,GetTermUtils.getCurrentTermiId());
		//��ʾרҵ��¼������
		request.setAttribute("list",list);
		//��ת������Ա¼��רҵ��ҳ��
		return "admin/admin_stuscoremodify";
	}
	
	@RequestMapping(value = "/adminAddStuscore")
	public String adminAddStuscore(HttpServletRequest request,String result,Integer classesid) {
		//��������������ַ�������ָ�ɶ��ѡ�޿α��
		List<Integer> idList = serviceAdmin.splitResult(result);
		//�������		
		serviceAdmin.addStuscoreByElectiveidListAndClassesid(idList,classesid);
		//�ض��򵽹���Ա¼��רҵ��ҳ��
		return "redirect:adminStuscoremodify";
	}

}
