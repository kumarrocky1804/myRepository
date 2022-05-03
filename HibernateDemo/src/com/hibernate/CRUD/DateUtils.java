package com.hibernate.CRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils 
{
	// The date formatter
    // - dd:   day in month (number)
    // - MM:   month in year (number)
    // - yyyy: year
    //
    // See this link for details: 
	//	https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
    //
    //
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	// read string and return date
	public static Date stringToDate(String str) throws ParseException
	{
		return formatter.parse(str);
	}
	
	// read date and convert to string
	public static String dateToString(Date date)
	{
		if(date != null)
		{
			return formatter.format(date);
		}
		return null;
	}
	
}
