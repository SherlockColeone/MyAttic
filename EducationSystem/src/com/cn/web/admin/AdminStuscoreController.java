package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		//�ض��򵽹���Ա¼��רҵ��ҳ��
		return "admin/admin_stuscoremodify";
	}
	
	/**
	 * 	��ʾ��ѡ��γ̵�����ѧ���ɼ�
	 * 
	 * @param request ����
	 * @return �ض��򵽽�ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/adminSelectStuscore/{id}/{coursesid}")
	public String adminSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
			@PathVariable("coursesid")Integer coursesid) {
//		if (coursesid!=0) { //ѡ�����רҵ��
//			curriculum = checkNameUtils.searchByCoursesId(id);
//			//����רҵ��id��������ѧ���ɼ�
//			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
//			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
//		} else { //ѡ�����ѡ�޿�
//			curriculum = checkNameUtils.searchByElectiveId(id);
//			//����ѡ�޿�id��������ѧ���ɼ�
//			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
//			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
//		}
//		request.setAttribute("curriculum", curriculum);
//		request.setAttribute("list", list);
//		request.setAttribute("resultList", resultList);
		//�ض��򵽽�ʦѧ���ɼ�����ҳ��
		return "redirect:/adminStuscore";
	}

}
