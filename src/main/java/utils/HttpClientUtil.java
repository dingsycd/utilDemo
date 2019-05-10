package utils;

import org.apache.commons.net.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 使用apache httpclient 4.3以上的版本jar 提供httpclient连接工具类
 *
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	static {
		cm.setMaxTotal(800);
		cm.setDefaultMaxPerRoute(800);
	}

	/**
	 * 通过get方式获取指定地址的内容
	 *
	 * @param url
	 *            需要访问的地址如：http://www.baidu.com
	 * @param chartset
	 *            字符编码，将地址返回的内容进行字符编码，如果为空则默认为：UTF-8
	 * @return 地址对应的内容
	 */
	public static String get(String url, int socketTime, int connectTimeout, String chartset)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		RequestConfig requetConfig = RequestConfig.custom().setSocketTimeout(socketTime)
				.setConnectTimeout(connectTimeout).build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requetConfig);
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
			if (chartset == null || "".equals(chartset)) {
				chartset = "UTF-8";
			}
			String responseBody = EntityUtils.toString(entity1, chartset);
			EntityUtils.consume(entity1);
			StatusLine statusLine = response1.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if(statusCode!=200){
				byte[] contextByte = Base64.encodeBase64(responseBody.getBytes(), true);
			    String responseBodyLog = new String(contextByte);
				logger.error("current request url error,satusCode:{},responseBody:{}",statusCode,responseBodyLog);
				throw new IOException("request url statusCode is 500!");
			}
			return responseBody;
		} finally {
			if (response1 != null) {
				response1.close();
			}
		}
	}

	/**
	 * 使用post方式提交参数
	 *
	 * @param url
	 * @param params
	 *            提交的参数已key,value的形式保存在map当中
	 * @param socketTime
	 * @param connectTimeout
	 * @param chartset
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws IOException
	 */
	public static String post(String url, Map<String, String> params, int socketTime, int connectTimeout,
			String chartset) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		RequestConfig requetConfig = RequestConfig.custom().setSocketTimeout(socketTime)
				.setConnectTimeout(connectTimeout).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requetConfig);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		if (chartset == null || "".equals(chartset)) {
			chartset = "UTF-8";
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, chartset));
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpPost);
			HttpEntity entity1 = response1.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			String responseBody = EntityUtils.toString(entity1, chartset);
			EntityUtils.consume(entity1);
			StatusLine statusLine = response1.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if(statusCode!=200){
				byte[] contextByte = Base64.encodeBase64(responseBody.getBytes(), true);
			    String responseBodyLog = new String(contextByte);
				logger.error("current request url error,satusCode:{},responseBody:{}",statusCode,responseBodyLog);
				throw new IOException("request url statusCode is 500!");
			}
			return responseBody;
		} finally {
			if (response1 != null) {
				response1.close();
			}
		}
	}

	/**
	 * 使用post格式提交请求一段整体内容，可以是xml或json格式
	 * @param url 请求路径
	 * @param content xml报文
	 * @param socketTime 连接时间（单位毫秒）
	 * @param connectTimeout 连接等待时间（单位毫秒）
	 * @param reqChartset 请求报文字符编码，默认为UTF-8
	 * @param respChartset 返回报文字符编码，默认为UTF-8
	 * @param contentType http内容类型
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws IOException
	 */
	public static String post(String url, String content, int socketTime, int connectTimeout,String reqChartset, String respChartset, String contentType)
			throws  IOException {
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		RequestConfig requetConfig = RequestConfig.custom().setSocketTimeout(socketTime)
				.setConnectTimeout(connectTimeout).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requetConfig);
		if (reqChartset == null || "".equals(reqChartset)) {
			reqChartset = "UTF-8";
		}
		StringEntity myEntity = new StringEntity(content, reqChartset);
		httpPost.addHeader("Content-Type", contentType);
		httpPost.setEntity(myEntity);
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpPost);
			HttpEntity entity1 = response1.getEntity();
			if (respChartset == null || "".equals(respChartset)) {
				respChartset = "UTF-8";
			}
			StatusLine statusLine = response1.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if(statusCode!=200){
				logger.error("current request url error,satusCode:{},ReasonPhrase:{}",statusCode,statusLine.getReasonPhrase());
				throw new IOException("request url statusCode is 500!");
			}
			String responseBody = EntityUtils.toString(entity1, respChartset);
			EntityUtils.consume(entity1);
			return responseBody;
		} finally {
			if (response1 != null)
				response1.close();
		}
	}

	/**
	 * 使用默认参数发送xml格式内容
	 * 默认：
	 * 	1.超时时间为30秒
	 * 	2.编码为utf-8
	 * @throws IOException
	 */
	public static String postXml(String url, String content) throws  IOException{
		return post(url,content,30000, 30000, "UTF-8", "UTF-8", "application/xml; charset=UTF-8");
	}
	/**
	 * 使用默认参数发送JSON格式内容
	 * 默认：
	 * 	1.超时时间为30秒
	 * 	2.编码为utf-8
	 * @throws IOException
	 */
	public static String postJSON(String url, String content) throws  IOException{
		return post(url,content,20000, 20000, "UTF-8", "UTF-8", "application/json; charset=UTF-8");
	}

	public static void main(String[] args)  {
		String retval = "";
		try {
			String xml = "<xml><AgentID>12823</AgentID><source>10</source><target>13</target><requestUUID>6C24D02B-389E-44D5-80EE-E4A904ED0E08</requestUUID><requestType>13</requestType><requestUserID>25151699c75411df82b8f78f64f9d5eb</requestUserID><requestTime>2018-05-31 18:48:28</requestTime><data><msgType>01</msgType><msgBody>{\"AgentID\":\"282312823\",\"AnswerMsg\":\"<![CDATA[12823工号很高兴为您服务!]]>\",\"IsTransferSatisfaction\":\"0\"}</msgBody><msgUrl></msgUrl><msgTitle></msgTitle><msgDesc></msgDesc><userType>-1</userType><userName>游客</userName><IDNO></IDNO><IDType></IDType><cellPhone></cellPhone><userGender></userGender></data></xml>";
			retval = HttpClientUtil.postXml("http://localhost:8843/onlineService/sysApi/backMessage", xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("#####" + retval);
	}

	public static void testXml(){
		String retval = "";
		String exe_date = "2018-05-29";
		String xml = "{\"params\":\""+exe_date+"\"}";
		try{
			retval = HttpClientUtil.postXml("http://103.22.255.201:8443/onlineService/sysApi/telephoneDialing", xml );
		}catch(Exception e){
			logger.error("request error", e);
		}

		System.out.println("#####" + retval);
	}

}
