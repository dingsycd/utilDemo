package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年11月19日</p>
 * @author dingd
 *
 */
public class Demo {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = formatter.parse("2018-11-07T19:37:42.803+08:00");
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate=sdf.format(date);
		System.out.println(sDate);
		
//		String date = "2016-08-15T16:00:00.000Z";
//		date = date.replace("Z", " UTC");
//		System.out.println(date);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		Date d = format.parse(date);
//		System.out.println(d);
		
		
//		String input = "[[\"[10, 15, 8]\",\"[11, 16, 9]\"]]";
//		System.out.println(input);
//		String sub = input.substring(4,input.length() - 4);
//		System.out.println(sub);
//		/**
//		 * | .  *  [] \  是特殊字符，在使用时要进行转义
//		 *   解决办法   \\[
//		 * 如：String [] = timeArr.split("\\[");
//		 */
//		String[] strings = sub.split("\\]\",\"\\[");
//		for (int i = 0; i < strings.length; i++) {
//			System.out.println(strings[i]);
//		}
//		System.out.println(1);
//		System.out.println("a");
//		System.out.println(11);
//		System.out.println("11.20");
//		System.out.println(get(3));
	}

	static boolean get(int n) {
		for (int i = 0; i < n; i++) {
			if(i == 3) return false;
			System.out.println(i);
		}
		return true;
	}
}
