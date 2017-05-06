package com.mystore.dao.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	static Connection con;
	public static Connection getConnection() throws SQLException{
		try {
			if(con == null || con.isClosed()){
				Class.forName("org.h2.Driver");
				con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
	
	