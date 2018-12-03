package com.hnu.softwarecollege.infocenter.jsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;

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
    public static void main(String args[]) {
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


            for(int i = 0;i<jsonNode1.size();i++){
                String s = jsonNode1.get(i).toString();
                CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
            }

            String Class= jsonNode.get("CLASS").toString();
            System.out.println(Class);
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

