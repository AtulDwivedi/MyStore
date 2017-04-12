package com.mystore.dao.service;

import java.util.List;

import com.mystore.model.Customer;

public interface CustomerDao {

	int saveCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(String customerId);
	
	Customer getCustomerByCustomerId(String customerId);
	List<Customer> getCustomers();
}
