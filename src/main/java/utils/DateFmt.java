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


	public static SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");

	public static SimpleDateFormat sdf_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 进行日期格式化，并返回日期的字符串
	 *
	 * @param dateFormat 日期格式化的格式，也是返回日期字符串的格式，日期格式为SimpleDateFormat的格式
	 * @param amount     日期的增量，例：当前时间是20191223 ，amount=1，则为20191224，amount=-1，则为20191222
	 * @return 返回格式化后的日期字符串
	 */
	public static String getFormatDate(String dateFormat, int amount) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, amount);
		Date formatDate = calendar.getTime();
		return simpleDateFormat.format(formatDate);
	}

	/**
	 * @param dateFormat 日期格式
	 * @param date       需要格式化的日期
	 * @return
	 */
	public static String getFormatDate(String dateFormat, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	public static long getDateLongFormString(SimpleDateFormat sdf, String dateStr) {
		try {
			Date date = sdf.parse(dateStr);
			return date.getTime();
		} catch (Exception e) {
			return 0L;
		}
	}

	public static long getDateLongFormString(String dateStr) {
		try {
			Date date = sdf_yyyyMMdd.parse(dateStr);
			return date.getTime();
		} catch (Exception e) {
			return 0L;
		}
	}

	static SimpleDateFormat sdf_order_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//2020-05-13 00:00:00
	public static Date parseOrderShareDate(String dateStr) {

		try {
			return sdf_order_date.parse(dateStr);
		} catch (Exception e) {
			return null;

		}


	}


	public static void main(String[] args) throws Exception {
//		String input = "2014-01-07 08:40:51";
//		String result = getCountDate(input, DateFmt.date_short);
//		System.out.println(result);
//		Date date = parseDate(input);
//		System.out.println(date);

		System.out.println(getFormatDate("yyyyMMddHHmmss",new Date()));
	}

}
