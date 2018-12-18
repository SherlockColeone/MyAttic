package com.yueqian.service;

import java.sql.SQLException;

import com.shop.domain.Order;
import com.yueqian.dao.OrderDao;

public class OrderService {

	OrderDao dao = new OrderDao();
	public void submitOrder(Order order) throws SQLException {		
		// 提交订单信息
		dao.addOrder(order);
		// 提交订单项信息
		dao.addOrderItem(order);		
	}

}
