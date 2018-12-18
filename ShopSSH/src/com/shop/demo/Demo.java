package com.shop.demo;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.Product;
import com.shop.domain.User;
import com.yueqian.dao.ProductDao;
import com.yueqian.dao.UserDao;
import com.yueqian.service.IndexService;
import com.yueqian.service.ProductService;

public class Demo {
	@Test
	public void demo1() {
		UserDao userDao = new UserDao();
		User user = userDao.login("令狐冲", "linghu");
		System.out.println(user);
	}
	
	@Test
	public void demo2() {
		UserDao userDao = new UserDao();
		User vo = new User();
		vo.setUid("gerwqjhtqw134");
		vo.setName("桃谷六怪");
		System.out.println(userDao.addUser(vo));
	}
	
	@Test
	public void demo3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IndexService indexService = (IndexService) ac.getBean("IndexService");
		List<Product> hotProductList = indexService.getHotProductList();
		List<Product> newProductList = indexService.getNewProductList();
		System.out.println(hotProductList.size());
		for (Product product : newProductList) {
			System.out.println(product);
		}
		System.out.println(newProductList.size());
		for (Product product : newProductList) {
			System.out.println(product);
		}
	}
	
	@Test
	public void demo4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService productService = (ProductService) ac.getBean("ProductService");
//		productService.findPageBean(1, 12);
		ProductDao productDao = (ProductDao) ac.getBean("ProductDao");
		System.out.println(productDao.getTotalCount());
	}
	
}
