package com.wipro.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection con = null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sonoo","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return con;
	}
}
