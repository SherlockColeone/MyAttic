package com.cn.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanArrange;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Teacher;
import com.cn.service.ServiceTeacher;

/**
 * 	�����ʦ����֪ͨ�Ŀ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherCurriculumarrangeController {
	@Autowired
	private ServiceTeacher serviceTeacher;
	
	@RequestMapping(value="/teacherCurriculumarrange")
	public String teacherCurriculumarrange(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//��ѯ�ý�ʦ��������׼�ĵ���
		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacheridPermitted(teacher.getId());
		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
		request.setAttribute("list", list);
		//��ѯ�ý�ʦ����δ��׼����׼�ĵ���
		List<Curriculumarrange> listCurr2 = serviceTeacher.searchAllCurriculumArrangeByTeacheridNotpermitAndPermitting(teacher.getId());
		List<BeanArrange> list2 = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr2);		
		request.setAttribute("list2", list2);
		//��ת���鿴����֪ͨҳ��
		return "teacher/teacher_curriculumarrange";
	}
	
	@RequestMapping(value="/teacherModifyCurriculumarrange")
	public String teacherModifyCurriculumarrange(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		//��session���л�ȡ��ʦ����
//		Teacher teacher = (Teacher) session.getAttribute("teacher");
//		//��ѯ�ý�ʦ���е���
//		List<Curriculumarrange> listCurr = serviceTeacher.searchAllCurriculumArrangeByTeacherid(teacher.getId());
//		List<BeanArrange> list = serviceTeacher.changeAllCurriculumarrangeIntoBeanArrange(listCurr);
//		request.setAttribute("list", list);
		//��ת���������ҳ��
		return "teacher/teacher_modifycurriculumarrange";
	}
	
	@RequestMapping(value="/teacherCurriculumarrangeSubmit")
	public String teacherCurriculumarrangeSubmit(HttpServletRequest request,Curriculumarrange arrange,
			Integer nature) {
		if (nature==0) {  //������Ϊרҵ��
			//��id��ֵ����רҵ��id
			arrange.setCoursesid(arrange.getId());
			//ѡ�޿�id����Ϊ0
			arrange.setElectiveid(0);
			//id����Ϊnull
			arrange.setId(null);
		} else {  //������Ϊѡ�޿�
			//��id��ֵ����ѡ�޿�id
			arrange.setElectiveid(arrange.getId());
			//רҵ��id����Ϊ0
			arrange.setCoursesid(0);
			//id����Ϊnull
			arrange.setId(null);
		}		
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//���ý�ʦ����
		arrange.setTeacherid(teacher.getId());
		//����Ϊ����Ϊδ��׼
		arrange.setPermit(0);
		//��ӵ���
		serviceTeacher.addCurriculumArrange(arrange);
		//��ת���������ҳ��
		return "redirect:teacherModifyCurriculumarrange";
	}
	
}
