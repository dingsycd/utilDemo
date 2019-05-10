package utils;

import com.jcraft.jsch.SftpException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author pc
 *
 */
public class DownLoadImg {

	public static String home_url = new PropUtil("/sysconfig.properties")
	.getProperty("home_url").trim(); //  sftp链接储存地址

	public static String download_sftp_url = new PropUtil("/sysconfig.properties")
	.getProperty("download_sftp_url").trim(); //  sftp链接储存地址



	/**
	 * 替换图片
	 * @param messageContent
	 * @return
	 */
	public static String updataImg(String messageContent){
		Document doc = Jsoup.parse(messageContent);
		Elements elements = doc.select("img[src]");//获取到的值为所有的<img src="...">
		for (Element element : elements) {
		    String src = element.attr("src");//获取到src的值
			SFTPUtils sftp = new SFTPUtils();
			sftp.uploadLogin();
	        try {
				byte[] download = sftp.download(download_sftp_url, src);
				savePic(download,src);
			} catch (SftpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        sftp.logout();
		    messageContent =  messageContent.replace(src,"../../phoneController/showImg?imgId="+src);//替换字符中所有的fileimage
		}
		return messageContent;
	}

	/**
	 * 下载图片到本地
	 * @param inputStream
	 * @param fileName
	 */
	public static void savePic(byte[] inputStream, String fileName) {
        OutputStream os = null;
        try {
            // 2、保存到临时文件
            // 输出的文件流保存到本地文件
            File tempFile = new File(home_url);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            os.write(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) {
		String noticegroupContent = "是芙蓉峰沃尔沃<img src=\"20160926092940_972.jpeg\" alt=\"\" />的的是非得失<img src=\"20160926092940_972.jpeg\" alt=\"\" /> />w恶趣味";
		System.err.println(updataImg(noticegroupContent));
	}
}
