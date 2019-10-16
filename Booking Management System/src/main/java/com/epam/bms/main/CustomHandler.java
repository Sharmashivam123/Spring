package com.epam.bms.main;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomHandler extends Formatter {

	@Override
	public String format(LogRecord arg) {
		return arg.getMessage();
	}
	
}
