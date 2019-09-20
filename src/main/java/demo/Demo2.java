package demo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;

public class Demo2 {
     public static void main(String[] args) throws UnsupportedEncodingException {
		//时间处理
//		 Calendar calendar = Calendar.getInstance();
////		 calendar.add(Calendar.DATE, -1);
////		 calendar.add(Calendar.HOUR, -1);
////		 calendar.add(Calendar.HOUR_OF_DAY, -1);
//		 System.out.println(calendar.getTime());
		 split("我abc",4);
//		 String s = new String("1".getBytes("gb2312"),"utf8");
//		 ArrayList list = new ArrayList();
//		 list.contains("");

		 short s1 = 1;
//		 s1 = s1 + 1;
		 s1 += 1;
		 System.out.println(s1);
		 String name = "22";
		 switch (name){
			 case "11":
				 System.out.println(11);
				 break;
			 case "22":
				 System.out.println(22);
				 break;
		 }
	}

	public static void split(String source,int num){
     	int k=0;
     	String temp="";
     	for (int i = 0; i <source.length(); i++) {
     		byte[] b=(source.charAt(i)+"").getBytes();
     		k=k+b.length;
     		if(k>num) {
     			break;
     		} temp=temp+source.charAt(i);
     	}
     	System.out.println(temp);
     }
}
