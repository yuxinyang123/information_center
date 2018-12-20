package com.hnu.softwarecollege.infocenter.entity.po;

public class AvgPo {
    private Long id;

    private String classname;

    private Double fengshu;

    public AvgPo(){}

    public AvgPo(String classname, Double fengshu) {
        this.classname = classname;
        this.fengshu = fengshu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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