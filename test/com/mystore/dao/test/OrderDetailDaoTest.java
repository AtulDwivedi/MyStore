package com.mystore.dao.test;

import com.mystore.dao.service.impl.OrderDetailDaoImpl;
import com.mystore.model.OrderDetail;

public class OrderDetailDaoTest {

	public static void main(String[] args) {
		
		saveOrderDetail();
		//updateOrderDetail();
		//deleteOrderDetail();
		
	}

	 public static void saveOrderDetail(){
		System.out.println(">> saveOrderDetail");
		OrderDetail ordd = new OrderDetail();
		OrderDetailDaoImpl orderdetail = new OrderDetailDaoImpl();
		ordd.setOrderDetailId("OD2");
		ordd.setOrderId("O2");
		ordd.setProductId("P2");
		ordd.setUnitPrice(39000);
		ordd.setOrderLineNumber(1);
		ordd.setQuantity(1);
		ordd.setDiscount(10);
		
		int rowsAffected = orderdetail.saveOrderDetail(ordd);
		System.out.println(rowsAffected + "row(s) inserted into STR_ORDERDETAIL");
		System.out.println("<< saveOrderDetail");
	}
	
	public static void updateOrderDetail(){
		System.out.println(">> updateOrderDetail");
		OrderDetail ordd = new OrderDetail();
		OrderDetailDaoImpl orderdetail = new OrderDetailDaoImpl();
		ordd.setOrderDetailId("OD2");
		ordd.setOrderId("O2");
		ordd.setProductId("P2");
		ordd.setUnitPrice(39000);
		ordd.setOrderLineNumber(1);
		ordd.setQuantity(1);
		ordd.setDiscount(10);
		
		System.out.println(orderdetail.updateOrderDetail(ordd) + "row(s) updated successfully");
		System.out.println("<< updateOrderDetail");
	}
	
	public static void deleteOrderDetail(){
		System.out.println(">> deleteOrderDetail");
		OrderDetailDaoImpl orderdetail = new OrderDetailDaoImpl();
		System.out.println(orderdetail.deleteOrderDetail("OD2") + "row(s) deleted successfully");
		System.out.println("<< deleteOrderDetail");
	}


}
