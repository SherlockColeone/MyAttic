package com.yueqian.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.Product;

public class ProductDao extends HibernateDaoSupport{
	
	public List<Product> findProductList() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				// 编写hql
				String hql = "from com.shop.domain.Product";
				Query query = session.createQuery(hql);
				List<Product> list = query.list();
				return list;
			}
		});
	}

	/**
	 * 获取商品的总记录数
	 * @return 总记录数
	 */
	public long getTotalCount() {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT COUNT(*) from Product";
				Query query = session.createQuery(sql);
						
//				query.addEntity(Product.class);
				return (Long) query.uniqueResult();
			}
		});
	}

	public List<Product> getProductListByLimit(int index, int currentTootal) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {				
				String sql = "from Product";
				Query query = session.createQuery(sql);
				query.setFirstResult(index);
				query.setMaxResults(currentTootal);
//				query.setParameter(0, index);
//				query.setParameter(1, currentTootal);
				List<Product> productList = query.list();
				return productList;
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
