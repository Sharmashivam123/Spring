package com.epam.bms.util;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RetrievingData {
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
