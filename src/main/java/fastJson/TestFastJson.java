package fastJson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * <p>Description: 测试fastJson的API </p>
 * <p>Date: 2018年12月29日</p>
 * @author dingd
 *
 */
public class TestFastJson {
	
	static class Person {
		private String id;
        private String name;
        private int age;
	    
        /**
         * 无参构造器
         */
        public Person(){}
	    
        /**
         * 有参构造器
         */
        public Person(String id, String name, int age){ 
            this.id = id;
            this.name = name;
            this.age = age;
        }
        
        /**
         * id
         */
        public String getId(){
            return id;
        }
        
        /**
         * id
         */
        public void setId(String id) {
            this.id = id;
        }
        
        /**
         * name
         */
        public String getName() {
            return name;
        }
        
        /**
         * name
         */
        public void setName(String name) {
            this.name = name;
        }
        
        /**
         * age
         */
        public int getAge() {
            return age;
        }
        
        /**
         * age
         */
        public void setAge(int age) {
            this.age = age;
        }
        
        @Override
        /**
         * 实体类转换为字符串
         */
        public String toString() {
            return "age=" + age + ", id=" + id + ", name=" + name;
        }
	}  
	    public static void main(String[] args) { 
	        method1();
	        method2();
	        //method3();
	        //method4();
	    }  
	    
	    /**
	     * 测试单个对象和Json的互换
	     */
	    static void method1(){
	    	System.out.println("javabean转化示例开始----------");
	        Person person = new Person("1", "fastjson", 1);
	        //这里将javabean转化成json字符串
	        String jsonString = JSON.toJSONString(person);
	        System.out.println(jsonString);
	        //这里将json字符串转化成javabean对象
	        person =JSON.parseObject(jsonString,Person.class);
	        System.out.println(person.toString());
	        System.out.println("javabean转化示例结束----------");
	    }  
	    
	    /**
	     * 测试对象组和Json的互换
	     */
	    static void method2(){
	        System.out.println("List<javabean>转化示例开始----------");
	        Person person1 = new Person("1", "fastjson1", 1);
	        Person person2 = new Person("2", "fastjson2", 2);
	        List<Person> persons = new ArrayList<Person>();
	        persons.add(person1);
	        persons.add(person2);
	        String jsonString = JSON.toJSONString(persons);
	        System.out.println("json字符串:" + jsonString);
	        //解析json字符串
	        List<Person> persons2 = JSON.parseArray(jsonString, Person.class);
	        //输出解析后的person对象，也可以通过调试模式查看persons2的结构
	        System.out.println("person1对象：" + persons2.get(0));
	        System.out.println("person2对象：" + persons2.get(1));
	        System.out.println("List<javabean>转化示例结束----------");
	    }
}
