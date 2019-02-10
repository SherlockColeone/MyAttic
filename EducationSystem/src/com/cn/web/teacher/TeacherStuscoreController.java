package com.cn.web.teacher;

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
 * ����ѧ���ɼ�������ʦ���Ŀ�����
 * 
 * @author Sherlock
 *
 */

@Controller
public class TeacherStuscoreController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	@Autowired
	private CheckNameUtils checkNameUtils;

	// ������ʾ�ý�ʦ��ѧ�ڵ����пγ�
	private List<Curriculum> list = new ArrayList<>();
	// ������ʾ��רҵ��������ѧ���ɼ�
	private List<BeanStuscore> resultList = new ArrayList<>();
	// ������ʾ��ѡ��Ŀγ�
	private String curriculum = "";
	//������ʾ�γ̱��
	private int curriculumId = 0;
	//������ʾ�γ�����
	private int type = 2;

	/**
	 * ��ʾ�ý�ʦĿǰѧ�ڵ����пγ�
	 * 
	 * @param request ����
	 * @return ��ת����ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// ��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		// ���Ҹý�ʦ��ѧ�ڵ����пγ�
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		request.setAttribute("curriculumId", curriculumId);
		request.setAttribute("type", type);
		//���������������Ϊ��ʼֵ�������������������Ѵ����ֵ
		list = new ArrayList<>();
		resultList = new ArrayList<>();
		curriculum = "";
		curriculumId = 0;
		type = 2;
		// ��ת����ʦѧ���ɼ�����ҳ��
		return "teacher/teacher_modifystuscore";
	}

	/**
	 * ��ʾ��ѡ��γ̵�����ѧ���ɼ�
	 * 
	 * @param request ����
	 * @return �ض��򵽽�ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/teacherSelectStuscore/{id}/{coursesid}")
	public String teacherSelectStuscore(HttpServletRequest request, @PathVariable("id") Integer id,
			@PathVariable("coursesid") Integer coursesid) {
		if (coursesid != 0) { // ѡ�����רҵ��
			curriculum = checkNameUtils.searchByCoursesId(id);
			// ����רҵ��id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
			// ����רҵ�α�ǣ�0Ϊרҵ��
			type = 0;
		} else { // ѡ�����ѡ�޿�
			curriculum = checkNameUtils.searchByElectiveId(id);
			// ����ѡ�޿�id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
			// ����ѡ�޿α�ǣ�1Ϊѡ�޿�
			type = 1;
		}
		// ���ÿγ�����
		request.setAttribute("curriculum", curriculum);
		// ���ÿγ�id
		curriculumId = id;
		// �ض��򵽽�ʦѧ���ɼ�����ҳ�棨���ڸ÷�����url�Ѹı䣬��������ת��
		return "redirect:/teacherStuscore";
	}

	/**
	 * ��ӻ��޸ĸÿγ̵�ѧ���ɼ�
	 * 
	 * @param request      ����
	 * @param curriculumId �γ�id��רҵ��id��ѡ�޿�id��
	 * @param type         �γ����ͣ�0Ϊרҵ�Σ�1Ϊѡ�޿�
	 * @param result       ѧ�ż��ϳɼ����ַ���
	 * @return ��ת����ʦ�ɼ���ѯҳ��
	 */
	@RequestMapping(value = "/teacherModifyStuscore")
	public String teacherModifyStuscore(HttpServletRequest request, Integer type, Integer curriculumId, 
			String result) {
		if (type==0) { //רҵ��
			//�ϴ�רҵ�γɼ�
			serviceTeacher.modifyStuScoreByCoursesidAndResult(curriculumId, result);
		} else if(type==1) { //ѡ�޿�
			//�ϴ�ѡ�޿γɼ�
			serviceTeacher.modifyStuScoreByElectiveidAndResult(curriculumId, result);
		}		
		return "redirect:/teacherCheckStuscore";
	}

	/**
	 * ��ת����ʦ��ѯ�ɼ���ҳ��
	 * 
	 * @param request ����
	 * @return ��ת����ʦ��ѯ�ɼ�ҳ��
	 */
	@RequestMapping(value = "/teacherCheckStuscore")
	public String teacherCheckStuscore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// ��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		// ���Ҹý�ʦ��ѧ�ڵ����пγ�
		list = serviceTeacher.searchAllCurriculumByTermidAndTeacherid(GetTermUtils.getCurrentTermiId(),
				teacher.getId());
		request.setAttribute("curriculum", curriculum);
		request.setAttribute("list", list);
		request.setAttribute("resultList", resultList);
		//����������������Ϊ��ʼֵ�������������������Ѵ����ֵ
		list = new ArrayList<>();
		resultList = new ArrayList<>();
		curriculum = "";
		// ��ת����ʦ��ѯ�ɼ�ҳ��
		return "teacher/teacher_checkstuscore";
	}

	/**
	 * ��ʾ��ѡ��γ̵�����ѧ���ɼ�
	 * 
	 * @param request ����
	 * @return �ض��򵽽�ʦ��ѯ�ɼ�ҳ��
	 */
	@RequestMapping(value = "/teacherCheckSelectStuscore/{id}/{coursesid}")
	public String teacherCheckSelectStuscore(HttpServletRequest request, @PathVariable("id") Integer id,
			@PathVariable("coursesid") Integer coursesid) {
		if (coursesid != 0) { // ѡ�����רҵ��
			curriculum = checkNameUtils.searchByCoursesId(id);
			// ����רҵ��id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByCoursesid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		} else { // ѡ�����ѡ�޿�
			curriculum = checkNameUtils.searchByElectiveId(id);
			// ����ѡ�޿�id��������ѧ���ɼ�
			List<Stuscore> listStuscore = serviceTeacher.searchAllStuScoreByElectiveid(id);
			resultList = serviceTeacher.changeStuscoreListIntoBeanStuscoreList(listStuscore);
		}
		// �ض��򵽽�ʦѧ����ѯ�ɼ�ҳ�棨���ڸ÷�����url�Ѹı䣬��������ת��
		return "redirect:/teacherCheckStuscore";
	}
}
