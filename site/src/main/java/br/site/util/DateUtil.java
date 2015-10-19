package br.site.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String PATTERN_DATE = "ddMMyyyy";
	
	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
		
		String formated = null;
		
		try {
			formated = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return formated;
	}
	
	
}
