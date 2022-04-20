package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learnersacademy", "mbhatk", "welcome!2345");
		 return conn;
	}
}
