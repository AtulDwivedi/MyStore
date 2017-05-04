package com.mystore.dao.service;

import java.util.List;

import com.mystore.model.Order;

public interface OrderDao {

	int saveOrder(Order order);
	int updateOrder(Order order);
	int deleteOrder(String orderId);
	
	Order getOrderByOrderId(String orderId);
	List<Order> getOrders();
}
