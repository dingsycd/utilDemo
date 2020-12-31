package config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现了这个接口（ApplicationContextAware）之后，这个类就可以方便获得ApplicationContext中的所有bean。换句话说，就是这个类可以直接获取spring配置文件中，所有有引用到的bean对象
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
 
    private static ApplicationContext context;
 
    private ApplicationContextProvider(){}
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
 
    public  static <T> T getBean(String name,Class<T> aClass){
        return context.getBean(name,aClass);
    }
 
 
}
