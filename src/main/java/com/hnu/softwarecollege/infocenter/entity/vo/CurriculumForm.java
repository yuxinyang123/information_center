package com.hnu.softwarecollege.infocenter.entity.vo;

/**
 * @program: infocenter
 * @description:
 * @author: yu
 * @create: 2018-11-21 11:15
 **/
public class CurriculumForm {
    private String className;
    private int startWeek;
    private int endWeek;
    private int startPart;
    private int endPart;
    private String week;
    private String classroom;
    private String teacher;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public int getStartPart() {
        return startPart;
    }

    public void setStartPart(int startPart) {
        this.startPart = startPart;
    }

    public int getEndPart() {
        return endPart;
    }

    public void setEndPart(int endPart) {
        this.endPart = endPart;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
