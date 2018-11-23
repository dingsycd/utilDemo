package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: java原生序列化和反序列 </p>
 * <p>Date: 2018年11月23日</p>
 * @author dingd
 *
 */
public class OriginalSerializable {  
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long start =  System.currentTimeMillis();
        setSerializableObject();
        System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
        start =  System.currentTimeMillis();
        getSerializableObject();
        System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
    }
  
    public static void setSerializableObject() throws IOException{
        FileOutputStream fo = new FileOutputStream("D:/file2.txt");
        ObjectOutputStream so = new ObjectOutputStream(fo);
        for (int i = 0; i < 1000; i++) {
            Map<String,Integer> map = new HashMap<String, Integer>(2);
            map.put("zhang0", i);
            map.put("zhang1", i);
            so.writeObject(new Simple("zhang"+i, (i + 1), map));
        }
        so.flush();
        so.close();
    }
  
    @SuppressWarnings("unused")
	public static void getSerializableObject(){
    	FileInputStream fi;  
        try {
            fi = new FileInputStream("D:/file2.txt");
            ObjectInputStream si = new ObjectInputStream(fi);
            Simple simple = null;
//            while((simple = (Simple)si.readObject()) != null){
//            	System.out.println(simple.getAge() + "  " + simple.getName());  
//            }
            fi.close();
            si.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
