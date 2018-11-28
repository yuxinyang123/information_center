package com.hnu.softwarecollege.infocenter.entity.po;

public class CenterDegreePo {
    private Long degreeId;

    private Long degreeUserkey;

    private String degreeTerm;

    private String degreeClassname;

    private String degreeClassnature;

    private Integer degreeCredit;

    private Integer degreeGrade;

    private Integer degreePerformancepoint;

    private String degreeTestnature;

    private Integer degreeStudentid;

    private String degreeStudentname;

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Long getDegreeUserkey() {
        return degreeUserkey;
    }

    public void setDegreeUserkey(Long degreeUserkey) {
        this.degreeUserkey = degreeUserkey;
    }

    public String getDegreeTerm() {
        return degreeTerm;
    }

    public void setDegreeTerm(String degreeTerm) {
        this.degreeTerm = degreeTerm == null ? null : degreeTerm.trim();
    }

    public String getDegreeClassname() {
        return degreeClassname;
    }

    public void setDegreeClassname(String degreeClassname) {
        this.degreeClassname = degreeClassname == null ? null : degreeClassname.trim();
    }

    public String getDegreeClassnature() {
        return degreeClassnature;
    }

    public void setDegreeClassnature(String degreeClassnature) {
        this.degreeClassnature = degreeClassnature == null ? null : degreeClassnature.trim();
    }

    public Integer getDegreeCredit() {
        return degreeCredit;
    }

    public void setDegreeCredit(Integer degreeCredit) {
        this.degreeCredit = degreeCredit;
    }

    public Integer getDegreeGrade() {
        return degreeGrade;
    }

    public void setDegreeGrade(Integer degreeGrade) {
        this.degreeGrade = degreeGrade;
    }

    public Integer getDegreePerformancepoint() {
        return degreePerformancepoint;
    }

    public void setDegreePerformancepoint(Integer degreePerformancepoint) {
        this.degreePerformancepoint = degreePerformancepoint;
    }

    public String getDegreeTestnature() {
        return degreeTestnature;
    }

    public void setDegreeTestnature(String degreeTestnature) {
        this.degreeTestnature = degreeTestnature == null ? null : degreeTestnature.trim();
    }

    public Integer getDegreeStudentid() {
        return degreeStudentid;
    }

    public void setDegreeStudentid(Integer degreeStudentid) {
        this.degreeStudentid = degreeStudentid;
    }

    public String getDegreeStudentname() {
        return degreeStudentname;
    }

    public void setDegreeStudentname(String degreeStudentname) {
        this.degreeStudentname = degreeStudentname == null ? null : degreeStudentname.trim();
    }
}