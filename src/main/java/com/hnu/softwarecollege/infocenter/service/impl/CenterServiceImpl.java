package com.hnu.softwarecollege.infocenter.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.mapper.CenterDegreePoMapper;
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
        String studentid ="";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonStr);
            String grade = jsonNode.get("GRADE").toString();
            JsonNode gradeJsonNode = mapper.readTree(grade);
            //UserPo userPo = ThreadContext.getUserContext();
            studentid = gradeJsonNode.get(1).get("studentId").toString();
            for(int i =0;i<gradeJsonNode.size();i++){
                String s = gradeJsonNode.get(i).toString();
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
            int mondaylen = mondayJsonNode.size();
            for(int timenum=1;timenum<mondaylen;timenum++){
                if(timenum==1){
                    String weel = JsonUtil.weekutil(mondayJsonNode.get("week").toString());
                }else if(mondayJsonNode.get("time"+timenum).toString()!=null){
                    String time = JsonUtil.timeutil(mondayJsonNode.get("time"+timenum).toString());
                }else if(mondayJsonNode.get("class"+timenum).toString()!=null){
                    String classes = JsonUtil.classutil(mondayJsonNode.get("class"+timenum).toString());
                }
            }
            /*String monday_week = mondayJsonNode.get("week").toString();
            String monday_time2 = mondayJsonNode.get("time2").toString();
            String monday_time2_start = monday_time2.substring(1,2);
            String monday_time2_end = monday_time2.substring(3,monday_time2.length()-1);
            int monday_time2_s = Integer.parseInt(monday_time2_start);
            int monday_time2_e = Integer.parseInt(monday_time2_end);
            //class2
            String monday_class2 = mondayJsonNode.get("class2").toString();
            String[] monday_arr = monday_class2.split("// ");
            String monday_course_name = monday_arr[0].substring(1,monday_arr[0].length());
            String monday_course_weeks = monday_arr[1].substring(3,monday_arr[1].length()-1);
            String monday_course_weeks_start = monday_course_weeks.substring(0,1);
            String monday_course_weeks_end = monday_course_weeks.substring(2,monday_course_weeks.length());
            //上课地点
            String monday_course_dresss = monday_arr[3].substring(5,monday_arr[3].length());
            //教师
            String monday_course_teacher = monday_arr[4].substring(3,monday_arr[4].length());

            //class3
            String monday_class3 = mondayJsonNode.get("claas3").toString();
            String[] monday_class3_arr = monday_class3.split("// ");
            String monday_class3_name = monday_class3_arr[0].substring(1,monday_class3_arr[0].length());
            String monday_class3_weeks = monday_class3_arr[1].substring(3,monday_class3_arr[1].length()-1);
            String monday_class3_weeks_start = monday_class3_weeks.substring(0,2);
            String monday_class3_weeks_end = monday_class3_weeks.substring(3,monday_class3_weeks.length());
            String monday_class3_dress = monday_class3_arr[3].substring(5,monday_class3_arr[3].length());
            String monday_class3_teacher = monday_class3_arr[4].substring(3,monday_class3_arr[4].length());

            //time5
            String monday_time5 =mondayJsonNode.get("time5").toString();
            String monday_time5_start = monday_time5.substring(1,2);
            String monday_time5_end = monday_time5.substring(3,monday_time5.length()-1);

            //class5
            String monday_class5 = mondayJsonNode.get("class5").toString();
            String[] monday_class5_arr = monday_class5.split("// ");
            String monday_class5_name = monday_class5_arr[0].substring(1,monday_class5_arr[0].length()-1);
            String monday_class5_weeks = monday_class5_arr[1].substring(3,monday_class5_arr[1].length()-1);
            String monday_class5_weeks_start = monday_class5_weeks.substring(0,1);
            String monday_class5_weeks_end = monday_class5_weeks.substring(2,monday_class5_weeks.length());
            String monday_class5_dress =monday_class5_arr[3].substring(5,monday_class5_arr[3].length());
            String monday_class5_teacher = monday_class5_arr[4].substring(3,monday_class5_arr[4].length());
*/

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
            log.error("参数输入错误！");
            e.printStackTrace();
        }catch (InterruptedException e){
            log.error("中断");
        }
        return result;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 获取课表信息 解析后存入数据库
     * @Date 2018/12/3 9:18
     * @Param [jsonstr]
     * @return java.lang.String
     **/
    @Override
    public String getCourseTable() {
        return null;
    }

    /*
     * @Author 王子璇
     * @Description //TODO 执行 python 脚本 爬取微博热搜
     * @Date 2018/12/3 15:53
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String getHotPot() {
        return null;
    }
}
