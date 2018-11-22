package com.hnu.softwarecollege.infocenter.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@Slf4j
public class HttpRequestUtil {
    public static String getJsonContent(String city_code){
        String result="";
        try {
            String city = "http://t.weather.sojson.com/api/weather/city/"+city_code;
           // log.info(city);
            URL url = new URL(city);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setConnectTimeout(3000);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");
            int respCode = httpCon.getResponseCode();
            if(respCode==200){
               result = ConvertStream2Json(httpCon.getInputStream());
            }
        }catch(MalformedURLException e){
            log.info("url参数异常");
        }catch (IOException e){
            log.info("读写流异常");
        }
        return result;
    }
    private static String ConvertStream2Json(InputStream inputStream) throws  IOException{
        String jsonStr = "";
        byte buffer[] = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        int len = 0;
        try {
            while((len=inputStream.read(buffer))!=-1){
                String s = new String(buffer,0,len,"UTF-8");
                stringBuffer.append(s);
            }
            jsonStr = stringBuffer.toString();
            //log.info(jsonStr);
            System.out.println();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(jsonStr);
        String result = ChoiceJson(jsonStr);
        return result;
    }
    /*
     * @Author 刘亚双
     * @Description //将两个json 格式的字符串拼接成一个
     * @Date 2018/11/22 0:27
     * @Param [jsonStr]
     * @return java.lang.String
     **/
    private static String ChoiceJson(String jsonStr) throws IOException{

        //System.out.println("1111111111111"+jsonStr);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonStr);
        String cityInfo = jsonNode.get("cityInfo").toString();
        int cityInfolen = cityInfo.length();

        String partcityInfo = cityInfo.substring(1,cityInfolen-1);
        //System.out.println("222222"+partcityInfo);

        String datajson = jsonNode.get("data").toString();
        JsonNode nodedata = mapper.readTree(datajson);
        String today = nodedata.get("forecast").get(0).toString();
        int todaylen = today.length();
        String head = today.substring(0,1);
        String foot = today.substring(1,todaylen);
        String result = head+partcityInfo+","+foot;
        //System.out.println("333333"+result);
        return result;
    }
}
