package com.hnu.softwarecollege.infocenter.entity.vo;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 11:07
 **/
public class GradeForecastForm {
    private String studentID;//学号
    private String courseType; //学科类型  必修：1  选修：2
    private String testType; //考试类型  正常考试 只能是1
    private String gainCredit;//已经获得学分

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getGainCredit() {
        return gainCredit;
    }

    public void setGainCredit(String gainCredit) {
        this.gainCredit = gainCredit;
    }

    @Override
    public String toString() {
        return "GradeForecastForm{" +
                "studentID='" + studentID + '\'' +
                ", courseType='" + courseType + '\'' +
                ", testType='" + testType + '\'' +
                ", gainCredit='" + gainCredit + '\'' +
                '}';
    }
}
