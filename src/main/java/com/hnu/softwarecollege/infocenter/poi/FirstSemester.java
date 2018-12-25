package com.hnu.softwarecollege.infocenter.poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName FirstSemester
 * @Description TODO
 * @Author liu
 * @Date 2018/12/23 14:01
 * @Version 1.0
 **/
public class FirstSemester {
    private double classoneavg;
    private double classtwoavg;
    private double classthravg;
    private double classfouavg;
    private double classfivavg;
    private double classsixavg;
    private double classsevavg;
    private double classeigavg;

    public double getClassoneavg() {
        return classoneavg;
    }

    public void setClassoneavg(double classoneavg) {
        this.classoneavg = classoneavg;
    }

    public double getClasstwoavg() {
        return classtwoavg;
    }

    public void setClasstwoavg(double classtwoavg) {
        this.classtwoavg = classtwoavg;
    }

    public double getClassthravg() {
        return classthravg;
    }

    public void setClassthravg(double classthravg) {
        this.classthravg = classthravg;
    }

    public double getClassfouavg() {
        return classfouavg;
    }

    public void setClassfouavg(double classfouavg) {
        this.classfouavg = classfouavg;
    }

    public double getClassfivavg() {
        return classfivavg;
    }

    public void setClassfivavg(double classfivavg) {
        this.classfivavg = classfivavg;
    }

    public double getClasssixavg() {
        return classsixavg;
    }

    public void setClasssixavg(double classsixavg) {
        this.classsixavg = classsixavg;
    }

    public double getClasssevavg() {
        return classsevavg;
    }

    public void setClasssevavg(double classsevavg) {
        this.classsevavg = classsevavg;
    }

    public double getClasseigavg() {
        return classeigavg;
    }

    public void setClasseigavg(double classeigavg) {
        this.classeigavg = classeigavg;
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 获取第一学年各班的平均成绩
     * @Date 2018/12/23 14:13
     * @Param []
     * @return void
     **/
    public void avgFirstSemester(String path) throws Exception{
        File file = new File(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowCount = xssfSheet.getLastRowNum();
        double sumone = 0;
        double sumtwo = 0;
        double sumthr = 0;
        double sumfou = 0;
        double sumfiv = 0;
        double sumsix = 0;
        double sumsev = 0;
        double sumeig = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        for(int i = 1;i<rowCount;i++){
            XSSFRow xssfRow = xssfSheet.getRow(i);
            XSSFCell xssfCell = xssfRow.getCell(2);
            String classname = xssfCell.getStringCellValue();
            if(classname.equals("16级1班")){
                count1++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumone = sumone + b;
            }
            if(classname.equals("16级2班")){
                count2++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumtwo = sumtwo + b;
            }
            if(classname.equals("16级3班")){
                count3++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumthr = sumthr + b;
            }
            if(classname.equals("16级4班")){
                count4++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumfou = sumfou + b;
            }
            if(classname.equals("16级5班")){
                count5++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumfiv = sumfiv + b;
            }
            if(classname.equals("16级6班")){
                count6++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumsix = sumsix + b;
            }
            if(classname.equals("16级7班")){
                count7++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumsev = sumsev + b;
            }
            if(classname.equals("16级8班")){
                count8++;
                XSSFCell cell = xssfRow.getCell(8);
                double b = cell.getNumericCellValue();
                sumeig = sumeig + b;
            }
        }
        setClassoneavg(sumone/count1);
        setClasstwoavg(sumtwo/count2);
        setClassthravg(sumthr/count3);
        setClassfouavg(sumfou/count4);
        setClassfivavg(sumfiv/count5);
        setClasssixavg(sumsix/count6);
        setClasssevavg(sumsev/count7);
        setClasseigavg(sumeig/count8);
    }
}
