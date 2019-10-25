package com.epam.bms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtilImpl implements DBUtil{
	public ResultSet getResulSet(String query) throws Exception {
		ResultSet result;
		Connection connection = DbConnection.getConnectionToDb();
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			result = stmt.executeQuery();
		} catch (Exception e) {
			throw new Exception();
		}
		return result;
	}
}
