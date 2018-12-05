package com.hnu.softwarecollege.infocenter.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.vo.CurriculumForm;
import com.hnu.softwarecollege.infocenter.mapper.CenterDegreePoMapper;
import com.hnu.softwarecollege.infocenter.mapper.SyllabusPoMapper;
import com.hnu.softwarecollege.infocenter.service.CenterService;
import com.hnu.softwarecollege.infocenter.util.JsonUtil;
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
     * @Description //TODO 根据学号 在数据库中进行查询，存在的话 返回数据 。不存在则 执行 python 脚本 获取输入流，将 json 字符串返回
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
    @Resource
    SyllabusPoMapper syllabusPoMapper;
    /*
     * @Author 刘亚双
     * @Description //TODO  解析json 格式的数据,获取“GRADE”数组的信息，转化为CenterDegreePo 实体类存入数据库 同时获取对应的课表信息 存入数据库
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
               System.out.println(s);
               CenterDegreePo centerDegreePo = mapper.readValue(s,CenterDegreePo.class);
               centerDegreePoMapper.insertSelective(centerDegreePo);
                l.add(i,centerDegreePo);
                //centerDegreePo.setDegreeUserkey(userPo.getUserId());
            }
            //获取课表信息  解析后存取数据库
            String coursetable = jsonNode.get("CLASS").toString();
            JsonNode courseJsonNode = mapper.readTree(coursetable);
            //周一
            String monday = courseJsonNode.get("Monday").toString();
            JsonNode mondayJsonNode = mapper.readTree(monday);
            List<String> mondaylist = JsonUtil.Listutil(mondayJsonNode);
            if(mondaylist!=null) {
                method(mondaylist);
            }
            //周二
            String tuesday = courseJsonNode.get("Tuesday").toString();
            JsonNode tuesdayJsonNode = mapper.readTree(tuesday);
            List<String> tuesdaylist = JsonUtil.Listutil(tuesdayJsonNode);
            if(tuesdaylist!=null) {
                method(tuesdaylist);
            }
            //周三
            String wednesday = courseJsonNode.get("Wednesday").toString();
            JsonNode wednesdayJsonNode = mapper.readTree(wednesday);
            List<String> wednesdaylist = JsonUtil.Listutil(wednesdayJsonNode);
            if(wednesdaylist!=null) {
                method(wednesdaylist);
            }
            //周四
            String thursday = courseJsonNode.get("Thursday").toString();
            JsonNode thursdayJsonNode = mapper.readTree(thursday);
            List<String> thursdaylist = JsonUtil.Listutil(thursdayJsonNode);
            if(thursday!=null) {
                method(thursdaylist);
            }
            //周五
            String friday = courseJsonNode.get("Friday").toString();
            JsonNode fridayJsonNode = mapper.readTree(friday);
            List<String> fridaylist = JsonUtil.Listutil(fridayJsonNode);
            if(fridaylist!=null) {
                method(fridaylist);
            }
            //周六
            String saturday = courseJsonNode.get("Saturday").toString();
            JsonNode saturJsonNode = mapper.readTree(saturday);
            List<String> saturdaylist = JsonUtil.Listutil(saturJsonNode);
            if(saturdaylist!=null) {
                method(saturdaylist);
            }
            //周日
            String sunday = courseJsonNode.get("Sunday").toString();
            JsonNode sundayJsonNode = mapper.readTree(sunday);
            List<String> sundaylist = JsonUtil.Listutil(sundayJsonNode);
            if(sundaylist!=null) {
                method(sundaylist);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch(NullPointerException e){

        }
        return l;
    }

    private void method(List<String> list) {
        for(int i =0;i<list.size();i++){
            Long key = 2L;
            String[] s = list.get(i).split("\\|");
            SyllabusPo syllabusPo = new SyllabusPo(null,s[3],Integer.parseInt(s[4]),Integer.parseInt(s[5]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),s[0],s[6],s[7],key);
            System.out.println(syllabusPo);
            syllabusPoMapper.insertSelective(syllabusPo);
        }
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
            log.error("参数输入错误！");
            e.printStackTrace();
        }catch (InterruptedException e){
            log.error("中断");
        }
        return result;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 从数据库中查询课表信息
     * @Date 2018/12/3 9:18
     * @Param [jsonstr]
     * @return java.lang.String
     **/
    @Override
    public List<SyllabusPo> getCourseTable(Long Userkey) {
        //Long Userkey = ThreadContext.getUserContext().getUserId();
        List<SyllabusPo> list = syllabusPoMapper.findAllByUserKey(Userkey);
        return list;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 自定义课表,插入到数据库中
     * @Date 2018/12/5 9:51
     * @Param [curriculumForm]
     * @return void
     **/
    @Override
    public void putCurriculum(CurriculumForm curriculumForm) {
        UserPo userPo = ThreadContext.getUserContext();
        Long userkey  = userPo.getUserId();
        SyllabusPo syllabusPo = new SyllabusPo(null,curriculumForm.getClassName(),curriculumForm.getStartWeek(),curriculumForm.getEndWeek(),curriculumForm.getStartPart(),curriculumForm.getEndPart(),curriculumForm.getWeek(),curriculumForm.getClassroom(),curriculumForm.getTeacher(),userkey);
        syllabusPoMapper.insertSelective(syllabusPo);
    }

    @Override
    public String getHotPot() {
        return null;
    }
}
