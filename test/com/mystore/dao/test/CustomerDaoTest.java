package com.mystore.dao.test;

import com.mystore.model.Customer;
import com.mystore.dao.service.impl.CustomerDaoImpl;

public class CustomerDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		saveCustomer();
		
		//System.out.println(customer.getCustomerByCustomerId("C3"));
		//System.out.println(customer.updateCustomer(cus) + "row(s) updated successfully");
		//System.out.println(customer.getCustomers());
		//System.out.println(customer.deleteCustomer("C3") + "row(s) deleted successfully");
	}

	static void saveCustomer(){
		System.out.println(">> saveCustomer");
		//TODO you code of creating customer object and sending to DAO layer goes here
		Customer cus = new Customer();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		cus.setCutomerId("C0102");
		cus.setCustomerName("ABHI2");
		cus.setGender("Male");
		cus.setAge(25);
		cus.setMobileNumber(9986963044L);
		cus.setEmail("abhi@gmail.com");
		cus.setAddress("Plot 55, BJB Nagar, Bhubaneswar, Odisha, India, 751014");

		int rowsAffected = customer.saveCustomer(cus);
		System.out.println(rowsAffected + "row(s) inserted into STR_CUSTOMER");
		System.out.println("<< saveCustomer");
	}
	
	void updateCustomer(){
		
	}
	
	void deleteCustomer(String customerId){
		
	}
}
