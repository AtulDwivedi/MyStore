package service;

import java.util.List;

import com.mystore.model.Customer;

public interface CustomerService {
	int saveCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(String customerId);

	Customer getCustomerByCustomerId(String customerId);
	List<Customer> getCustomers();
}
