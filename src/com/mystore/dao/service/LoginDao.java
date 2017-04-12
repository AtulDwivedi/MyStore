package com.mystore.dao.service;

import com.mystore.model.Login;

public interface LoginDao {
	int saveLogin(Login login);
	int updateLogin(Login login);
	int deleteLogin(String userId);
	
	boolean checkLogin(Login login);
	String getUserTypeByUserId(String userId);
}
