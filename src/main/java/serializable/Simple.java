package serializable;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>Description:  </p>
 * <p>Date: 2018年11月23日</p>
 * @author dingd
 *
 */
public class Simple  implements Serializable{
	private static final long   serialVersionUID = -3771166516737075523L;
	private String              name;
    private int                 age;
    private Map<String,Integer> map;
    
     public Simple(){}  
     
     public Simple(String name, int age, Map<String,Integer> map){
         this.name = name;
         this.age = age;
         this.map = map;
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
     
  
}  
