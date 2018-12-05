package com.hnu.softwarecollege.infocenter.schedutask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName schedudemo
 * @Description TODO
 * @Author wang
 * @Date 2018/12/3 9:51
 * @Version 1.0
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class schedudemo {

    @Resource
    public ObjectMapper mapper;

    @Test
    public void tests(){

        runWeiBoClawer();
    }

    public List<HotsPotPo> runWeiBoClawer(){
        //python脚本路径
        String[] arg = new String[]{"python","D:\\project\\information_center\\spider\\weibohot-clawer.py"};
        List<HotsPotPo> hotsPotPoList = null;
        Process process = null;
        try {
            //执行脚本文件
            process = Runtime.getRuntime().exec(arg);
            //IO流输出
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(),"GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //将json字符串存入String类型中
            String arrjson = bufferedReader.readLine();
            //System.out.println(arrjson);

            hotsPotPoList = mapper.readValue(arrjson,new TypeReference<List<HotsPotPo>>(){});
//            for(HotsPotPo po:hotsPotPoList){
//                log.info("{}",po);
//            }
            for(HotsPotPo po:hotsPotPoList){
                log.info(po.getHotspotTitle());
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            log.error("调用Python脚本错误");
            e.printStackTrace();
        }
        return hotsPotPoList;
    }
}