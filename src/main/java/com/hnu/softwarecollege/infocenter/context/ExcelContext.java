package com.hnu.softwarecollege.infocenter.context;

import com.hnu.softwarecollege.infocenter.entity.po.AvgPo;
import com.hnu.softwarecollege.infocenter.mapper.AvgPoMapper;
import com.hnu.softwarecollege.infocenter.poi.FirstSemester;
import com.hnu.softwarecollege.infocenter.poi.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.io.File;

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
    private File firstFile = new File("excel/大一上.xlsx");
    private String firstPath = firstFile.getAbsolutePath();
    private File secondFile = new File("excel/大一.xlsx");
    private String secondPath = secondFile.getAbsolutePath();
    private File thirdFile = new File("excel/大二上.xlsx");
    private String thridPath = thirdFile.getAbsolutePath();
    private File fourthFile = new File("excel/大二.xlsx");
    private String fourthPath = fourthFile.getAbsolutePath();
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
            int first = insertDBFirst();
            int second = insertDBSecond();
            int third = insertDBThird();
            int fourth = insertDBFourth();
            int sum = first+second+third+fourth;
            if(sum>=28){
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
    /*
     * @Author 刘亚双
     * @Description //TODO 第一学期
     * @Date 2018/12/23 14:53
     * @Param []
     * @return int
     **/
    public int insertDBFirst() throws Exception{
        String semester = "第一学期";
        int count = method(firstPath,semester);
        return count;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 第二学期
     * @Date 2018/12/23 15:10
     * @Param []
     * @return int
     **/
    public int insertDBSecond() throws Exception{
        String semester = "第二学期";
        int count = method(secondPath,semester);
        return count;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 第三学期
     * @Date 2018/12/23 15:11
     * @Param []
     * @return int
     **/
    public int insertDBThird() throws Exception{
        String semester = "第三学期";
        int count = method(thridPath,semester);
        return count;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 第四学期
     * @Date 2018/12/23 15:12
     * @Param []
     * @return int
     **/
    public int insertDBFourth() throws Exception{
        String semester = "第四学期";
        int count = method(fourthPath,semester);
        return count;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 将插入数据库的方法提取出来
     * @Date 2018/12/23 15:13
     * @Param [path, semester]
     * @return int
     **/
    public int method(String path,String semester) throws Exception{
        FirstSemester firstSemester = new FirstSemester();
        firstSemester.avgFirstSemester(path);
        AvgPo avgPo = new AvgPo(semester,"一班",firstSemester.getClassoneavg());
        AvgPo avgPo1 = new AvgPo(semester,"二班",firstSemester.getClasstwoavg());
        AvgPo avgPo2 = new AvgPo(semester,"三班",firstSemester.getClassthravg());
        AvgPo avgPo3 = new AvgPo(semester,"四班",firstSemester.getClassfouavg());
        AvgPo avgPo4 = new AvgPo(semester,"五班",firstSemester.getClassfivavg());
        AvgPo avgPo5 = new AvgPo(semester,"六班",firstSemester.getClasssixavg());
        AvgPo avgPo6 = new AvgPo(semester,"七班",firstSemester.getClasssevavg());
        AvgPo avgPo7 = new AvgPo(semester,"八班",firstSemester.getClasseigavg());
        int one = avgPoMapper.insertSelective(avgPo);
        int two = avgPoMapper.insertSelective(avgPo1);
        int three = avgPoMapper.insertSelective(avgPo2);
        int four = avgPoMapper.insertSelective(avgPo3);
        int five = avgPoMapper.insertSelective(avgPo4);
        int six = avgPoMapper.insertSelective(avgPo5);
        int seven = avgPoMapper.insertSelective(avgPo6);
        int eight = avgPoMapper.insertSelective(avgPo7);
        return one+two+three+four+five+six+seven+eight;
    }
}
