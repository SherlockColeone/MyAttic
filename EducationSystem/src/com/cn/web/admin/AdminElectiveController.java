package com.cn.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.bean.BeanElective;
import com.cn.bean.Elective;
import com.cn.bean.Term;
import com.cn.service.ServiceAdmin;
import com.cn.utils.GetTermUtils;

/**
 * 	����Աѡ�ι���Ŀ�����
 * @author Sherlock
 *
 */
@Controller
public class AdminElectiveController {
	@Autowired
	private ServiceAdmin serviceAdmin;
	@Autowired
	private GetTermUtils getTermUtils;
	
	
	@RequestMapping(value="/adminElective")
	public String adminElective(HttpServletRequest request) {
		//��ʾ��ѧ�����е�ѡ�ν��
		List<BeanElective> list = serviceAdmin.showBeanElectiveList();
		request.setAttribute("list",list);
		//��ת���鿴ѧ��ѡ�ν��ҳ��
		return "admin/admin_elective";
	}
	
	@RequestMapping(value="/adminElectiveModify")
	public String adminElectiveModify(HttpServletRequest request) {
		//��ת��ѡ�ι���ҳ��
		return "admin/admin_electivemodify";
	}
	
	@RequestMapping(value="/adminCheckElective")
	public String adminCheckElective(HttpServletRequest request,Integer inputId,Integer operate) {
		//�����Ҫ���еĲ���
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Elective elective = new Elective();
		if (operate!=1) { //���е���ɾ�����޸Ĳ���
			elective = serviceAdmin.searchElectiveByElectiveid(inputId);
		}		
		//��������ѡ�޿ηŵ���ͼ��
		request.setAttribute("elective",elective);
		//��ȡ����ѧ��
		List<Term> termList = getTermUtils.getAllTerms();
		request.setAttribute("termList",termList);
		//��ȡ��ǰ��ѧ��id
		Integer currentTermiId = GetTermUtils.getCurrentTermiId();
		request.setAttribute("currentTermiId",currentTermiId);
		//��ת��ѡ�ι���ҳ��
		return "admin/admin_electivemodify";
	}
	
	//�ж�ѡ�޿α���Ƿ���Ҫ������
	private Integer checkId(Elective elective) {
		if (elective.getId()==0) {
			return null;
		} else {
			return elective.getId();
		}		
	}
	
	@RequestMapping(value="/adminInsertElective")
	public String adminInsertElective(HttpServletRequest request,Elective elective) {
		//���ñ��
		elective.setId(checkId(elective));
		//��ӿγ�
		serviceAdmin.addElective(elective);
		//��ת������Ա�γ̰���
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminDeleteElective")
	public String adminDeleteElective(HttpServletRequest request,Elective elective) {
		//ɾ���γ�
		serviceAdmin.delElectiveByElectiveid(elective.getId());
		//��ת������Ա�γ̰���
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminModifyElective")
	public String adminModifyElective(HttpServletRequest request,Elective elective) {
		//���ñ��
		elective.setId(checkId(elective));
		//�޸Ŀγ�
		serviceAdmin.modifyElective(elective);		
		//��ת������Ա�γ̰���
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminAddElective")
	public String adminAddElective(HttpServletRequest request,String result) {
		//��������������ַ�������ָ�ɶ��ѡ�޿α��
		List<Integer> idList = serviceAdmin.splitResults(result);
		//�������
		serviceAdmin.addStuscoreByElectiveidList(idList);
		//��ת���鿴ѧ��ѡ�ν��ҳ��
		return "redirect:adminElective";
	}	
}
