package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	�������Ա�鿴�γ̱�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCurriculumController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	@RequestMapping(value="/adminCurriculum")
	public String adminCurriculum(HttpServletRequest request) {
		//��ѧ���б���ӵ���ͼ��
		termList = getTermUtils.getAllTerms();
		request.setAttribute("termList", termList);
		//��ת������Ա�鿴�γ̱�ҳ��
		return "admin/admin_curriculum";
	}
	
	@RequestMapping(value="/adminSearchCurriculum")
	public String adminSearchCurriculum(HttpServletRequest request,Integer termid,Integer inputId) {
		//��ѧ���б���ӵ���ͼ��
		termList = getTermUtils.getAllTerms();
		request.setAttribute("termList", termList);
		// ���ѧ�ڵ�����
		String termName = checkNameUtils.searchByTermid(termid);
		request.setAttribute("termName", termName);
		request.setAttribute("classesid", inputId);
		List<Curriculum> resultList = serviceAdmin.searchCurriculumByClassesidAndTermid(inputId, termid);
		request.setAttribute("resultList", resultList);
		//��ת������Ա�鿴�γ̱�ҳ��
		return "admin/admin_curriculum";
	}
}
