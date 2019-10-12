package booking;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomHandler extends Formatter {

	@Override
	public String format(LogRecord arg0) {
		return arg0.getMessage();
		
	}

}
