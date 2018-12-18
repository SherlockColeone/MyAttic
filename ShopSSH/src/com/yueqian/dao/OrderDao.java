package com.yueqian.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.shop.domain.Order;
import com.shop.domain.OrderItem;

public class OrderDao extends HibernateDaoSupport{

	/**
	 * 插入订单信息
	 * @param vo
	 */
	public void addOrder(Order vo) {
		getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(vo);
				return null;
			}
		});
	}
	
	/**
	 * 插入订单项信息
	 * @param vo
	 */
	public void addOrderItem(Order vo) {
		getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				List<OrderItem> orderItems = vo.getOrderItems();
				for (OrderItem orderItem : orderItems) {
					session.save(orderItem);
				}
				return null;
			}
		});
	}  
}
