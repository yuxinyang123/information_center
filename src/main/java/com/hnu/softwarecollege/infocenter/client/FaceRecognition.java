package com.hnu.softwarecollege.infocenter.client;

import com.baidu.aip.face.AipFace;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: camerademo
 * @description: //TODO
 * @author: ying
 * @create: 2018-12-07 23:39
 **/
@Component
@Slf4j
public class FaceRecognition {

    private static final String appId = "15063715";
    private static final String apiKey = "8hwj2hPUzKz7ie9wEy8hwjK0";
    private static final String secretKey = "nn1Fv9viQOeLC88WloiK2jWAyw7G8DAh";

    private static AipFace aipFace = new AipFace(appId, apiKey, secretKey);

    public static JSONObject authFace(String base64, String userId) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        if (userId != null)
            options.put("user_id", userId);
        options.put("max_user_num", "1");

        String image = base64;
        String imageType = "BASE64";
        String groupIdList = "group1";

        JSONObject res = aipFace.search(image, imageType, groupIdList, options);
        return res;
    }

    public static JSONObject authFace(String base64){
        return authFace(base64,null);
    }

    public static JSONObject addUser(String base64, String userId, String userInfo) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", userInfo);
        options.put("quality_control", "NONE");
        options.put("liveness_control", "NONE");

        String image = base64;
        String imageType = "BASE64";
        String groupId = "group1";

        JSONObject res = aipFace.addUser(image, imageType, groupId, userId, options);
        return res;
    }

    public static JSONObject detect(String base64, String maxFaceNum, String faceType) {

        HashMap<String, String> optinons = new HashMap<String, String>();
        optinons.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,quality,facetype");
        optinons.put("max_face_num", maxFaceNum);
        optinons.put("face_type", faceType);

        JSONObject object = aipFace.detect(base64, "BASE64", optinons);
        log.info("{}", object.toString());
        return object;
    }

    public static JSONObject detect(String base64) {
        return detect(base64, "1", "LIVE");
    }

}
