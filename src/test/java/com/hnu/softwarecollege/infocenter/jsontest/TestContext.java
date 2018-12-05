package com.hnu.softwarecollege.infocenter.jsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName TestContext
 * @Description TODO
 * @Author liu
 * @Date 2018/11/21 22:03
 * @Version 1.0
 **/
public class TestContext {

    public static void main(String args[]) throws IOException {
        String jsonstring = "{\"time\":\"2018-11-21 19:51:26\",\"cityInfo\":{\"city\":\"天津市\",\"cityId\":\"101030100\",\"parent\":\"天津\",\"updateTime\":\"19:35\"},\"date\":\"20181121\",\"message\":\"Success !\",\"status\":200,\"data\":{\"shidu\":\"44%\",\"pm25\":26.0,\"pm10\":56.0,\"quality\":\"良\",\"wendu\":\"4\",\"ganmao\":\"极少数敏感人群应减少户外活动\",\"yesterday\":{\"date\":\"20日星期二\",\"sunrise\":\"06:58\",\"high\":\"高温 11.0℃\",\"low\":\"低温 1.0℃\",\"sunset\":\"16:54\",\"aqi\":193.0,\"fx\":\"北风\",\"fl\":\"<3级\",\"type\":\"阴\",\"notice\":\"不要被阴云遮挡住好心情\"},\"forecast\":[{\"date\":\"21日星期三\",\"sunrise\":\"06:59\",\"high\":\"高温 9.0℃\",\"low\":\"低温 0.0℃\",\"sunset\":\"16:54\",\"aqi\":38.0,\"fx\":\"东北风\",\"fl\":\"3-4级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"22日星期四\",\"sunrise\":\"07:00\",\"high\":\"高温 10.0℃\",\"low\":\"低温 1.0℃\",\"sunset\":\"16:53\",\"aqi\":45.0,\"fx\":\"无持续风向\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"愿你拥有比阳光明媚的心情\"},{\"date\":\"23日星期五\",\"sunrise\":\"07:01\",\"high\":\"高温 10.0℃\",\"low\":\"低温 2.0℃\",\"sunset\":\"16:53\",\"aqi\":84.0,\"fx\":\"西南风\",\"fl\":\"<3级\",\"type\":\"多云\",\"notice\":\"阴晴之间，谨防紫外线侵扰\"},{\"date\":\"24日星期六\",\"sunrise\":\"07:02\",\"high\":\"高温 11.0℃\",\"low\":\"低温 1.0℃\",\"sunset\":\"16:52\",\"aqi\":95.0,\"fx\":\"西南风\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"愿你拥有比阳光明媚的心情\"},{\"date\":\"25日星期日\",\"sunrise\":\"07:03\",\"high\":\"高温 13.0℃\",\"low\":\"低温 2.0℃\",\"sunset\":\"16:52\",\"aqi\":191.0,\"fx\":\"东南风\",\"fl\":\"<3级\",\"type\":\"晴\",\"notice\":\"愿你拥有比阳光明媚的心情\"}]}}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonstring);
        System.out.println("-------"+jsonNode.get("cityInfo"));
        System.out.println("-------"+jsonNode.get("cityInfo").get("cityId"));
        System.out.println("-------"+jsonNode.get("cityInfo").get("city"));

        String cityInfo = jsonNode.get("cityInfo").toString();
        int len = cityInfo.length();
        System.out.println(cityInfo.length());
        String cityInfo1 = cityInfo.substring(1,len-1);
        System.out.println(cityInfo1);
        System.out.println("---------------------------------------------------------");

        String datejson = jsonNode.get("data").toString();
        JsonNode nodedate = mapper.readTree(datejson);
        String tempu = nodedate.get("wendu").toString();
        //String s1 = "\"wendu\"";
        String wendu = ","+"\"wendu\""+":"+tempu;
        System.out.println(wendu);
        cityInfo1+=wendu;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++===");
        System.out.println("-------"+nodedate.get("forecast").get(0));
        System.out.println("-----------------------------------------------------------");
        String today = nodedate.get("forecast").get(0).toString();
        int todaylen = today.length();
        System.out.println(today.length());
        String head = today.substring(0,1);
        String foot = today.substring(1,todaylen);

        System.out.println("-----------------------------------------------------------");
        String result = head+cityInfo1+","+foot;
        System.out.println(result);
    }
}
