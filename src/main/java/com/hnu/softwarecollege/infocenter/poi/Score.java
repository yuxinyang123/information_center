package com.hnu.softwarecollege.infocenter.poi;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName Score
 * @Description TODO 通过excel表格对各个班级成绩情况分析
 * @Author liu
 * @Date 2018/12/20 8:45
 * @Version 1.0
 **/
public class Score {
    private File file = new File("excel/alltrem.xlsx");
    private String alltermpath = file.getAbsolutePath();
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

    @Override
    public String toString() {
        return "Score{" +
                "classoneavg=" + classoneavg +
                ", classtwoavg=" + classtwoavg +
                ", classthravg=" + classthravg +
                ", classfouavg=" + classfouavg +
                ", classfivavg=" + classfivavg +
                ", classsixavg=" + classsixavg +
                ", classsevavg=" + classsevavg +
                ", classeigavg=" + classeigavg +
                '}';
    }

    /**
     * @return void
     * @Author 刘亚双
     * @Description //TODO 求各个班的加权平均分
     * @Date 2018/12/20 8:48
     * @Param []
     **/

    public void averageScore() throws Exception{
        File file = new File(alltermpath);
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
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
        for (int i = 2; i < rowCount; i++) {
            XSSFRow xssfRow = sheet.getRow(i);
            XSSFCell classCell = xssfRow.getCell(19);
            classCell.setCellType(CellType.STRING);
            String flag = classCell.getStringCellValue();

            if (flag.equals("16软件工程1班")) {
                count1++;
                XSSFCell scorecell = xssfRow.getCell(10);
                double d = Double.parseDouble(scorecell.getStringCellValue());
                sumone = sumone + d;
            }
            if (flag.equals("16软件工程2班")) {
                count2++;
                XSSFCell scorecell = xssfRow.getCell(10);
                double d = Double.parseDouble(scorecell.getStringCellValue());
                sumtwo = sumtwo + d;
            }
            if (flag.equals("16软件工程3班")) {
                count3++;
                XSSFCell scorecell = xssfRow.getCell(10);
                double d = Double.parseDouble(scorecell.getStringCellValue());
                sumthr = sumthr + d;
            }
            if (flag.equals("16软件工程4班")) {
                count4++;
                XSSFCell scorecell = xssfRow.getCell(10);
                double d = Double.parseDouble(scorecell.getStringCellValue());
                sumfou = sumfou + d;
            }
            if (flag.equals("16软件工程5班")) {
                count5++;
                XSSFCell scoreCell = xssfRow.getCell(10);
                double d = Double.parseDouble(scoreCell.getStringCellValue());
                sumfiv = sumfiv + d;
            }
            if (flag.equals("16软件工程6班")) {
                count6++;
                XSSFCell scoreCell = xssfRow.getCell(10);
                double d = Double.parseDouble(scoreCell.getStringCellValue());
                sumsix = sumsix + d;
            }
            if (flag.equals("16软件工程7班")) {
                count7++;
                XSSFCell scoreCell = xssfRow.getCell(10);
                double d = Double.parseDouble(scoreCell.getStringCellValue());
                sumsev = sumsev + d;
            }
            if (flag.equals("16软件工程8班")) {
                count8++;
                XSSFCell scoreCell = xssfRow.getCell(10);
                double d = Double.parseDouble(scoreCell.getStringCellValue());
                sumeig = sumeig + d;
            }
        }
        setClassoneavg(sumone / count1);
        setClasstwoavg(sumtwo / count2);
        setClassthravg(sumthr / count3);
        setClassfouavg(sumfou / count4);
        setClassfivavg(sumfiv / count5);
        setClasssixavg(sumsix / count6);
        setClasssevavg(sumsev / count7);
        setClasseigavg(sumeig / count8);
    }


}
