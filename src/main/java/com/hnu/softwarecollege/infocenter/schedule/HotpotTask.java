package com.hnu.softwarecollege.infocenter.schedule;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;
import com.hnu.softwarecollege.infocenter.service.CenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName HotpotTask
 * @Description TODO
 * @Author wang
 * @Date 2018/12/3 16:35
 * @Version 1.0
 **/
@Slf4j
@EnableScheduling
@Configuration
public class HotpotTask {

//    private File weiboClawer = new File("spider/weibohot-clawer.py");
//    private String weiboClawerpath = weiboClawer.getAbsolutePath();
//    ClassPathResource resource = new ClassPathResource("spider/weibohot-clawer.py");
//    String weiboClawerpath = resource.getPath();
    String weiboClawerpath = "/home/spiderresource/weibohot-clawer.py";


    @Resource
    public ObjectMapper mapper;

    @Resource
    public CenterService centerService;

    @Scheduled(cron ="0 */30 * * * ?")
    public int runWeiBoClawer(){
        //python脚本路径

        String[] arg = new String[]{"python3",weiboClawerpath};
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
//            for(HotsPotPo po:hotsPotPoList){
//                log.info(po.getHotspotTitle());
//            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            log.error("调用Python脚本错误");
            e.printStackTrace();
        }

        centerService.updateHotspot(hotsPotPoList);

        return 1;
    }
}


