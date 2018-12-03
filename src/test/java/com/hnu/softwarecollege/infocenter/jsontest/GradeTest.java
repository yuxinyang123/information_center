package com.hnu.softwarecollege.infocenter.jsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName GradeTest
 * @Description TODO
 * @Author liu
 * @Date 2018/11/26 23:31
 * @Version 1.0
 **/
public class GradeTest {
    public static void main(String args[]) throws Exception{
        //String a ="2016011372 liu1996.";
        String id = "2016011372";
        String password = "liu1996.";
        String[] arg = new String[]{"python", "C:\\Users\\14832\\Desktop\\information_center-feature-spider\\spider\\main.py", id, password};
        Process process = null;
        String result="";
        try {
            process = Runtime.getRuntime().exec(arg);
            InputStreamReader ir = new InputStreamReader(process.getInputStream(),"GBK");
            BufferedReader bufferedReader = new BufferedReader(ir);
            String line;
            while((line=bufferedReader.readLine())!=null){
                result+=line;
            }
            ir.close();
            int re = process.waitFor();
            System.out.println(result);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(result);
            String grade = jsonNode.get("GRADE").toString();
            System.out.println(grade);
            System.out.println("---------------------------------------------------------");
            JsonNode jsonNode1 = mapper.readTree(grade);
           /* String s = jsonNode1.get(0).toString();
            CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
            System.out.println(centerDegreePo);*/


           /* for(int i = 0;i<jsonNode1.size();i++){
                String s = jsonNode1.get(i).toString();
                CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
            }*/

            String coursetable = jsonNode.get("CLASS").toString();
            JsonNode courseJsonNode = mapper.readTree(coursetable);
            //周一
            String monday = courseJsonNode.get("Monday").toString();
            JsonNode mondayJsonNode = mapper.readTree(monday);
            int mondaylen = mondayJsonNode.size();
            for(int timenum=1;timenum<mondaylen;timenum++){
                if(timenum==1){
                    String week = JsonUtil.weekutil(mondayJsonNode.get("week").toString());
                    System.out.println(week);
                }else if(mondayJsonNode.get("time"+timenum).toString()!=null){
                    String time = JsonUtil.timeutil(mondayJsonNode.get("time"+timenum).toString());
                    System.out.println(time);
                }else if(mondayJsonNode.get("class"+timenum).toString()!=null){
                    String classes = JsonUtil.classutil(mondayJsonNode.get("class"+timenum).toString());
                    System.out.println(classes);
                }
            }

            /*String Class= jsonNode.get("CLASS").toString();
            System.out.println(Class);
            System.out.println("==========================================================================");
            //将获取的ClASS 对象的内容转换为类 存入到数据库中
            JsonNode jsonNode2 = mapper.readTree(Class);
            String monday = jsonNode2.get("Monday").toString();
            System.out.println(monday);
            JsonNode jsonNode3 = mapper.readTree(monday);*/

            /*int classlen = jsonNode3.size();
            System.out.println(classlen);
            String w = jsonNode3.get("week").toString();
            int wl = w.length();
            String w1 = w.substring(1,wl-1);
            System.out.println(w1);
            String week = jsonNode3.get("time2").toString();
            String time2s = week.substring(1,2);
            String time2e = week.substring(3,week.length()-1);
            System.out.println(time2s);
            System.out.println(time2e);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            String weeks = jsonNode3.get("class2").toString();
            System.out.println(weeks);
            System.out.println("------------------------------------------------------");
            String[] aa = weeks.split("\\ ");
            for(int i = 0;i<aa.length;i++){
                System.out.println(aa[i]);
            }
            String name = aa[0];
            String week1 = aa[1];
            int len = week1.length();
            String sub = week1.substring(3,len-1);
            System.out.println(sub);
            int len1 = sub.length();
            String start = sub.substring(0,1);
            String end = sub.substring(2,len1);
            System.out.println(start);
            System.out.println(end);*/
        } catch (IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

/*@JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("term")
    private String degreeTerm;
    @JsonProperty("className")
    private String degreeClassname;
    @JsonProperty("classNature")
    private String degreeClassnature;
    @JsonProperty("credit")
    private Double degreeCredit;
    @JsonProperty("grade")
    private Integer degreeGrade;
    @JsonProperty("PerformancePoint")
    private Double degreePerformancepoint;
    @JsonProperty("testNature")
    private String degreeTestnature;
    @JsonProperty("studentId")
    private Integer degreeStudentid;
    @JsonProperty("stuName")
    private String degreeStudentname;
 **/

