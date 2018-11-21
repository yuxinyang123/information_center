package com.hnu.softwarecollege.infocenter.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@Slf4j
public class HttpRequestUtil {
    public static String getJsonContent(String city_code){
        try {
            String city = "http://t.weather.sojson.com/api/weather/city/"+city_code;
            URL url = new URL(city);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setConnectTimeout(3000);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");
            int respCode = httpCon.getResponseCode();
            if(respCode==200){
                return ConvertStream2Json(httpCon.getInputStream());
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
    private static String ConvertStream2Json(InputStream inputStream){
        String jsonStr = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, buffer.length);
            }
            jsonStr = new String(out.toByteArray());
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(jsonStr);
        return jsonStr;
    }
}
