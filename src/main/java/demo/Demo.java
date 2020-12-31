package demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年11月19日</p>
 * @author dingd
 *
 */
public class Demo {



	public void testCachedThreadPool() throws Exception {

	}


	static void changeUser(User user){
		user = new User(1, "name");
	}

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {

		int[] t1 = new int[3];
		t1[0] =1;
		t1[1] =2;
		t1[2] = 3;
		int[] t2 = t1;
		t2[1] = 22;
		System.out.println(t1[1]);
		System.out.println(t2[1]);

		String ss1 = "ss1";
		String ss2 = ss1;
		System.out.println(ss1);
		System.out.println(ss2);
		ss1 = "s1";
		System.out.println(ss1);
		System.out.println(ss2);
		ss2 = "s2";
		System.out.println(ss1);
		System.out.println(ss2);

		int i1 = 1;
		int i2 = i1;
		System.out.println(i1);
		System.out.println(i2);
		i1 = 11;
		System.out.println(i1);
		System.out.println(i2);
		i2 = 22;
		System.out.println(i1);
		System.out.println(i2);

		User user1 = new User(1, "11");
		User user2 = user1;
		System.out.println(user1);
		System.out.println(user2);
		user1.setName("111");
		System.out.println(user1);
		System.out.println(user2);
		changeUser(user1);
		user2.setId(2);
		System.out.println(user1);
		System.out.println(user2);
		user2 = new User(22, "222");
		System.out.println(user1);
		System.out.println(user2);
		user1.setId(11);
		System.out.println(user1);
		System.out.println(user2);

		String s1 = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u043B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
		String s2 = new String(s1.getBytes("utf8"));
		System.out.println(s2);
//		// 声明一个线程池
//		ExecutorService es = Executors.newCachedThreadPool();
//		for (int i = 0; i < 4; i++) {
//			final int a = i;
//			// 每一次调用execute方法，都会向线程池中放入一个对象
//			es.execute(new Runnable() {
//				@Override
//				public void run() {
//					while (true) {
//						System.err.println("测试...."+ a +">"+
//								Thread.currentThread().getName()+","+
//								Thread.currentThread().isDaemon());
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//
//				}
//			});
//		}

//		es.shutdown();
//		es.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
//		String s1 = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u043B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
//		String s2 = new String(s1.getBytes("UTF8"));
//		System.out.println(s2);

		Date date1 = new Date();
		System.out.println("date1----------------->" + date1);
		String str1 = "aa";
		ArrayList list = new ArrayList();
		list.add("bb");
		list.add("aa");
		list.add("cc");
		System.out.println(list.indexOf("cc"));
		System.out.println(list.indexOf("aaa"));
		System.out.println(1%5 == -1);
//		if (list.indexOf(str1) == -1)
//		{
//			list.add(str1);
//		}

		String str = "123456";
		System.out.println(str.replaceAll("456", "33"));
		List<String> lists = new ArrayList<String>();
		lists.add("5");
		lists.add("2");
		lists.add("9");
		System.out.println(lists);
		//lists中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
		Collections.sort(lists);
		System.out.println(lists);



		CronSequenceGenerator generator = new CronSequenceGenerator("0 15 * * * MON-FRI");

		Date next = generator.next(new Date());
		System.out.println(next); //Mon Apr 22 17:15:00 CST 2019
		System.out.println(generator.next(next)); //Mon Apr 22 18:15:00 CST 2019
		StringBuffer sb = new StringBuffer("我的");
		AtomicInteger atomicInteger = new AtomicInteger(100);
		System.out.println(sb.append(atomicInteger).toString());
		System.out.println(String.format("%02d", new Random().nextInt(100)));
		System.out.println(String.format("pi%s-st%s-sc", 1, 1));
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("");

		Thread.sleep(10000);
		Date date2 = new Date();
		System.out.println("date2----------------------->" + date2);
//		System.out.println(date2 - date1);

//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(2^32-1);
//        System.out.println("Aa".hashCode());
//        System.out.println("BB".hashCode());
//		System.out.println(getAccountIdByUUId());
//        System.out.println(getOrderIdByUUId());
//		System.out.println(8830*(1-(0.07+0.08+0.003+0.02))-1.6);
//		System.out.println(UUID.randomUUID().toString().replace("-",""));
//		System.out.println("]<span class='question'>");
//		System.out.println(StringUtils.difference("accbc", "acbxyz"));
//		System.out.println(StringUtils.abbreviateMiddle("abcdefghij", "...", 8));

//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 4, 10));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 5, 10));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 6, 10));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 7, 10));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 8, 10));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 3, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 4, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 5, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 6, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 7, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 8, 12));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 3, 13));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 4, 13));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 5, 13));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 6, 13));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 7, 13));
//		System.out.println(StringUtils.abbreviate("abcdefghijklmno", 8, 13));
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", 1);
//		map.put("name", "dd");
//		JSONObject json = (JSONObject) JSONObject.toJSON(map);
//		System.out.println(json);


//		String str=null;
//		str=String.format("Hi, %s", "林计钦"); // 格式化字符串
//		System.out.println(str); // 输出字符串变量str的内容
//
//		System.out.printf("3>7的结果是：%b %n", 3>7);
//		System.out.printf("100的一半是：%d %n", 100/2);
//		System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
//		System.out.printf("上面的折扣是%d%% %n", 85);

//		String number = "2";
//		String result = String.format("%0"+2+"d",Integer.valueOf(number));
//		System.out.println(result);

//		Date nowDate = new Date();
//		System.out.println(nowDate);
//		System.out.println(nowDate.getTime());
//		System.out.println(1000000/24/60/60);
//		System.out.println(24*60/3);
//		System.out.println(1000000/1024);
//		Demo demo = new Demo();
//		;for (int i= 100; i<100000;i++){
//			String f1 = "E:\\testFfmpeg\\1e9e2c0e-efec-4404-a97d-604afdb3bbe1.flv";
//			String f2 = "E:\\testFfmpeg\\" + i + ".flv";
//			demo.fileChannelCopy(f1, f2);
//		}
//		List<File> fileList = new ArrayList<File>();
////        long time = System.currentTimeMillis() - 24L*Long.parseLong(scanTime)*60*60*1000;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		String testTime = "2019-03-05 12:00";
//		String path = "E:\\testFile";
//		Date date = sdf.parse(testTime);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
////		log.info("testTime: {}", date);
//		System.out.println("testTime: " + date);
//		long time = calendar.getTimeInMillis();
//		fileList = getFiles(fileList, path, time);

//		String url = "http://testreplay.njcb.com.cn/replay/downloadRecording.do?file=ff10e825-92a2-4f6e-ae94-cf3c627ede60";
//		String fileName = url.split("file=")[1];
//		System.out.println(fileName);



//		String url = "http://192.168.39.239:8080/api/v2/recordings/00AG4FLN7C9VLDT3AONAHG5AES00001F/play/d1f83ac3-c6f0-484a-a0a6-470a435e185e.mp3";
//		String[] strings = url.split("/");
//		String fileName = strings[6];
//		System.out.println(fileName);

//		String testTime = "2019-04-04 10:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		Date date = sdf.parse(testTime);
//		Calendar calendar = Calendar.getInstance();
////		calendar.set(2019, 3, 4, 10, 0, 0);
//		calendar.setTime(date);
//		long time = calendar.getTimeInMillis();
//		System.out.println(time);
////		Date date = new Date(time);
//		System.out.println(date);


//		boolean flag;
//		List<File> fileList = new ArrayList<File>();
//		File file = new File("D:\\项目交接\\南京项目资料\\test111.txt");
//		fileList.add(file);
//		for (int f = 0;f<fileList.size();f++){
//			System.out.println(1);
//			flag = fileList.get(f).delete();
//			System.out.println(flag);
//		}
//		String path = "D:\\项目交接\\南京项目资料\\vidyofile";
//		getFiles(fileList, path , time);



//		String path = "D:\\项目交接\\南京项目资料\\vidyofile";
//		File[] allFiles = new File(path).listFiles();
//		System.out.println(allFiles.length + Arrays.toString(allFiles));

//		String osName = System.getProperty("os.name");
//		System.out.println("系统名称：" + osName);
//		List<String> list = new ArrayList<String>();
//		list.add("11");
//		list.add("22");
//		System.out.println(list.toString());
//
//		File[] allFiles = new File[1];
//		System.out.println(allFiles.length);
//		String url = "http://testreplay.njcb.com.cn/replay/downloadRecording.do?file=ff10e825-92a2-4f6e-ae94-cf3c627ede60";
//		String fileName = url.split("file=")[1];
//		System.out.println(fileName);
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2019,4,4,10,0, 0);
//		System.out.println(calendar.getTime());
//		System.out.println(calendar.getTimeInMillis());
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(1, 2);
//		map.put(2, 3);
//		Integer result = map.get(3);
//		System.out.println(result);
//		String tmpDir = System.getProperty("java.io.tmpdir");
//		System.err.println(tmpDir);
//		System.out.println(getValue(0.5));
//		System.out.println(getValue(0.3));
//		System.out.println(getValue(0.6));
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		Date date = formatter.parse("2018-11-07T20:37:42.803+08:00");
//		System.out.println(date);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String sDate=sdf.format(date);
//		System.out.println(sDate);
		
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


