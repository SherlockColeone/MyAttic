package com.shop.admin.action.category;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Category;
import com.yueqian.service.CategoryService;

public class AdminCategoryEditAction extends ActionSupport implements ModelDriven<Category>{
	private Category category;
	private CategoryService categoryService;

	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (CategoryService) ac.getBean("CategoryService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String cid = request.getParameter("cid");
		category = categoryService.findCategoryById(new Integer(cid));
		request.setAttribute("category", category);
		return SUCCESS;
	}

	@Override
	public Category getModel() {
		return category;
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
