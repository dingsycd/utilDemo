package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        File fileSource = new File("D:\\项目交接\\南京项目资料\\girFile");
//        String path = "D:\\项目交接\\南京项目资料\\girFile";
//        List<File> fileList = new ArrayList<File>();
//        getFiles(fileList, path);
//        System.out.println(fileList.toString());
//        File[] file1 = fileSource.listFiles();
        String url = "http://192.168.39.239:8080/api/v2/recordings/00AG4FLN7C9VLDT3AONAHG5AES00001F/play/d1f83ac3-c6f0-484a-a0a6-470a435e185e.mp3";
        String[] strings = url.split("/");
        String fileName = strings[strings.length-1];
//        for (int i = 0; i < file1.length;i++){
//            File[] file2 = file1[i].listFiles();
//            for (int j = 0; j< file2.length;j++){
//                File[] file3 = file2[j].listFiles();
//                for (int k = 0;k<file3.length;k++){
//                    File[] file4 = file3[k].listFiles();
//                    for (int m = 0;m<file4.length;m++){
//                        long lastModifiedTime = file4[m].lastModified();
//                        Date dateTime = new Date(lastModifiedTime);
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(dateTime);
//                        System.out.println(file4[m].getPath() + "时间：" + dateTime.toString());
//                    }
//
//                }
//            }
////            if (files[i].isFile()){
////                long lastModifiedTime = files[i].lastModified();
////                Date dateTime = new Date(lastModifiedTime);
////                System.out.println(files[i].getPath() + "时间：" + dateTime.toString());
////            }
//        }


    }

    /**
     * 遍历文件/文件夹 - 函数
     * [String]path        文件路径
     */
    private static void recursiveFiles(String path){

        // 创建 File对象
        File file = new File(path);

        // 取 文件/文件夹
        File files[] = file.listFiles();

        // 对象为空 直接返回
        if(files == null){
            return;
        }

        // 目录下文件
        if(files.length == 0){
            System.out.println(path + "该文件夹下没有文件");
        }

        // 存在文件 遍历 判断
        for (File f : files) {

            // 判断是否为 文件夹
            if(f.isDirectory()){

                System.out.print("文件夹: ");
                System.out.println(f.getAbsolutePath());

                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());


                // 判断是否为 文件
            } else if(f.isFile()){

                System.out.print("文件: ");

                System.out.println(f.getAbsolutePath());

            } else {
                System.out.print("未知错误文件");
            }

        }

    }


    private static void getFiles(List<File> fileList, String path) {
        File[] allFiles = new File(path).listFiles();
        for (int i = 0; i < allFiles.length; i++) {
            File file = allFiles[i];

            if (file.isFile()) {
                fileList.add(file);
            } else  {
                getFiles(fileList, file.getAbsolutePath());
            }
        }
    }
}
