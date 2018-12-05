package com.hnu.softwarecollege.infocenter.util;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JsonUtil
 * @Description TODO 对Json 对象的处理
 * @Author liu
 * @Date 2018/12/3 14:51
 * @Version 1.0
 **/
public class JsonUtil {
    /*
     * @Author 刘亚双
     * @Description //TODO 对json数据 星期的处理
     * @Date 2018/12/4 16:20
     * @Param [weeks]
     * @return java.lang.String
     **/
    public static String weekutil(String weeks){
        int len = weeks.length();
        String week = weeks.substring(1,len-1);
        return week;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 对json数据 上课时间的处理
     * @Date 2018/12/4 16:20
     * @Param [time]
     * @return java.lang.String
     **/
    public static String timeutil(String time){
        int len = time.length();
        String start;
        String end;
        if(len>5) {
            start = time.substring(1,3);
            end = time.substring(4,len-1);
        }
        else{
            start = time.substring(1,2);
            end = time.substring(3,len-1);
        }
        return start+"|"+end;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 对json数据，课程信息的处理
     * @Date 2018/12/4 16:21
     * @Param [classs]
     * @return java.lang.String
     **/
    public static String classutil(String classs){
        String[] cl = classs.split("\\ ");
        String weeksstart;
        String weeksend;
        String name = cl[0].substring(1,cl[0].length()-1);
        String weeks = cl[1].substring(3,cl[1].length()-1);
        if(weeks.length()>4){
            weeksstart = weeks.substring(0,2);
            weeksend = weeks.substring(3,weeks.length());
        }else{
            weeksstart = weeks.substring(0,1);
            weeksend = weeks.substring(2,weeks.length());
        }
        String address = cl[3].substring(5,cl[3].length());
        String teacher = cl[4].substring(3,cl[4].length());
        return name+"|"+weeksstart+"|"+weeksend+"|"+address+"|"+teacher;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 将json数据存入整合方便存入
     * @Date 2018/12/4 16:21
     * @Param [jsonNode]
     * @return java.util.List<java.lang.String>
     **/
    public static List<String> Listutil(JsonNode jsonNode){
        String week ="";
        String times ="";
        List<String> list = new ArrayList<String>();
        for(int timenum=1;timenum<=jsonNode.size();timenum++){
            if(timenum==1){
                week = weekutil(jsonNode.get("week").toString());
            }else if(jsonNode.get("time"+timenum)!=null){
                times = timeutil(jsonNode.get("time"+timenum).toString());
            }else if(jsonNode.get("class"+(timenum-1))!=null){
                String classes = week+"|"+times+"|"+classutil(jsonNode.get("class"+(timenum-1)).toString());
                list.add(classes);
            }
        }
        return list;
    }
}
