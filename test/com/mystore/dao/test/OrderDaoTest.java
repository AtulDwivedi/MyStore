package com.mystore.dao.test;

//import java.sql.Date;
//import java.util.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mystore.model.Order;
import com.mystore.dao.service.impl.OrderDaoImpl;


public class OrderDaoTest {
	public static void main(String[] args)throws ParseException {
		
/*		order.setOrderId("1001");
		order.setOrderDate("");
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		System.out.println(date);*/
		
		
		Order ord = new Order();
		OrderDaoImpl order = new OrderDaoImpl();
		ord.setOrderId("O2");
		ord.setCustomerId("C2");
		
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Date orderDate=format.parse("03/05/2017");
		Date requiedDate=format.parse("05/05/2017");
		Date dispatchDate=format.parse("04/05/2017");
		java.sql.Date sqlOrderDate=new java.sql.Date(orderDate.getTime());
		java.sql.Date sqlRequiedDate=new java.sql.Date(requiedDate.getTime());
		java.sql.Date sqlDispatchDate=new java.sql.Date(dispatchDate.getTime());
		ord.setOrderDate(sqlOrderDate.toString());
		ord.setRequiredDate(sqlRequiedDate.toString());
		ord.setDispatchDate(sqlDispatchDate.toString());
		ord.setStatus("Dispatched");
		
		int rowsAffected = order.saveOrder(ord);
		System.out.println(rowsAffected + "row(s) inserted into STR_ORDER");
		//System.out.println(order.updateOrder(ord) + "row(s) updated successfully");
		//System.out.println(order.deleteOrder("O2") + "row(s) deleted successfully");

	}
}
