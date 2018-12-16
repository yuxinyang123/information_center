package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CenterDegreePo {

    @JsonProperty("degreeId")
    private Long degreeId;
    @JsonProperty("degreeUserkey")
    private Long degreeUserkey;
    @JsonProperty("term")
    private String degreeTerm;
    @JsonProperty("className")
    private String degreeClassname;
    @JsonProperty("classNature")
    private String degreeClassnature;
    @JsonProperty("credit")
    private Double degreeCredit;
    @JsonProperty("grade")
    private Double degreeGrade;
    @JsonProperty("PerformancePoint")
    private Double degreePerformancepoint;

    public CenterDegreePo() {
    }

    @JsonProperty("testNature")
    private String degreeTestnature;
    @JsonProperty("studentId")
    private Integer degreeStudentid;
    @JsonProperty("stuName")
    private String degreeStudentname;

    public CenterDegreePo(Long degreeUserkey, String degreeTerm, String degreeClassname, String degreeClassnature,
                          Double degreeCredit, Double degreeGrade, Double degreePerformancepoint,
                          String degreeTestnature, Integer degreeStudentid, String degreeStudentname) {
        this.degreeUserkey = degreeUserkey;
        this.degreeTerm = degreeTerm;
        this.degreeClassname = degreeClassname;
        this.degreeClassnature = degreeClassnature;
        this.degreeCredit = degreeCredit;
        this.degreeGrade = degreeGrade;
        this.degreePerformancepoint = degreePerformancepoint;
        this.degreeTestnature = degreeTestnature;
        this.degreeStudentid = degreeStudentid;
        this.degreeStudentname = degreeStudentname;
    }

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

    public Double getDegreeCredit() {
        return degreeCredit;
    }

    public void setDegreeCredit(Double degreeCredit) {
        this.degreeCredit = degreeCredit;
    }

    public Double getDegreeGrade() {
        return degreeGrade;
    }

    public void setDegreeGrade(Double degreeGrade) {
        this.degreeGrade = degreeGrade;
    }

    public Double getDegreePerformancepoint() {
        return degreePerformancepoint;
    }

    public void setDegreePerformancepoint(Double degreePerformancepoint) {
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

    @Override
    public String toString() {
        return "CenterDegreePo{" +
                "degreeId=" + degreeId +
                ", degreeUserkey=" + degreeUserkey +
                ", degreeTerm='" + degreeTerm + '\'' +
                ", degreeClassname='" + degreeClassname + '\'' +
                ", degreeClassnature='" + degreeClassnature + '\'' +
                ", degreeCredit=" + degreeCredit +
                ", degreeGrade='" + degreeGrade + '\'' +
                ", degreePerformancepoint=" + degreePerformancepoint +
                ", degreeTestnature='" + degreeTestnature + '\'' +
                ", degreeStudentid=" + degreeStudentid +
                ", degreeStudentname='" + degreeStudentname + '\'' +
                '}';
    }
}