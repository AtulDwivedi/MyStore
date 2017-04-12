package com.mystore.dao.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mystore.dao.service.CustomerDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int saveCustomer(Customer customer) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?)")) {
			
			ps.setString(1, customer.getCutomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getGender());
			ps.setInt(4, customer.getAge());
			ps.setLong(5, customer.getMobileNumber());
			ps.setString(6, customer.getEmail());
			ps.setString(7, customer.getAddress());
			
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	
	}
	@Override
	public int updateCustomer(Customer customer) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE CUSTOMER SET CUSTOMERNAME=?, GENDER=?, AGE=?, MOBILENUMBER=?, EMAIL=?, ADDRESS=? WHERE CUSTOMERID=?")) {
			
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getGender());
			ps.setInt(3, customer.getAge());
			ps.setLong(4, customer.getMobileNumber());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getCutomerId());

			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public int deleteCustomer(String customerId) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMERID = ?")) {
			ps.setString(1, customerId);
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		Customer cus = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERID = ?")) {
			ps.setString(1, customerId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(cus == null){
					cus = new Customer();
				}
				cus.setCutomerId(rs.getString(1));
				cus.setCustomerName(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cus;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER")) {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Customer cus = new Customer();
				cus.setCutomerId(rs.getString(1));
				cus.setCustomerName(rs.getString(2));
				
				customers.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customers;
	}

}
