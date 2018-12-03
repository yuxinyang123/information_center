package com.hnu.softwarecollege.infocenter.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.mapper.CenterDegreePoMapper;
import com.hnu.softwarecollege.infocenter.service.CenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CenterServiceImpl
 * @Description TODO
 * @Author liu
 * @Date 2018/11/26 8:55
 * @Version 1.0
 **/
@Service
@Slf4j

public class CenterServiceImpl implements CenterService {
    /*
     * @Author 刘亚双
     * @Description //TODO 执行 python 脚本 获取输入流，将 json 字符串返回
     * @Date 2018/11/28 14:19
     * @Param [Id, password]
     * @return java.lang.String
     **/
    @Override
    public String getGrade(String Id, String password) {

        String[] arg = new String[]{"python", "C:\\Users\\14832\\Desktop\\information_center-feature-spider\\spider\\main.py",Id,password};
        Process process =null;
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
            process.waitFor();
        }catch(IOException e ){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return result;
    }
    @Resource
    CenterDegreePoMapper centerDegreePoMapper;
    /*
     * @Author 刘亚双
     * @Description //TODO  解析json 格式的数据,获取“GRADE”数组的信息，转化为CenterDegreePo 实体类存入数据库
     * @Date 2018/11/28 14:24
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo
     **/
    @Override
    public List<CenterDegreePo> transform(String jsonStr) {
        List<CenterDegreePo> l = new ArrayList<CenterDegreePo>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonStr);
            String grade = jsonNode.get("GRADE").toString();
            JsonNode gradeJsonNode = mapper.readTree(grade);
            //UserPo userPo = ThreadContext.getUserContext();
            for(int i =0;i<gradeJsonNode.size();i++){
                String s = gradeJsonNode.get(i).toString();
                CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
                centerDegreePoMapper.insertSelective(centerDegreePo);
                l.add(i,centerDegreePo);
                //centerDegreePo.setDegreeUserkey(userPo.getUserId());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return l;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 执行 python 脚本 进行成绩分析
     * @Date 2018/11/30 17:12
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String getGradeForeast(String studentId,String courseType,String testType,String gainCerdit) {
        String[] arg = new String[]{"python","C:\\Users\\14832\\Desktop\\test1\\Predict_Application_local.py",studentId,courseType,testType,gainCerdit};
        Process process =null;
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
        }catch(IOException e){
            log.error("不能执行");
            e.printStackTrace();
        }catch (InterruptedException e){
            log.error("中断");
        }
        return result;
    }

    @Override
    public String getCourseTable(String number, String password) {
        return null;
    }

    @Override
    public String getHotPot() {
        return null;
    }
}
