package com.mystore.dao.test;


import com.mystore.model.Login;
import com.mystore.dao.service.impl.LoginDaoImpl;

public class LoginDaoTest {

	public static void main(String[] args) {
		Login log = new Login();
		LoginDaoImpl login = new LoginDaoImpl();
		log.setUserName("U2");
		log.setPassword("ABHI3");
		log.setUserType("CUSTOMER");
		
		//int rowsAffected = login.saveLogin(log);
		//System.out.println(rowsAffected + "row(s) inserted into STR_LOGIN");
		//System.out.println(login.updateLogin(log) + "row(s) updated successfully");
		System.out.println(login.deleteLogin("U2") + "row(s) deleted successfully");
		

	}

}
