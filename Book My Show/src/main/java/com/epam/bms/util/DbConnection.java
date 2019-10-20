package com.epam.bms.util;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DbConnection {
	private static Connection connection = null;

	private DbConnection() {

	}

	public static Connection getConnectionToDb() {
		String url = "jdbc:mysql://localhost:3306/tbs";
		String username = "root";
		String pwd = "";

		try {
			if (connection == null || connection.isClosed())
				connection = (Connection) DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
