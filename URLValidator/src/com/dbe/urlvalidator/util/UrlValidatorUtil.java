package com.dbe.urlvalidator.util;

import java.nio.charset.Charset;

public class UrlValidatorUtil {

	// uptime - status
	public static final int UT_STATUS_PAUSED = 0, UT_STATUS_NOT_CHECKED_YET = 1, UT_STATUS_UP = 2,
			UT_STATUS_SEEMS_DOWN = 8, UT_STATUS_DOWN = 9;

	public static String getUTStatus(int statusCode) {
		switch (statusCode) {
		case 0:
			return "PAUSED";
		case 1:
			return "NOT_CHECKED_YET";
		case 2:
			return "UP";
		case 8:
			return "SEEMS_DOWN";
		case 9:
			return "DOWN";
		default:
			return "...not defined";

		}

	}
	
	public static String getLogDuration(Integer logDuration) {
		
		if (logDuration == 0) return "ZERO";
		
		int hours = logDuration / 3600;
        int minutes = (logDuration%3600)/60;
        int seconds_output = (logDuration % 3600)%60;

        //System.out.println("The time entered in hours,minutes and seconds is:");
        //System.out.println(hours  + " hours :" + minutes + " minutes:" + seconds_output +" seconds");
        return hours  + " hours : " + minutes + " minutes: " + seconds_output +" seconds";

	}

	public String convertEncode(String str) {
		final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
		final Charset UTF_8 = Charset.forName("UTF-8");
		//byte[] ptext = str.getBytes(UTF_8); 
		//return new String(ptext, ISO_8859_1);
		byte[] ptext = str.getBytes(ISO_8859_1); 
		return new String(ptext, UTF_8); 
	}

	
}
