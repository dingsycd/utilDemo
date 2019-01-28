package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将内容写入文件
 * @author Ausware001
 *
 */
public class WriteTest {

    public static void main(String[] args) {
        WriteTest a2 = new WriteTest();

        //电脑d盘中的abc.txt 文档
        String filePath = "D:/abc.txt" ;

        //要写入的内容
        String content = "今天是2017/1/9,天气很好" ;
        a2.writeFile( filePath , content  ) ;

    }

    /**
     * 根据文件路径创建输出流
     * @param filePath ： 文件的路径
     * @param content : 需要写入的内容
     */
    public void writeFile( String filePath , String content ){
        FileOutputStream fos = null ;
        try {
            //1、根据文件路径创建输出流
            fos  = new FileOutputStream(filePath, true);

            //2、把string转换为byte数组；
            byte[] array = content.getBytes() ;
            //3、把byte数组输出；
            fos.write( array );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if ( fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
