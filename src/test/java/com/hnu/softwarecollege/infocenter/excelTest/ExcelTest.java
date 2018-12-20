package com.hnu.softwarecollege.infocenter.excelTest;

import com.hnu.softwarecollege.infocenter.poi.Score;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName ExcelTest
 * @Description TODO
 * @Author liu
 * @Date 2018/12/19 15:36
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class ExcelTest {
    @Test
    public void readExcel() throws Exception{
        File file = new File("F:\\excel\\a.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet hs = wb.getSheetAt(0);
        int rowCount = hs.getLastRowNum();
        /*XSSFRow xssfRow = hs.getRow(8);
        int cellCount = xssfRow.getLastCellNum();
        XSSFCell xssfCell = xssfRow.getCell(0);
        xssfCell.setCellType(CellType.STRING);
        System.out.println("rowCount"+rowCount+"cellCount"+cellCount);
        System.out.println(xssfRow);
        System.out.println("================");
        System.out.println(xssfCell);*/
        double sum = 0;
        for(int i = 1 ;i<rowCount;i++){
            XSSFRow xssfRow = hs.getRow(i);
            XSSFCell classCell = xssfRow.getCell(2);
            classCell.setCellType(CellType.STRING);
            if(classCell.getStringCellValue().equals("16级1班")){
                XSSFCell gradeCell = xssfRow.getCell(8);
                gradeCell.setCellType(CellType.NUMERIC);
                sum = sum + gradeCell.getNumericCellValue();
            }
        }
        System.out.println("sum:"+sum);
        double avg = sum/49;
        System.out.println("avg:"+avg);
    }

    @Test
    public void sorceTest() throws Exception{
        File file = new File("C:\\Users\\14832\\Desktop\\score\\alltrem.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        System.out.println(rowCount);
        double sum = 0;
        for(int i =2;i<rowCount;i++){
            XSSFRow xssfRow = sheet.getRow(i);
            XSSFCell classCell = xssfRow.getCell(19);
            classCell.setCellType(CellType.STRING);
            String flag = classCell.getStringCellValue();
            if(flag.equals("16软件工程1班")){
                XSSFCell xssfCell = xssfRow.getCell(10);
                //xssfCell.setCellType(CellType.NUMERIC);
                //double a = xssfCell.getNumericCellValue();
                System.out.println(xssfCell);
                System.out.println("======================");
                double d = Double.parseDouble(xssfCell.getStringCellValue());
                //System.out.println(a);
                System.out.println(d);
                System.out.println("======================");
                sum = sum + d;
            }
        }
        System.out.println("sum:"+sum);
    }

    @Test
    public void test1() throws Exception{
        Score score = new Score();
        score.averageScore();
        System.out.println(score);
    }
}
