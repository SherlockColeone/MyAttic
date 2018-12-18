package com.yueqian.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.Product;

public class IndexDao extends HibernateDaoSupport{

	public List<Product> getHotProductList() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * from product WHERE is_hot = ? LIMIT ?,?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0, 1);
				query.setParameter(1, 0);
				query.setParameter(2, 9);
				query.addEntity(Product.class);
				List<Product> list = query.list();
				return list;
			}
		});
	}

	public List<Product> getNewProductList() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * from product ORDER BY pdate DESC LIMIT ?,?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0, 0);
				query.setParameter(1,9);
				query.addEntity(Product.class);
				List<Product> list = query.list();
				return list;
			}
		});
	}

}
