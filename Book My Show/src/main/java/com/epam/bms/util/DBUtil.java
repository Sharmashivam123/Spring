package com.epam.bms.util;

import java.sql.ResultSet;

public interface DbUtil {
	public ResultSet getResulSet(String query) throws Exception; 
}
