package com.yueqian.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.OrderItem;
import com.shop.domain.Product;

public class OrderItemDao extends HibernateDaoSupport{
	
	public List<OrderItem> findOrderItemList() {
		return getHibernateTemplate().execute(new HibernateCallback<List<OrderItem>>() {

			@Override
			public List<OrderItem> doInHibernate(Session session) throws HibernateException {
				String hql = "from Orderitem";
				Query query = session.createQuery(hql);
				List<OrderItem> list = query.list();
				return list;
			}
		});
	}
	
	public Product findProductBypid(String pid) {
		return getHibernateTemplate().execute(new HibernateCallback<Product>() {

			@Override
			public Product doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * from product WHERE pid = ?";
				SQLQuery query = session.createSQLQuery(sql);
				//设置占位符
				query.setParameter(0, pid);
				//转为product实体
				query.addEntity(Product.class);
				return (Product) query.uniqueResult();
			}
		});
	}
	
	/**
	 * 将新增产品添加到数据库中
	 * @param vo 新增产品对象
	 * @return 数据库更改的行数
	 */
	public int doProduct(Product vo) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Integer i = (Integer) session.save(vo);
				return i;
			}
		});
	}
	
	/**
	 * 修改商品信息
	 * @param vo 商品对象
	 * @return 修改的行数
	 */
	public int updateProduct(Product vo) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				session.update(vo);
				return 1;
			}
		});
	}
	
	/**
	 * 根据商品id删除商品
	 * @param pid 商品id
	 * @return 修改的行数
	 */
	public int delProduct(String pid) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				session.delete(pid);
				return 1;
			}
		});
	}
}
