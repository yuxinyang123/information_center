package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CenterDegreePo {
    private Long degreeId;

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
    private String degreeGrade;
    @JsonProperty("PerformancePoint")
    private Double degreePerformancepoint;
    @JsonProperty("testNature")
    private String degreeTestnature;
    @JsonProperty("studentId")
    private Integer degreeStudentid;
    @JsonProperty("stuName")
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

    public Double getDegreeCredit() {
        return degreeCredit;
    }

    public void setDegreeCredit(Double degreeCredit) {
        this.degreeCredit = degreeCredit;
    }

    public String getDegreeGrade() {
        return degreeGrade;
    }

    public void setDegreeGrade(String degreeGrade) {
        this.degreeGrade = degreeGrade == null ? null : degreeGrade.trim();
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
}