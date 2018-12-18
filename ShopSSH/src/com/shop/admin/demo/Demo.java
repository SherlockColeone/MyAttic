package com.shop.admin.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.admin.MangerProductListDao;
import com.shop.domain.Category;
import com.shop.domain.Product;
import com.yueqian.dao.CategoryDao;
import com.yueqian.dao.ProductDao;
import com.yueqian.service.CategoryService;

public class Demo {
	@Test
	public void demo1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MangerProductListDao mangerProductListDao = (MangerProductListDao) ac.getBean("MangerProductListDao");
		List<Product> productList = mangerProductListDao.getProductList();
		for (Product product : productList) {
			System.out.println(product);
		}
	}
	
	@Test
	public void demo2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "from com.shop.domain.Product";
		//查询
		Query query = session.createQuery(sql);	
		List<Product> list = query.list();
		tx.commit();
		System.out.println(list.size());
		for (Product product : list) {
			System.out.println(product);
		}
	}
	
	@Test
	public void demo3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao) ac.getBean("ProductDao");
		List<Product> list = productDao.findProductList();
		for (Product product : list) {
			System.out.println(product);
		}
	}
	
	@Test
	public void demo4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao) ac.getBean("ProductDao");
		Product vo = new Product();
		vo.setPid("100");
		productDao.doProduct(vo);
	}
	
	@Test
	public void demo5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao) ac.getBean("ProductDao");
		Product product = productDao.findProductBypid("10");
		System.out.println(product);
	}
	
	@Test
	public void demo6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService categoryService = (CategoryService) ac.getBean("CategoryService");
		Category vo = new Category();
		vo.setCname("书籍");
		categoryService.addCategory(vo);
	}
	
	@Test
	public void demo7() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CategoryService categoryService = (CategoryService) ac.getBean("CategoryService");
		CategoryDao categoryDao = (CategoryDao) ac.getBean("CategoryDao");
		Category vo = new Category();
		vo.setCname("书籍");
		categoryDao.doCategory(vo);
	}
}
