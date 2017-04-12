package com.mystore.dao.service;

import java.util.List;

import com.mystore.dao.service.impl.Employee;

public interface EmployeeDao {
	int saveEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(String employeeId);
	
	Employee getEmployeeByEmployeeId(String employeeId);
	List<Employee> getEmployees();
}
