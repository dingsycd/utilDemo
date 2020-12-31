package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置类_实时消息模版
 */
@Configuration
@ConfigurationProperties(prefix = "rt-msg-tml")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class RealtimeMessageTemplateConfig {

    private Map<String, Integer> index = new HashMap<String, Integer>(); // 实时消息模版_序号
    private List<String> title = new ArrayList<String>(); // 实时消息模版_标题
    private List<String> content = new ArrayList<String>(); // 实时消息模版_正文
    private List<String> url = new ArrayList<String>(); // 实时消息模版_URL

    public Map<String, Integer> getIndex() {
        return index;
    }

    public void setIndex(Map<String, Integer> index) {
        this.index = index;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

}
