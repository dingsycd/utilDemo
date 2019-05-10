package utils;

/**
 *
 * @author wangjing
 * @version 1.0
 * @created 2018年5月20日 下午5:10:10
 */
public class HttpUrl {
	public static String chat_url = new PropUtil("/sysconfig.properties")
	.getProperty("chat_url").trim(); //  sftp链接储存地址
}
