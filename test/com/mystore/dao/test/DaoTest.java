package com.mystore.dao.test;

import com.mystore.model.Customer;
import com.mystore.dao.service.impl.CustomerDaoImpl;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cus = new Customer();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		cus.setCutomerId("C2");
		cus.setCustomerName("ABHI2");
		cus.setGender("Male");
		cus.setAge(25);
		cus.setMobileNumber(9986963044L);
		cus.setEmail("abhi@gmail.com");
		cus.setAddress("Plot 55, BJB Nagar, Bhubaneswar, Odisha, India, 751014");

		int rowsAffected = customer.saveCustomer(cus);
		System.out.println(rowsAffected + "row(s) inserted into STR_CUSTOMER");
		//System.out.println(customer.getCustomerByCustomerId("C3"));
		//System.out.println(customer.updateCustomer(cus) + "row(s) updated successfully");
		//System.out.println(customer.getCustomers());
		//System.out.println(customer.deleteCustomer("C3") + "row(s) deleted successfully");
	}

}
