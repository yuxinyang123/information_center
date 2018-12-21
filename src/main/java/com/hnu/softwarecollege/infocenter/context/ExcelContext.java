package com.hnu.softwarecollege.infocenter.context;

import com.hnu.softwarecollege.infocenter.entity.po.AvgPo;
import com.hnu.softwarecollege.infocenter.mapper.AvgPoMapper;
import com.hnu.softwarecollege.infocenter.poi.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ExcelContext
 * @Description 将解析到的Excel表格的内容存入到数据库
 * @Author liu
 * @Date 2018/12/21 9:16
 * @Version 1.0
 **/
@Component
@Slf4j
public class ExcelContext implements InitializingBean {
    @Resource
    AvgPoMapper avgPoMapper;
    @Override
    public void afterPropertiesSet(){
        try{
            int size = selectAll();
            if(size!=0){
                avgPoMapper.deleteAll();
            }
            int count = insertDB();
            if(count>=7){
                log.info("插入成功");
            }else{
                log.error("插入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 在插入前先查看数据库，有数据就先删除
     * @Date 2018/12/21 9:49
     * @Param []
     * @return java.util.List<com.hnu.softwarecollege.infocenter.entity.po.AvgPo>
     **/
    public int selectAll(){
        List<AvgPo> list = avgPoMapper.findAll();
        int size = list.size();
        return size;
    }

    /*
     * @Author 刘亚双
     * @Description //调用方法获取数据，并存入数据库
     * @Date 2018/12/21 9:19
     * @Param []
     * @return void
     **/
    public int insertDB() throws Exception{
        Score score = new Score();
        score.averageScore();
        AvgPo avgPo_one = new AvgPo("1班",score.getClassoneavg());
        AvgPo avgPo_two = new AvgPo("2班",score.getClasstwoavg());
        AvgPo avgPo_three = new AvgPo("3班",score.getClassthravg());
        AvgPo avgPo_four = new AvgPo("4班",score.getClassfouavg());
        AvgPo avgPo_five = new AvgPo("5班",score.getClassfivavg());
        AvgPo avgPo_six = new AvgPo("6班",score.getClasssixavg());
        AvgPo avgPo_seven = new AvgPo("7班",score.getClasssevavg());
        AvgPo avgPo_eight = new AvgPo("8班",score.getClasseigavg());
        int one =avgPoMapper.insertSelective(avgPo_one);
        int two =avgPoMapper.insertSelective(avgPo_two);
        int three = avgPoMapper.insertSelective(avgPo_three);
        int four = avgPoMapper.insertSelective(avgPo_four);
        int five = avgPoMapper.insertSelective(avgPo_five);
        int six = avgPoMapper.insertSelective(avgPo_six);
        int seven = avgPoMapper.insertSelective(avgPo_seven);
        int eight = avgPoMapper.insertSelective(avgPo_eight);
        int sum = one+two+three+four+five+six+seven+eight;
        return sum;
    }
}
