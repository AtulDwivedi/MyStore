package com.mystore.dao.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mystore.dao.service.LoginDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.model.Customer;
import com.mystore.model.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public int saveLogin(Login login) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO STR_LOGIN VALUES(?,?,?)")) {
			
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			ps.setString(3, login.getUserType());

			
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	
	}
	@Override
	public int updateLogin(Login login) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE STR_LOGIN SET PASSWORD=?, USERTYPE=? WHERE USERNAME=?")) {
			
			ps.setString(1, login.getPassword());
			ps.setString(2, login.getUserType());
			ps.setString(3, login.getUserName());

			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public int deleteLogin(String userName) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM STR_LOGIN WHERE USERNAME = ?")) {
			ps.setString(1, userName);
			retVal = ps.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public boolean checkLogin(Login login){
		boolean retVal=false;
		return retVal;
	}
	
	
	@Override
	public String getUserTypeByUserName(String userName){
		String retVal="";
		return retVal;
	}
	

}
