package com.mystore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore.model.Customer;

import service.CustomerService;
import service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet/*")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getRequestURI();
System.out.println(action);
		if (action.contains("add")) {
			Customer cutomer = new Customer();
			cutomer.setCustomerName(request.getParameter("name"));
			cutomer.setCutomerId("100000");
			cutomer.setEmail("a@a.com");
			addCustomer(cutomer);
		} else if (action.contains("edit")) {
			Customer customer = new Customer();
			editCustomer(customer);
		} else if (action.contains("delete")) {
			deleteCustomer("customerId");

		}
	}

	private void deleteCustomer(String string) {
		// TODO Auto-generated method stub

	}

	private void editCustomer(Customer customer) {

	}

	private void addCustomer(Customer customer) {
		CustomerService customerService = new CustomerServiceImpl();
		customerService.saveCustomer(customer);
	}

}
