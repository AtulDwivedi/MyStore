package com.mystore.dao.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mystore.dao.service.OrderDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.model.Customer;
import com.mystore.model.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO STR_ORDER VALUES(?,?,?,?,?,?)")) {
			
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getCustomerId());
			ps.setString(3, order.getOrderDate());
			ps.setString(4, order.getRequiredDate());
			ps.setString(5, order.getDispatchDate());
			ps.setString(6, order.getStatus());
			
			
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	
	}
	@Override
	public int updateOrder(Order order) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE STR_ORDER SET CUSTOMERID=?, ORDERDATE=?, REQUIREDDATE=?, DISPATCHDATE=?, STATUS=? WHERE ORDERID=?")) {
			
			ps.setString(1, order.getCustomerId());
			ps.setString(2, order.getOrderDate());
			ps.setString(3, order.getRequiredDate());
			ps.setString(4, order.getDispatchDate());
			ps.setString(5, order.getStatus());
			ps.setString(6, order.getOrderId());
			

			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public int deleteOrder(String orderId) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM STR_ORDER WHERE ORDERID = ?")) {
			ps.setString(1, orderId);
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		Order ord = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_ORDER WHERE ORDERID = ?")) {
			ps.setString(1, orderId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(ord == null){
					ord = new Order();
				}
				ord.setOrderId(rs.getString(1));
				ord.setCustomerId(rs.getString(2));
				ord.setOrderDate(rs.getString(3));
				ord.setRequiredDate(rs.getString(4));
				ord.setDispatchDate(rs.getString(5));
				ord.setStatus(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ord;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_ORDER")) {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Order ord = new Order();
				ord.setOrderId(rs.getString(1));
				ord.setCustomerId(rs.getString(2));
				ord.setOrderDate(rs.getString(3));
				ord.setRequiredDate(rs.getString(4));
				ord.setDispatchDate(rs.getString(5));
				ord.setStatus(rs.getString(6));
				orders.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}


}
