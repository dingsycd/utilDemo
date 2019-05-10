package utils;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

public class PropUtil {
	Properties props = new Properties();
	Set propSet;
	Iterator propIt;
	String property;
	public String getProperty(String key) {
		property=props.getProperty(key);
		if(property==null||property.length()<=0||property.toLowerCase(Locale.ENGLISH).equals("null"))
			property="";
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	public PropUtil(String path){
		InputStream in = this.getClass().getResourceAsStream(path);;
		try{
	        props.load(in);
	    } catch(IOException e){
	        e.printStackTrace();
	    }finally{
	    	if(in!=null){
	    		try {
					in.close();
					in=null;
				} catch (IOException e) {
					e.printStackTrace();
				}

	    	}
	    }

	}
	public PropUtil(String path,int  type){
		InputStream in =null;

			try{
				if(type==1){
					 in = this.getClass().getResourceAsStream(path);
				}else{ //不等于1时,通过class获取绝对路径   %20 为空格   转换
					String realPath = this.getClass().getResource("").getPath().replace("WEB-INF/classes/com/puweiduo/core/util/", "");
					realPath = realPath.replace("%20"," ");
					in = new FileInputStream(realPath+path);
			    }
		        props.load(in);
		    } catch(IOException e){
		        e.printStackTrace();
		    }finally{
		    	if(in!=null){
		    		try {
						in.close();
						in=null;
					} catch (IOException e) {
						e.printStackTrace();
					}

		    	}
		    }


	}
	/**
	 * 写入xml文件地址
	 *
	 * @param document
	 *            所属要写入的内容
	 * @param outFile
	 *            文件存放的地址
	 */
	    public static void writeDocument(Document document, String outFile){
	        try{
			// 读取文件
            FileWriter fileWriter = new FileWriter(outFile);
			// 设置文件编码
            OutputFormat xmlFormat = new OutputFormat();
            xmlFormat.setEncoding("utf-8");
			// 创建写文件方法
            XMLWriter xmlWriter = new XMLWriter(fileWriter,xmlFormat);
			// 写入文件
            xmlWriter.write(document);
			// 关闭
            xmlWriter.close();
	        }catch(IOException e){
			System.out.println("文件没有找到");
	            e.printStackTrace();
	        }
	    }
	public Set getPropSet() {
		propSet=props.keySet();
		return propSet;
	}
	public void setPropSet(Set propSet) {
		this.propSet = propSet;
	}
	public Iterator getPropIt() {
		propIt = this.getPropSet().iterator();
		return propIt;
	}
	public void setPropIt(Iterator propIt) {
		this.propIt = propIt;
	}


}
