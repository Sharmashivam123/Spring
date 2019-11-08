package com.epam.bms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtilImpl implements DbUtil {

	private Connection connection = DbConnection.getConnectionToDb();

	public ResultSet getResulSet(String query) throws Exception {
		ResultSet result;
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			result = stmt.executeQuery();
		} catch (Exception e) {
			throw new Exception();
		}
		return result;
	}

	@Override
	public int insertData(String query) throws Exception {
		int result = 0;
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
