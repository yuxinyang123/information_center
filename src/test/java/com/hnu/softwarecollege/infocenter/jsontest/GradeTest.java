package com.hnu.softwarecollege.infocenter.jsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        String[] arg = new String[]{"python", "E:\\information_center\\src\\main\\resources\\spider\\main.py", id, password};
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
            String s = jsonNode1.get(0).toString();
            System.out.println(s);
            CenterDegreePo centerDegreePo= mapper.readValue(s,CenterDegreePo.class);
            System.out.println(centerDegreePo);


           /* for(int i = 0;i<jsonNode1.size();i++){
                String s = jsonNode1.get(i).toString();
                CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
            }*/
            String coursetable = jsonNode.get("CLASS").toString();
            System.out.println(coursetable);
            JsonNode courseJsonNode = mapper.readTree(coursetable);

            //周一
            String monday = courseJsonNode.get("Friday").toString();
            JsonNode mondayJsonNode = mapper.readTree(monday);
            String weektemp="";
            List<String> mondaylist = new ArrayList<>();
            int mondaylen = mondayJsonNode.size();
            //System.out.println(mondaylen);
            String timetemp="";
            for(int timenum=1;timenum<=mondaylen;timenum++){
                if(timenum==1){
                    String week = JsonUtil.weekutil(mondayJsonNode.get("week").toString());
                    System.out.println(week);
                    weektemp =week;
                    //syllabusPo.setSyllabusWeek(week);
                }else if(mondayJsonNode.get("time"+timenum)!=null){
                    String time = JsonUtil.timeutil(mondayJsonNode.get("time"+timenum).toString());
                    System.out.println(time);
                    timetemp=time;
                    /*String [] t = time.split("\\|");
                    syllabusPo.setSyllabusStartpart(Integer.parseInt(t[0]));
                    syllabusPo.setSyllabusEndpart(Integer.parseInt(t[1]));*/
                }else if (mondayJsonNode.get("class"+(timenum-1))!=null){
                    //System.out.println(mondayJsonNode.get("class"+(timenum-1)));
                    String classes = JsonUtil.classutil(mondayJsonNode.get("class"+(timenum-1)).toString());
                    String classestemp = weektemp+"|"+timetemp+"|"+classes;
                    mondaylist.add(classestemp);
                    System.out.println(classestemp);

                   /* mondaylist.add(classes);
                    String[] c = classes.split("\\|");
                    syllabusPo.setSyllabusClassname(c[0]);
                    syllabusPo.setSyllabusStartweek(Integer.parseInt(c[1]));
                    syllabusPo.setSyllabusEndweek(Integer.parseInt(c[2]));
                    syllabusPo.setSyllabusClassroom(c[3]);
                    syllabusPo.setSyllabusTeacher(c[4]);*/
                }
            }
            System.out.println(mondaylist);
            System.out.println("==============================================================================");
            System.out.println(mondaylist.size());
            /*for(int i =0;i<mondaylist.size();i++){
                String[] t = mondaylist.get(i).split("\\|");
                SyllabusPo syllabusPo = new SyllabusPo(t[3],Integer.parseInt(t[4]),Integer.parseInt(t[5]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),t[0],t[6],t[7],null);
                System.out.println(syllabusPo);
            }*/

            /*syllabusPo.setSyllabusWeek(t[0]);
            syllabusPo.setSyllabusStartpart(Integer.parseInt(t[1]));
            syllabusPo.setSyllabusEndpart(Integer.parseInt(t[2]));
            syllabusPo.setSyllabusClassname(t[3]);
            syllabusPo.setSyllabusStartweek(Integer.parseInt(t[4]));
            syllabusPo.setSyllabusEndweek(Integer.parseInt(t[5]));
            syllabusPo.setSyllabusClassroom(t[6]);
            syllabusPo.setSyllabusTeacher(t[7]);*/


            /*syllabusPo.setSyllabusWeek(mondaylist.get(0));
            String[] t =mondaylist.get(1).split("\\|");
            syllabusPo.setSyllabusStartpart(Integer.parseInt(t[0]));
            syllabusPo.setSyllabusEndpart(Integer.parseInt(t[1]));
            String[] c = mondaylist.get(2).split("\\|");
            syllabusPo.setSyllabusClassname(c[0]);
            syllabusPo.setSyllabusStartweek(Integer.parseInt(c[1]));
            syllabusPo.setSyllabusEndweek(Integer.parseInt(c[2]));
            syllabusPo.setSyllabusClassroom(c[3]);
            syllabusPo.setSyllabusTeacher(c[4]);
            System.out.println(syllabusPo);
*/
        } catch (IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch (NullPointerException e){
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

