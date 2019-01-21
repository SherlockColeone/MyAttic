package com.cn.web.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.BeanStuscore;
import com.cn.bean.Curriculum;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Term;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;
import com.cn.utils.CheckNameUtils;
import com.cn.utils.GetTermUtils;

/**
 * 	����ѧ���ɼ�������ʦ���Ŀ�����
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
	@RequestMapping(value = "/teacherStuscore")
	public String teacherStuscore(HttpServletRequest request) {
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
		return "teacher/teacher_modifystuscore";
	}
	
	/**
	 * 	��ʾ��ѡ��γ̵�����ѧ���ɼ�
	 * 
	 * @param request ����
	 * @return ��ת����ʦ�ɼ�����ҳ��
	 */
	@RequestMapping(value = "/teacherSelectStuscore/{id}/{coursesid}")
	public String teacherSelectStuscore(HttpServletRequest request,@PathVariable("id")Integer id,
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
		// ��ת����ʦѧ���ɼ�����ҳ��
		return "redirect:/teacherStuscore";
	}

	/**
	 * 	����ѡ���������ѯ���γ̰���
	 * 
	 * @param request    ����
	 * @param termId     �ӱ���ȡ��ѧ��id
	 * @return ��ת����ʦ�ɼ���ѯҳ��
	 */
	@RequestMapping(value = "/teacherModifyStuscore")
	public String teacherModifyStuscore(HttpServletRequest request, Integer termId) {
		
		// ���ѧ�ڵ�����
		String term = checkNameUtils.searchByTermid(termId);
		request.setAttribute("term", term);
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//��ѯ��ѧ�ڵ����гɼ�
//		List<Stuscore> resultList = serviceStudent.searchAllStuScoreByStudentidAndTermid(teacher.getId(), termId);
//		//�ѽ���б���ӵ���ͼ��
//		request.setAttribute("resultList",resultList);
		return "teacher/teacher_stuscore";
	}
}
