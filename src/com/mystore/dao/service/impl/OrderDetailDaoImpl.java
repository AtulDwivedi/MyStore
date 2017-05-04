package com.mystore.dao.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mystore.dao.service.OrderDetailDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.model.Customer;
import com.mystore.model.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public int saveOrderDetail(OrderDetail orderDetail) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO STR_ORDERDETAIL VALUES(?,?,?,?,?,?,?)")) {
			
			ps.setString(1, orderDetail.getOrderDetailId());
			ps.setString(2, orderDetail.getOrderId());
			ps.setString(3, orderDetail.getProductId());
			ps.setDouble(4, orderDetail.getUnitPrice());
			ps.setInt(5, orderDetail.getOrderLineNumber());
			ps.setInt(6, orderDetail.getQuantity());
			ps.setDouble(7, orderDetail.getDiscount());
			
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	
	}
	@Override
	public int updateOrderDetail(OrderDetail orderDetail) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE STR_ORDERDETAIL SET ORDERID=?, PRODUCTID=?, UNITPRICE=?, ORDERLINENUMBER=?, QUANTITY=?, DISCOUNT=? WHERE ORDERDETAILID=?")) {
			
			ps.setString(1, orderDetail.getOrderId());
			ps.setString(2, orderDetail.getProductId());
			ps.setDouble(3, orderDetail.getUnitPrice());
			ps.setInt(4, orderDetail.getOrderLineNumber());
			ps.setInt(5, orderDetail.getQuantity());
			ps.setDouble(6, orderDetail.getDiscount());
			ps.setString(7, orderDetail.getOrderDetailId());

			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public int deleteOrderDetail(String orderDetailId) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM STR_ORDERDETAIL WHERE ORDERDETAILID = ?")) {
			ps.setString(1, orderDetailId);
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public OrderDetail getOrderDetailByOrderDetailId(String orderDetailId) {
		OrderDetail ordd = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_ORDERDETAIL WHERE ORDERDETAILID = ?")) {
			ps.setString(1, orderDetailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(ordd == null){
					ordd = new OrderDetail();
				}
				ordd.setOrderDetailId(rs.getString(1));
				ordd.setOrderId(rs.getString(2));
				ordd.setProductId(rs.getString(3));
				ordd.setUnitPrice(rs.getDouble(4));
				ordd.setOrderLineNumber(rs.getInt(5));
				ordd.setQuantity(rs.getInt(6));
				ordd.setDiscount(rs.getDouble(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ordd;
	}

	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(String orderId) {
		List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_ORDERDETAIL WHERE ORDERID=?")) {
			ps.setString(1, orderId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				
				OrderDetail ordd = new OrderDetail();
				ordd.setOrderDetailId(rs.getString(1));
				ordd.setOrderId(rs.getString(2));
				ordd.setProductId(rs.getString(3));
				ordd.setUnitPrice(rs.getDouble(4));
				ordd.setOrderLineNumber(rs.getInt(5));
				ordd.setQuantity(rs.getInt(6));
				ordd.setDiscount(rs.getDouble(7));
				orderdetails.add(ordd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderdetails;
	}

	@Override
	public int saveOrderDetails(List<OrderDetail> orderDetails){
		int retVal=0;
		return retVal;
	}
	
	@Override
	public int deleteOrderDetailsByOrderId(String orderId){
		int retVal=0;
		return retVal;
	}
}
