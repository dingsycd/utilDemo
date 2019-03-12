package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  字符串API测试
 */
public class StringTest {
    public static void main(String[] args) {
        //测试compareTo方法
        String s1 = "haa";
        String s2 = "haa";
        System.out.println(s1.compareTo(s2));
        System.out.println(myformat_day("2017-06-19", -2));
    }

    /**
     *  得到字符串格式的时间的N天后的字符串格式的时间
     * @param datestr  yyyy-MM-dd
     * @param days     N天
     * @return
     */
    public static String myformat_day(String datestr,int days)
    {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date myDate = formatter.parse(datestr);
            Calendar c = Calendar.getInstance();
            c.setTime(myDate);
            c.add(Calendar.DATE, days);
            myDate = c.getTime();
            return formatter.format(myDate);
        }
        catch (Exception ex) {
            return "";
        }
    }
}
