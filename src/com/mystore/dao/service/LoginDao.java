package com.mystore.dao.service;

import com.mystore.model.Login;

public interface LoginDao {
	int saveLogin(Login login);
	int updateLogin(Login login);
	int deleteLogin(String userName);
	
	boolean checkLogin(Login login);
	String getUserTypeByUserName(String userName);
}
