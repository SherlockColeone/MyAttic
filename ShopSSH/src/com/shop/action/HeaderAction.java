package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.domain.Category;
import com.yueqian.service.CategoryService;

public class HeaderAction extends ActionSupport{
	private Category category;
	private CategoryService categoryService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (CategoryService) ac.getBean("CategoryService");
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
