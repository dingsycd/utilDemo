package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年11月27日</p>
 * @author dingd
 *
 */
public class DateFmt {
	public static final String     date_long  = "yyyy-MM-dd HH:mm:ss";
	public static final String     date_short = "yyyy-MM-dd";
	public static SimpleDateFormat sdf        = new SimpleDateFormat(date_long);
	
	public static String getCountDate(String date, String pattern) {
		SimpleDateFormat sdFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			try {
				calendar.setTime(sdFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return sdFormat.format(calendar.getTime());
	}
	
	public static Date parseDate(String dateStr) throws Exception {
		return sdf.parse(dateStr);
	}
	
	public static void main(String[] args) throws Exception {
		String input = "2014-01-07 08:40:51";
		String result = getCountDate(input, DateFmt.date_short);
		System.out.println(result);
		Date date = parseDate(input);
		System.out.println(date);
	}

}
