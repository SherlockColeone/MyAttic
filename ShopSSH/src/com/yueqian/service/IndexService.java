package com.yueqian.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.Product;
import com.yueqian.dao.IndexDao;

public class IndexService {
	private IndexDao indexDao;
	
	public List<Product> getHotProductList() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		indexDao = (IndexDao) ac.getBean("IndexDao");
		return indexDao.getHotProductList();
	}
	public List<Product> getNewProductList() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		indexDao = (IndexDao) ac.getBean("IndexDao");
		return indexDao.getNewProductList();
	}
	
	public IndexDao getIndexDao() {
		return indexDao;
	}
	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
      
}
