package com.shop.admin;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shop.domain.Product;

public class MangerProductListDao {
	private SessionFactory sessionFactory;
	
	public List<Product> getProductList() {
		//获取session
		Session session = sessionFactory.openSession();
		String sql = "from com.shop.domain.Product";
		//查询
		Query query = session.createQuery(sql);
		List<Product> list = query.list();
		System.out.println(list);
		System.out.println(list.size());
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
