package utils;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;

import java.util.*;

/**
 *
 * @author wangjing
 * @version 1.0
 * @created 2018年4月16日 下午2:18:57
 */
public class XmlUtils {
	public static void main(String[] args) throws DocumentException {
		String xml = "<xml><source>调用者标识</source><target>目标标识</target><requestUUID>请求唯一标识</requestUUID ><requestType>请求渠道类型</requestType ><requestUserID>用户渠道ID</requestUserID><requestTime>请求时间</requestTime><data><msgBody>消息内容</msgBody><msgType>消息类型</msgType><msgUrl>消息路径</msgUrl><msgTitle>消息标题</msgTitle><msgDesc>消息描述</msgDesc><account>银行账号</account><userName>用户名称</userName><cellPhone>手机号码</cellPhone></data></xml >";
		System.out.println(parseXmlStr(xml).toString());
	}

	/**
	* 解析XML字符串
	*
	* @param xml
	* @return
	* @throws DocumentException
	*/
	public static JSONObject parseXmlStr(String xml)throws DocumentException {
		Document document = DocumentHelper.parseText(xml);
		JSONObject json = (JSONObject) JSONObject.toJSON(xml2map(document.getRootElement()));
		return json;
	}

	/**
	* 解析Element
	*
	* @param root
	* @return
	*/
	@SuppressWarnings("unchecked")
	public static Object xml2map(Element element) {
		Map<String, Object> map = new HashMap<String, Object>();
        List<Element> elements = element.elements();
        if (elements.size() == 0) {
            map.put(element.getName(), element.getText());
            if (!element.isRootElement()) {
                return element.getText();
            }
        } else if (elements.size() == 1) {
            map.put(elements.get(0).getName(), xml2map(elements.get(0)));
        } else if (elements.size() > 1) {
            // 多个子节点的话就得考虑list的情况了，比如多个子节点有节点名称相同的
            // 构造一个map用来去重
            Map<String, Element> tempMap = new HashMap<String, Element>();
            for (Element ele : elements) {
                tempMap.put(ele.getName(), ele);
            }
            Set<String> keySet = tempMap.keySet();
            for (String string : keySet) {
                Namespace namespace = tempMap.get(string).getNamespace();
                List<Element> elements2 = element.elements(new QName(string, namespace));
                // 如果同名的数目大于1则表示要构建list
                if (elements2.size() > 1) {
                    List<Object> list = new ArrayList<Object>();
                    for (Element ele : elements2) {
                        list.add(xml2map(ele));
                    }
                    map.put(string, list);
                } else {
                    // 同名的数量不大于1则直接递归去
                    map.put(string, xml2map(elements2.get(0)));
                }
            }
        }
        return map;
	}
}
