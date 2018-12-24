package com.hnu.softwarecollege.infocenter.entity.po;

public class AvgPo {
    private Long id;

    private String semester;

    private String classname;

    private Double fengshu;

    public AvgPo(){}

    public AvgPo(String classname, Double fengshu) {
        this.classname = classname;
        this.fengshu = fengshu;
    }

    public AvgPo(String semester, String classname, Double fengshu) {
        this.semester = semester;
        this.classname = classname;
        this.fengshu = fengshu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Double getFengshu() {
        return fengshu;
    }

    public void setFengshu(Double fengshu) {
        this.fengshu = fengshu;
    }
}