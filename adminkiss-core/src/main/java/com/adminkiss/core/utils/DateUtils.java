package com.adminkiss.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * 日期工具类
 *
 */
public class DateUtils {
	
	public final static DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
	public final static DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static DateFormat df3 = new SimpleDateFormat("yyyyMMddHHmmss");
	public final static DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
	public final static DateFormat df5 = new SimpleDateFormat("yyyy年MM月dd日");
	public final static DateFormat df6 = new SimpleDateFormat("yyyy年");
	public final static DateFormat df7 = new SimpleDateFormat("yyyy年MM月");
	
	public static String dateToString(Date date, int df) {
		switch (df) {
		case 1:
			return df1.format(date);
		case 2:
			return df2.format(date);
		case 3:
			return df3.format(date);
		case 4:
			return df4.format(date);
		case 5:
			return df5.format(date);	
		case 6:
			return df6.format(date);
		case 7:
			return df7.format(date);
		default:
			return df2.format(date);
		}
	}
	
	public static Date stringToDate(String date, int df){
		try {
			switch (df) {
			case 1:
				return df1.parse(date);
			case 2:
				return df2.parse(date);
			case 3:
				return df3.parse(date);
			case 4:
				return df4.parse(date);
			case 5:
				return df5.parse(date);	
			case 6:
				return df6.parse(date);
			case 7:
				return df7.parse(date);
			default:
				return df2.parse(date);
			}
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String dateToString(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static Date getNowDate() {
		Calendar rightNow = Calendar.getInstance();
		GregorianCalendar gregorianCalendar = new GregorianCalendar(rightNow.get(Calendar.YEAR),rightNow.get(Calendar.MONTH),rightNow.get(Calendar.DAY_OF_MONTH));
		return gregorianCalendar.getTime();
	}
	
	public static int daysBetween(Date start, Date end) {
		DateTime startD = new DateTime(start);
		DateTime endD = new DateTime(end);
		return Days.daysBetween(startD, endD).getDays();
	}	
}
