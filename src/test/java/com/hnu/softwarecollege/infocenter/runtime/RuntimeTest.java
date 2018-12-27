//package com.hnu.softwarecollege.infocenter.runtime;
//
//import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;
//import com.hnu.softwarecollege.infocenter.entity.vo.SyllabusVo;
//import com.hnu.softwarecollege.infocenter.mapper.SyllabusPoMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @program: infocenter
// * @description: //TODO
// * @author: ying
// * @create: 2018-12-06 20:21
// **/
//@RunWith(SpringRunner.class)
//@Slf4j
//@SpringBootTest
//public class RuntimeTest {
//    //    @Value("${classpath*:spider}")
//    File file = new File("spider/main.py");
//    String path = file.getAbsolutePath();
//
//    @Test
//    public void runtime() throws IOException {
//        Process process = Runtime.getRuntime().exec(new String[]{"python", path, "2016011349", "yxy18832781055"});
////        Process process = Runtime.getRuntime().exec("python main.py 2016011349 yxy18832781055");
////        log.info("{}",path);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
//        String str;
//        StringBuilder sb = new StringBuilder();
//        while ((str = bf.readLine()) != null) {
////            log.info("{}",str);
//            sb.append(str);
//        }
//        bf.close();
//        process.destroy();
//        log.info("{}", sb.toString());
//
////        process.destroy();
//    }
//    @Resource
//    SyllabusPoMapper syllabusPoMapper;
//    @Test
//    public void syllabusTest(){
//        Long userkey = 1l;
//        List<SyllabusPo> list = syllabusPoMapper.findAllByUserKey(userkey);
//        System.out.println(list);
//        System.out.println("===========================================================");
//        List<SyllabusPo> monlist = new ArrayList<>();
//        for(SyllabusPo syllabusPo:list){
//            if(syllabusPo.getSyllabusWeek().equals("星期一")){
//                monlist.add(syllabusPo);
//            }
//        }
//        System.out.println(monlist);
//        System.out.println("==========================================================================");
//        SyllabusVo syllabusVo = new SyllabusVo();
//        syllabusVo.set星期一(monlist);
//    }
//
//    /*@Resource
//    CommentPoMapper commentPoMapper;
//    @Test
//    public void commentTest(){
//        List<CommentVo> list = commentPoMapper.selectbyessayKet(1l);
//        System.out.println(list);
//    }*/
//}
