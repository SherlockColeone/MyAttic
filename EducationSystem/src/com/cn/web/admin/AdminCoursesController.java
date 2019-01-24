package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Elective;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	��ʦ�γ̰��ŵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminCoursesController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;
	@Autowired
	private GetTermUtils getTermUtils;
	
	public List<Term> termList = new ArrayList<>();
	
	/**
	 * 	��ѧ�ڷ������ѧ��ѡ����
	 * @param request ����
	 * @return ��ת����ʦ�γ̰���ҳ��
	 */
	@RequestMapping(value="/adminCourses")
	public String adminCourses(HttpServletRequest request) {
		termList = getTermUtils.getAllTerms();
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//��ת����ʦ�γ̰���
		return "admin/admin_courses";
	}
	
	@RequestMapping(value="/adminCheckCourses")
	public String adminCheckCourses(HttpServletRequest request) {
		termList = getTermUtils.getAllTerms();
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//��ת����ʦ�γ̰���
		return "admin/admin_courses";
	}
	
	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * @param request ����
	 * @param termId �ӱ���ȡ��ѧ��id
	 * @param curriculum �ӱ���ȡ�Ŀγ����ʡ�0��ʾ�������ʣ�1��ʾרҵ�Σ�2��ʾѡ�޿�
	 * @return ��ת����ʦ�γ̰���ҳ��
	 */
	@RequestMapping(value="/adminSearchAllCourses")
	public String adminSearchAllCourses(HttpServletRequest request,Integer termId,Integer curriculum) {
		//��ѧ���б���ӵ���ͼ��
		request.setAttribute("termList",termList);
		//���ѧ�ڵ�����
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term",term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");		
		if(curriculum==0) { //���ʲ���
			//��ѯ��ѧ�ڵ����пγ�
			List<Curriculum> resultList = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(termId, teacher.getId());
			//�ѽ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","��������");
		} 
		else if(curriculum==1) { //רҵ��
			List<Courses> resultList = serviceTeacher.searchAllCoursesByTeacheridAndTermid(teacher.getId(), termId);
			//��רҵ���б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","רҵ��");
		}
		else if(curriculum==2) { //ѡ�޿�
			List<Curriculum> resultList = new ArrayList<>();
			List<Elective> list = serviceTeacher.searchAllElectiveByTeacheridAndTermid(teacher.getId(), termId);
			//����ѡ�޿�ȱ��ĳЩ�����޷���ҳ������ʾ�����ת�����ܿγ̶�����ʾ
			for (Elective elective : list) {
				Curriculum curr = new Curriculum(elective.getId(), elective.getName(), elective.getTeacher(), null,
						0, elective.getId());
				resultList.add(curr);
			}			
			//��ѡ�޿��б���ӵ���ͼ��
			request.setAttribute("resultList",resultList);
			request.setAttribute("nature","ѡ�޿�");
		}
		return "admin/admin_courses";
	}
}
