package com.mystore.dao.test;

import com.mystore.model.Customer;
import com.mystore.dao.service.impl.CustomerDaoImpl;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		CustomerDaoImpl customer=new CustomerDaoImpl();
		cus.setCutomerId("C2");
		cus.setCustomerName("ABHI3");
		cus.setGender("Male");
		cus.setAge(24);
		cus.setMobileNumber(9986963043L);
		cus.setEmail("abhi@123.com");
		cus.setAddress("Plot 28, Bapuji Nagar, Bhubaneswar, Odisha, India, 751009");
		
//		int rowsAffected=customer.saveCustomer(cus);
//		System.out.println(rowsAffected+"row(s) inserted into CUSTOMER");
//		System.out.println(customer.getCustomerByCustomerId("C2"));
//System.out.println(customer.updateCustomer(cus));
		System.out.println(customer.getCustomers());
	}

}
