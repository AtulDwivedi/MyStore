package service;

import java.util.List;

import com.mystore.dao.service.CustomerDao;
import com.mystore.dao.service.impl.CustomerDaoImpl;
import com.mystore.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public int saveCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao.saveCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
