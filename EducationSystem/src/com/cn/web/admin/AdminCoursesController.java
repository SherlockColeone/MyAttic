package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	����Ա�γ̰��ŵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCoursesController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	@RequestMapping(value="/adminCourses")
	public String adminCourses(HttpServletRequest request) {
		//��ת������鿴�γ̰���ҳ��
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCoursesModify")
	public String adminCoursesModify(HttpServletRequest request) {
		//��ת������Ա�γ̰��Ź���ҳ��
		return "admin/admin_coursesmodify";
	}
	
	//�жϿγ̱���Ƿ���Ҫ������
	private Integer checkId(Courses courses) {
		if (courses.getId()==0) {
			return null;
		} else {
			return courses.getId();
		}		
	}
	
	@RequestMapping(value="/adminInsertCourses")
	public String adminInsertCourses(HttpServletRequest request,Courses courses) {
		//���ñ��
		courses.setId(checkId(courses));
		//��ӿγ�
		serviceAdmin.addCourses(courses);
		//��ת������Ա�γ̰���
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminDeleteCourses")
	public String adminDeleteCourses(HttpServletRequest request,Courses courses) {
		//ɾ���γ�
		serviceAdmin.delCoursesByCoursesid(courses.getId());
		//��ת������Ա�γ̰���
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminModifyCourses")
	public String adminModifyCourses(HttpServletRequest request,Courses courses) {
		//���ñ��
		courses.setId(checkId(courses));
		//�޸Ŀγ�
		serviceAdmin.modifyCourses(courses);		
		//��ת������Ա�γ̰���
		return "admin/admin_coursesmodify";
	}
	
	@RequestMapping(value="/adminCheckCoursesForCourses")
	public String adminCheckCoursesForCourses(HttpServletRequest request,Integer inputId) {
		Courses courses = serviceAdmin.searchCoursesByCoursesid(inputId);
		//�������Ŀγ̷ŵ���ͼ��
		request.setAttribute("courses",courses);
		//��ȡѧ������
		String termName = checkNameUtils.searchByTermid(courses.getTermid());
		request.setAttribute("termName",termName);
		//��ת������Ա�鿴�γ̰���
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCheckCoursesForCoursesModify")
	public String adminCheckCoursesForCoursesModify(HttpServletRequest request,Integer inputId,Integer operate) {
		//�����Ҫ���еĲ���
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Courses courses = new Courses();
		if (operate!=1) { //���е���ɾ�����޸Ĳ���
			courses = serviceAdmin.searchCoursesByCoursesid(inputId);
		}		
		//�������Ŀγ̷ŵ���ͼ��
		request.setAttribute("courses",courses);
		//��ȡ����ѧ��
		List<Term> termList = getTermUtils.getAllTerms();
		request.setAttribute("termList",termList);
		//��ȡ��ǰ��ѧ��id
		Integer currentTermiId = GetTermUtils.getCurrentTermiId();
		request.setAttribute("currentTermiId",currentTermiId);
		//��ת������Ա�γ̰��Ź���
		return "admin/admin_coursesmodify";
	}

}
