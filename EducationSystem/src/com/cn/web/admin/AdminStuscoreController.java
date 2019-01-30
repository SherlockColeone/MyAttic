package com.cn.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanStuscore;
import com.cn.bean.Curriculum;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;
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
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;

	//������ʾ�ý�ʦ��ѧ�ڵ����пγ�
	private List<Curriculum> list = new ArrayList<>();
	//������ʾ��רҵ��������ѧ���ɼ�
	private List<BeanStuscore> resultList = new ArrayList<>();
	//������ʾ��ѡ��Ŀγ�
	private String curriculum = "";

	/**
	 * 	��ʾ�ý�ʦĿǰѧ�ڵ����пγ�
	 * 
	 * @param request ����
	 * @return ��ת����ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/adminStuscore")
	public String adminStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//���Ҹý�ʦ��ѧ�ڵ����пγ�
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		// ��ת����ʦѧ���ɼ�����ҳ��
		return "admin/admin_modifystuscore";
	}

	/**
	 * 	��ת����ʦ��ѯ�ɼ���ҳ��
	 * 
	 * @param request ����
	 * @return ��ת����ʦ��ѯ�ɼ�ҳ��
	 */
	@RequestMapping(value = "/adminCheckStuscore")
	public String adminCheckStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//���Ҹý�ʦ��ѧ�ڵ����пγ�
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		// ��ת����ʦ��ѯ�ɼ�ҳ��
		return "admin/admin_checkstuscore";
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
		if (coursesid!=0) { //ѡ�����רҵ��
			curriculum = checkNameUtils.searchByCoursesId(id);
			//����רҵ��id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { //ѡ�����ѡ�޿�
			curriculum = checkNameUtils.searchByElectiveId(id);
			//����ѡ�޿�id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//�ض��򵽽�ʦѧ���ɼ�����ҳ��
		return "redirect:/adminStuscore";
	}
	

	
	/**
	 * 	��ʾ��ѡ��γ̵�����ѧ���ɼ�
	 * 
	 * @param request ����
	 * @return �ض��򵽽�ʦ��ѯ�ɼ�ҳ��
	 */
	@RequestMapping(value = "/adminCheckSelectStuscore/{id}/{coursesid}")
	public String adminCheckSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
			@PathVariable("coursesid")Integer coursesid) {
		if (coursesid!=0) { //ѡ�����רҵ��
			curriculum = checkNameUtils.searchByCoursesId(id);
			//����רҵ��id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { //ѡ�����ѡ�޿�
			curriculum = checkNameUtils.searchByElectiveId(id);
			//����ѡ�޿�id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//�ض��򵽽�ʦѧ����ѯ�ɼ�ҳ��
		return "redirect:/adminCheckStuscore";
	}
}
