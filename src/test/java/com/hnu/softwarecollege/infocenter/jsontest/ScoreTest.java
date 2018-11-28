package com.hnu.softwarecollege.infocenter.jsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.nio.charset.Charset;

/**
 * @ClassName ScoreTest
 * @Description TODO
 * @Author liu
 * @Date 2018/11/27 22:38
 * @Version 1.0
 **/
public class ScoreTest {
    public static void main(String args[]){
        try {
            String jsonScore = FileUtils.readFileToString(ResourceUtils.getFile("grade.json"), Charset.forName("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonScore);
            int len = jsonNode.size();
            System.out.println(len);
            for(int i =0 ;i<jsonNode.size();i++) {

                String term = jsonNode.get(i).get("term").toString();
                String className = jsonNode.get(i).get("className").toString();
                String classNature = jsonNode.get(i).get("classNature").toString();
                String credit = jsonNode.get(i).get("credit").toString();
                String grade = jsonNode.get(i).get("grade").toString();
                System.out.println(term+className+classNature+credit+grade);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
