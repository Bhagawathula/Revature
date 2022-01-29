package com.cbs.dbCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection connection;

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/CabBookingSystem";
		String username = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}
}
