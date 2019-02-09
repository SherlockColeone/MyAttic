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
 * 	管理员选课管理的控制器
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
		//显示本学期所有的选课结果
		List<BeanElective> list = serviceAdmin.showBeanElectiveList();
		request.setAttribute("list",list);
		//跳转到查看学生选课结果页面
		return "admin/admin_elective";
	}
	
	@RequestMapping(value="/adminElectiveModify")
	public String adminElectiveModify(HttpServletRequest request) {
		//跳转到选课管理页面
		return "admin/admin_electivemodify";
	}
	
	@RequestMapping(value="/adminCheckElective")
	public String adminCheckElective(HttpServletRequest request,Integer inputId,Integer operate) {
		//标记需要进行的操作
		Integer manageResult = operate;
		request.setAttribute("manageResult",manageResult);
		Elective elective = new Elective();
		if (operate!=1) { //进行的是删除或修改操作
			elective = serviceAdmin.searchElectiveByElectiveid(inputId);
		}		
		//把搜索的选修课放到视图中
		request.setAttribute("elective",elective);
		//获取所有学期
		List<Term> termList = getTermUtils.getAllTerms();
		request.setAttribute("termList",termList);
		//获取当前的学期id
		Integer currentTermiId = GetTermUtils.getCurrentTermiId();
		request.setAttribute("currentTermiId",currentTermiId);
		//跳转到选课管理页面
		return "admin/admin_electivemodify";
	}
	
	//判断选修课编号是否需要随机编号
	private Integer checkId(Elective elective) {
		if (elective.getId()==0) {
			return null;
		} else {
			return elective.getId();
		}		
	}
	
	@RequestMapping(value="/adminInsertElective")
	public String adminInsertElective(HttpServletRequest request,Elective elective) {
		//设置编号
		elective.setId(checkId(elective));
		//添加课程
		serviceAdmin.addElective(elective);
		//跳转到管理员课程安排
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminDeleteElective")
	public String adminDeleteElective(HttpServletRequest request,Elective elective) {
		//删除课程
		serviceAdmin.delElectiveByElectiveid(elective.getId());
		//跳转到管理员课程安排
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminModifyElective")
	public String adminModifyElective(HttpServletRequest request,Elective elective) {
		//设置编号
		elective.setId(checkId(elective));
		//修改课程
		serviceAdmin.modifyElective(elective);		
		//跳转到管理员课程安排
		return "redirect:adminElectiveModify";
	}
	
	@RequestMapping(value="/adminAddElective")
	public String adminAddElective(HttpServletRequest request,String result) {
		//将表单传输过来的字符串结果分割成多个选修课编号
		List<Integer> idList = serviceAdmin.splitResults(result);
		//进行添加
		serviceAdmin.addStuscoreByElectiveidList(idList);
		//跳转到查看学生选课结果页面
		return "redirect:adminElective";
	}	
}
