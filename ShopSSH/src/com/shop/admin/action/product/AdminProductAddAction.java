package com.shop.admin.action.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.shop.domain.Category;
import com.yueqian.service.CategoryService;

public class AdminProductAddAction implements Action{
	private CategoryService categoryService;

	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (CategoryService) ac.getBean("CategoryService");
		//从逻辑层获取所有分类
		List<Category> categoryList = categoryService.findAllCategory();
		//设置属性
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("categoryList", categoryList);
		return SUCCESS;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
