package utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  日期工具类
 * @author wangjing
 * @version 1.0
 * @created 2018年5月21日 上午1:57:19
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private static Logger log = Logger.getLogger(DateUtils.class);

    /**
     * 根据一个给定的日期格式返回当前时间
     *
     * @param pattern 给定的日期时间格式
     * @return
     */
    public static String getCurrentDate(String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

    /**
     * 将日期字符串转换成日期类型
     *
     * @param dateStr 日期字符串
     * @param pattern 日期字符串的格式。如果没有指定（null或者""）默认为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        if (StringUtils.isNotEmpty(dateStr)) {
            try {
                return new SimpleDateFormat(pattern).parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * 将一个字符串类型的时间转换为另一种格式的字符串类型时间
     * Example : String formattedDate = DateUtils.format("20070906112351", "yyyyMMddHHmmss", "yyyy年MM月dd日 HH时mm分ss秒")
     *
     * @param date          字符串类型时间.例如20070906112351
     * @param sourcePattern 源时间的格式
     * @param targetPattern 要转换的目标格式
     * @return
     */
    public static String convert(String date, String sourcePattern, String targetPattern) {
        if (StringUtils.isBlank(date)) {
            return "";
        }
        DateFormat _formater1 = new SimpleDateFormat(sourcePattern);
        DateFormat _formater2 = new SimpleDateFormat(targetPattern);
        try {
            return _formater2.format(_formater1.parse(date));
        } catch (ParseException pe) {
            return date;
        }
    }

    /**
     * 判断一个时间是否为上午
     *
     * @param date
     * @return boolean
     */
    public static boolean isAM(Date date) {
        boolean isTrue = true;
        DateFormat df = new SimpleDateFormat("HH");
        try {
            int integerHour = Integer.parseInt(df.format(date));
            if (integerHour >= 0 && integerHour <= 12) {
                isTrue = true;
            } else {
                isTrue = false;
            }
        } catch (NumberFormatException nfe) {
            throw new RuntimeException(nfe);
        }
        return isTrue;
    }

    /**
     * 增加指定天数。
     *
     * @param advanceDay 要增加的天数，可以为负数，如果为负数表示减少天数
     * @param pattren 返回的日期格式,如果没有指定默认是yyyyMMdd
     * @return 增加的后的时间
     */
    public static String addDay(int advanceDay, String pattren) {
        if (StringUtils.isBlank(pattren)) {
            pattren = "yyyyMMdd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattren);
        GregorianCalendar d = new GregorianCalendar();
        d.add(Calendar.DAY_OF_MONTH, advanceDay);
        return format.format(d.getTime());
    }


    /**
     * 将日期转换成当天日期的最后时间(23时59分59秒999毫秒)。
     * @param date
     * @param pattern 可选参数，如果为null或者""，默认格式为yyyyMM
     * @return
     */
    public static Date getEndDatetime(String date,String pattern){
        if(StringUtils.isBlank(pattern)){
            pattern = "yyyyMMdd";
        }
        Date date1 = stringToDate(date, pattern);
        return getEndDatetime(date1);
    }

    /**
     * 返回给定日期的最后时间(23时59分59秒999毫秒)。
     * @param date
     * @return
     */
    public static Date getEndDatetime(Date date){
        if(date==null){
            return null;
        }
        date = DateUtils.setHours(date, 23);
        date = DateUtils.setMinutes(date, 59);
        date = DateUtils.setSeconds(date, 59);
        date = DateUtils.setMilliseconds(date, 999);
        return date;
    }

    /**
     * 经日期对象转换成字符串形式
     * @param date
     * @param pattern 指定要转成的日期格式
     * @return
     */
    public static String format(Date date , String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getMinMonthDate());
    }
    public static Date  GetDate(){
    	return new Date();
    }
    
    /**
     * 
     * 描述:获取下一个月的第一天.
     * 
     * @return
     */
    public static String getPerFirstDayOfMonth() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
    
    /**
     * 
     * 描述:获取上个月的最后一天.
     * 
     * @return
     */
    public static String getLastMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
    
    /**
     * 获取当前月份最后一天
     * 
//     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
    
    /**
     * 获取当前月份第一天
//     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMinMonthDate(){
    	SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
    	//获取当前月第一天：
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return dft.format(calendar.getTime());
    }
    /**
     * 
     * Description：两段时间相差几个月
     * @param startDate
     * @param endDate
     * @return
     * @return int
     * @author name：wangjing <br>email: 13693098300@163.com
     *
     */
    public static int getMonths(Date startDate, Date endDate) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }
    
    /**
     * 获取当前系统前一天日期
     * @param date
     * @return
     */
	public static Date getPevDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
}