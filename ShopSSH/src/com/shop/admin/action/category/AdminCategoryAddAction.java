package com.shop.admin.action.category;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Category;
import com.yueqian.service.CategoryService;

public class AdminCategoryAddAction extends ActionSupport implements ModelDriven<Category>{
	private Category category;
	private CategoryService categoryService;

	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryService = (CategoryService) ac.getBean("CategoryService");
		//ModelDriven已经获取了category对象，直接传到逻辑层即可
		System.out.println(category);
		categoryService.addCategory(category);
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
