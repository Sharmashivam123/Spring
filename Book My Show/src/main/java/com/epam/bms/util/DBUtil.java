package com.epam.bms.util;

import java.sql.ResultSet;

public interface DBUtil {
	public ResultSet getResulSet(String query) throws Exception; 
}