	public static String getOrderIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        System.out.println("hashCodeV------->" + hashCodeV);
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        System.out.println("hashCodeV------->" + hashCodeV);
        // 0 代表前面补充0
        // 15 代表长度为15
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

    /**
     * 使用UUID获得一个不重复的16位账号的算法
     * @return
     */
	public static String getAccountIdByUUId() {
		int machineId = 1;//最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
		}
		return machineId + String.format("%015d", hashCodeV);
	}


	public void fileChannelCopy(String sFile, String tFile) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		File s = new File(sFile);
		File t = new File(tFile);
		if (s.exists() && s.isFile()) {
			try {
				fi = new FileInputStream(s);
				fo = new FileOutputStream(t);
				in = fi.getChannel();// 得到对应的文件通道
				out = fo.getChannel();// 得到对应的文件通道
				in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fi.close();
					in.close();
					fo.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	private static  List<File> getFiles(List<File> fileList, String path, long time) throws IOException, InterruptedException {
		File[] allFiles = new File(path).listFiles();
		List<File> allFile = new ArrayList<File>();
		if (allFiles != null){
//            log.info("allFiles的大小: {}, allFiles: {}", allFiles.length, Arrays.toString(allFiles));
//			System.out.println("allFiles的大小: " + allFiles.length +  "allFiles: " + Arrays.toString(allFiles));
			for (int i = 0; i < allFiles.length; i++) {
				File file = allFiles[i];
				if (file.isFile()) {
					allFile.add(file);
					long fileTime = file.lastModified();
					if (fileTime < time){
						String fileName = file.getName();
						if (fileName.contains(".mp3") || fileName.contains(".flv") || fileName.contains(".index") || fileName.contains(".jpg")){
							fileList.add(file);
							String[] strings = file.getName().split("\\.");
//							System.out.println(Arrays.toString(strings));
							String flvName = strings[strings.length -1];
							if (flvName.equals("flv")){
//                            添加MP4文件到fileList中
//								File flvFile = flvToMp4(file);
//								fileList.add(flvFile);
//								System.out.println(flvName);
							}
						}
					}
				} else  {
					getFiles(fileList, file.getAbsolutePath(), time);
				}
			}
//            log.info("fileList的大小: {}, fileList: {}", fileList.size(), fileList.toString());
			System.out.println("fileList的大小: " + fileList.size() + "fileList: " + fileList.toString());
			System.out.println("allFile的大小：" + allFile.size() + "allFile: " + allFile.toString() );
		}
		return fileList;
	}



	static boolean get(int n) {
		for (int i = 0; i < n; i++) {
			if(i == 3) return false;
			System.out.println(i);
		}
		return true;
	}


	/**
	 *  doulbe为正数时：小数位的数值大于等于0.5，输出为整数部分+0.5；反之输出为整数部分+0.0
	 * @param d 输入的double值
	 * @return  double结果
	 */
	public static double getValue(double d) {
		double temp = 0.0;
		Math.floor(d);
		if (d - Math.floor(d) >= 0.5)
			temp += Math.floor(d) + 0.5;
		else
			temp += Math.floor(d);
		return temp;
	}


}
