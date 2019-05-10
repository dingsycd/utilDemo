package fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {



    public static void main(String[] args) {
        String str = "{\"statusCode\":0,\"recording\":{\"id\":\"00AG4FLN7C9VLDT3AONAHG5AES00001F\",\"callerPhoneNumber\":\"80060\",\"dialedPhoneNumber\":\"70005\",\"startTime\":\"2014-08-25T09:05:33.000+0000\",\"stopTime\":\"2014-08-25T09:05:44.000+0000\",\"mediaFiles\":[{\"startTime\":\"2014-08-25T09:05:33.000+0000\",\"stopTime\":\"2014-08-25T09:05:44.000+0000\",\"callUUID\":\"00AG4FLN7C9VLDT3AONAHG5AES00001F\",\"mediaId\":\"00AG4FLN7C9VLDT3AONAHG5AES00001F_80004_20001_80060_70005_2014-08-25_09-05-32_-007B013F-10003AAA-00000001.mp3\",\"type\":\"audio/mp3\",\"duration\":\"11\",\"tenant\":\"Resources\",\"ivrprofile\":\"DefaultIVR\",\"size\":\"45\",\"parameters\":{\"id\":\"00AG4FLN7C9VLDT3AONAHG5AES00001F_80004_20001_80060_70005_2014-08-25_09-05-32_\",\"dnis\":\"70005\",\"connId\":\"006d024f45658028\",\"callUuid\":\"00AG4FLN7C9VLDT3AONAHG5AES00001F\",\"ani\":\"80060\",\"dateTime\":\"2014-08-25T09:05:32Z\",\"agentId\":\"20001\",\"recordDN\":\"80004\",\"sipsAppName\":\"SIPServer\"},\"partitions\":[],\"accessgroups\":[],\"mediaUri\":\"http://192.168.39.239:8080/api/v2/recordings/00AG4FLN7C9VLDT3AONAHG5AES00001F/play/d1f83ac3-c6f0-484a-a0a6-470a435e185e.mp3\"}],\"eventHistory\":[],\"region\":\"us\"}}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject recording = JSON.parseObject(jsonObject.getString("recording"));
        JSONArray mediaFiles = JSON.parseArray(recording.getString("mediaFiles"));
        JSONObject mediaFile = JSONObject.parseObject(mediaFiles.get(0).toString());
        String mediaUri = mediaFile.getString("mediaUri");
        System.out.println("mediaUri值是："+mediaUri);

//        JSONArray mediaFiles = JSON.parseArray()
//        JSONObject jo2 = mediaFiles.getJSONObject(mediaFiles.size()-1);
//        Object mediaUri = jo2.get("mediaUri");
//        System.out.println(mediaUri);
    }



}
