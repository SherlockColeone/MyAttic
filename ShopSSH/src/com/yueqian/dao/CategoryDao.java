package com.yueqian.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.Category;

/**
 * 商品分类的数据层类
 * @author Sherlock
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 * 查询所有商品分类
	 * @return 商品分类集合
	 */
	public List<Category> findAllCategory() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Category>>() {

			@Override
			public List<Category> doInHibernate(Session session) throws HibernateException {
				// 编写sql
				String sql = "SELECT * from category";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Category.class);
				List<Category> list = query.list();
				return list;
			}
		});
	}
	
	public Category findCategoryByid(int id) {
		return getHibernateTemplate().execute(new HibernateCallback<Category>() {

			@Override
			public Category doInHibernate(Session session) throws HibernateException {
				// 编写sql
				String sql = "SELECT * from category where cid=?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setParameter(0, id);
				query.addEntity(Category.class);
				return (Category) query.uniqueResult();
			}
		});
	}
	
	public int doCategory(Category vo) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Integer i = (Integer) session.save(vo);
				return i;
			}
			
		});
	}
	
	public int delCategory(int id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				session.delete(id);
				return 1;
			}
			
		});
	}
	
	public int updateCategory(Category vo) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				session.update(vo);
				return 1;
			}
			
		});
	}

}
