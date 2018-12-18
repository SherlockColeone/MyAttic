package com.yueqian.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.Category;
import com.yueqian.dao.CategoryDao;

/**
 * 商品分类的逻辑层类
 * 
 * @author Sherlock
 *
 */
public class CategoryService {
	private CategoryDao categoryDao;

	/**
	 * 查询所有商品分类
	 * @return 商品分类集合
	 */
	public List<Category> findAllCategory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		return categoryDao.findAllCategory();
	}
	
	public Category findCategoryById(int id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		return categoryDao.findCategoryByid(id);
	}
	
	public boolean addCategory(Category vo) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		categoryDao.doCategory(vo);
		return true;
	}
	
	public boolean deleteCategory(int id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		categoryDao.delCategory(id);
		return true;
	}
	
	public boolean modifyCategory(Category vo) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		categoryDao.updateCategory(vo);
		return true;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
}
