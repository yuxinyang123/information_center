//package com.hnu.softwarecollege.infocenter.excelTest;
//
//import com.hnu.softwarecollege.infocenter.entity.po.AvgPo;
//import com.hnu.softwarecollege.infocenter.mapper.AvgPoMapper;
//import com.hnu.softwarecollege.infocenter.poi.Score;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName ExcelTest
// * @Description TODO
// * @Author liu
// * @Date 2018/12/19 15:36
// * @Version 1.0
// **/
//@RunWith(SpringRunner.class)
//@Slf4j
//@SpringBootTest
//public class ExcelTest {
////    @Test
//    public void readExcel() throws Exception{
//        File file = new File("F:\\excel\\a.xlsx");
//        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
//        XSSFSheet hs = wb.getSheetAt(0);
//        int rowCount = hs.getLastRowNum();
//        /*XSSFRow xssfRow = hs.getRow(8);
//        int cellCount = xssfRow.getLastCellNum();
//        XSSFCell xssfCell = xssfRow.getCell(0);
//        xssfCell.setCellType(CellType.STRING);
//        System.out.println("rowCount"+rowCount+"cellCount"+cellCount);
//        System.out.println(xssfRow);
//        System.out.println("================");
//        System.out.println(xssfCell);*/
//        double sum = 0;
//        for(int i = 1 ;i<rowCount;i++){
//            XSSFRow xssfRow = hs.getRow(i);
//            XSSFCell classCell = xssfRow.getCell(2);
//            classCell.setCellType(CellType.STRING);
//            if(classCell.getStringCellValue().equals("16级1班")){
//                XSSFCell gradeCell = xssfRow.getCell(8);
//                gradeCell.setCellType(CellType.NUMERIC);
//                sum = sum + gradeCell.getNumericCellValue();
//            }
//        }
//        System.out.println("sum:"+sum);
//        double avg = sum/49;
//        System.out.println("avg:"+avg);
//    }
//
////    @Test
//    public void sorceTest() throws Exception{
//        File file = new File("C:\\Users\\14832\\Desktop\\score\\alltrem.xlsx");
//        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
//        XSSFSheet sheet = wb.getSheetAt(0);
//        int rowCount = sheet.getLastRowNum();
//        System.out.println(rowCount);
//        double sum = 0;
//        for(int i =2;i<rowCount;i++){
//            XSSFRow xssfRow = sheet.getRow(i);
//            XSSFCell classCell = xssfRow.getCell(19);
//            classCell.setCellType(CellType.STRING);
//            String flag = classCell.getStringCellValue();
//            if(flag.equals("16软件工程1班")){
//                XSSFCell xssfCell = xssfRow.getCell(10);
//                //xssfCell.setCellType(CellType.NUMERIC);
//                //double a = xssfCell.getNumericCellValue();
//                System.out.println(xssfCell);
//                System.out.println("======================");
//                double d = Double.parseDouble(xssfCell.getStringCellValue());
//                //System.out.println(a);
//                System.out.println(d);
//                System.out.println("======================");
//                sum = sum + d;
//            }
//        }
//        System.out.println("sum:"+sum);
//    }
//
//    @Resource
//    AvgPoMapper avgPoMapper;
//    @Test
//    public void test1() throws Exception{
//        Score score = new Score();
//        score.averageScore();
//        AvgPo avgPo_one = new AvgPo("1班",score.getClassoneavg());
//        AvgPo avgPo_two = new AvgPo("2班",score.getClasstwoavg());
//        AvgPo avgPo_three = new AvgPo("3班",score.getClassthravg());
//        AvgPo avgPo_four = new AvgPo("4班",score.getClassfouavg());
//        AvgPo avgPo_five = new AvgPo("5班",score.getClassfivavg());
//        AvgPo avgPo_six = new AvgPo("6班",score.getClasssixavg());
//        AvgPo avgPo_seven = new AvgPo("7班",score.getClasssevavg());
//        AvgPo avgPo_eight = new AvgPo("8班",score.getClasseigavg());
//        avgPoMapper.insertSelective(avgPo_one);
//        avgPoMapper.insertSelective(avgPo_two);
//        avgPoMapper.insertSelective(avgPo_three);
//        avgPoMapper.insertSelective(avgPo_four);
//        avgPoMapper.insertSelective(avgPo_five);
//        avgPoMapper.insertSelective(avgPo_six);
//        avgPoMapper.insertSelective(avgPo_seven);
//        avgPoMapper.insertSelective(avgPo_eight);
//    }
//
//    @Test
//    public void test2() throws Exception{
//        List<AvgPo> list = avgPoMapper.findFourSemester();
//        List<double[]> lists = new ArrayList<>();
//        for(int i =0;i<list.size();i++){
//            if(i<8){
//                lists.add(new double[]{1,i,list.get(i).getFengshu()});
//            }else if(i<16&&i>7){
//                lists.add(new double[]{2,i%8,list.get(i).getFengshu()});
//            }else if(i<24&&i>16){
//                lists.add(new double[]{3,i%8,list.get(i).getFengshu()});
//            }else{
//                lists.add(new double[]{4,i%8,list.get(i).getFengshu()});
//            }
//        }
//
//        System.out.println(lists);
//    }
//}
