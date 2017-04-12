package com.mystore.dao.service;

import java.util.List;

import com.mystore.model.OrderDetail;

public interface OrderDetailDao {
	
	int saveOrderDetail(OrderDetail orderDetail);
	int updateOrderDetail(OrderDetail orderDetail);
	int deleteOrderDetail(String orderDetailId);
	
	OrderDetail getOrderDetailByOrderDetailId(String orderDetailId);
	List<OrderDetail> getOrderDetailsByOrderId(String orderId);
	
	int saveOrderDetails(List<OrderDetail> orderDetails);
	int deleteOrderDetailsByOrderId(String orderId);
}
