package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Curriculum;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceTeacher;
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
	private ServiceTeacher serviceTeacher;
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
		//���ѧ�ڵ�����
		String term = "2018-09-2019-01";
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("admin");
		List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(), teacher.getId());
		request.setAttribute("resultList", resultList);
		//��ת����ʦ�γ̱�ҳ��
		return "admin/admin_curriculum";
	}
	
	/**
	 * ��ȡ�ý�ʦĳ��ѧ�ڵĿγ̱�
	 * @param request ����
	 * @return ��ת����ʦ�γ̱�ҳ��
	 */
	@RequestMapping(value="/adminSearchCurriculum")
	public String adminSearchCurriculum(HttpServletRequest request,Integer termId) {
		//��ѧ���б���ӵ���ͼ��
		termList = getTermUtils.getAllTerms();
		request.setAttribute("termList", termList);
		// ���ѧ�ڵ�����
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(termId, teacher.getId());
		request.setAttribute("resultList", resultList);
		//��ת����ʦ�γ̱�ҳ��
		return "admin/admin_curriculum";
	}
}
