package com.epam.bms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection connection = null;

	private DbConnection() {

	}

	public static Connection getConnectionToDb() {
		
		String url = "jdbc:mysql://localhost:3306/bms";
		String username = "root";
		String pwd = "Epam123$$";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (connection == null || connection.isClosed())
				connection = (Connection) DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
