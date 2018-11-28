package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SyllabusPo {
    @JsonProperty("")
    private Long syllabusId;

    private String syllabusClassname;

    private Integer syllabusStartweek;

    private Integer syllabusEndweek;

    private Integer syllabusStartpart;

    private Integer syllabusEndpart;

    private String syllabusWeek;

    private String syllabusClassroom;

    private String syllabusTeacher;

    private Long userkey;

    public Long getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Long syllabusId) {
        this.syllabusId = syllabusId;
    }

    public String getSyllabusClassname() {
        return syllabusClassname;
    }

    public void setSyllabusClassname(String syllabusClassname) {
        this.syllabusClassname = syllabusClassname == null ? null : syllabusClassname.trim();
    }

    public Integer getSyllabusStartweek() {
        return syllabusStartweek;
    }

    public void setSyllabusStartweek(Integer syllabusStartweek) {
        this.syllabusStartweek = syllabusStartweek;
    }

    public Integer getSyllabusEndweek() {
        return syllabusEndweek;
    }

    public void setSyllabusEndweek(Integer syllabusEndweek) {
        this.syllabusEndweek = syllabusEndweek;
    }

    public Integer getSyllabusStartpart() {
        return syllabusStartpart;
    }

    public void setSyllabusStartpart(Integer syllabusStartpart) {
        this.syllabusStartpart = syllabusStartpart;
    }

    public Integer getSyllabusEndpart() {
        return syllabusEndpart;
    }

    public void setSyllabusEndpart(Integer syllabusEndpart) {
        this.syllabusEndpart = syllabusEndpart;
    }

    public String getSyllabusWeek() {
        return syllabusWeek;
    }

    public void setSyllabusWeek(String syllabusWeek) {
        this.syllabusWeek = syllabusWeek == null ? null : syllabusWeek.trim();
    }

    public String getSyllabusClassroom() {
        return syllabusClassroom;
    }

    public void setSyllabusClassroom(String syllabusClassroom) {
        this.syllabusClassroom = syllabusClassroom == null ? null : syllabusClassroom.trim();
    }

    public String getSyllabusTeacher() {
        return syllabusTeacher;
    }

    public void setSyllabusTeacher(String syllabusTeacher) {
        this.syllabusTeacher = syllabusTeacher == null ? null : syllabusTeacher.trim();
    }

    public Long getUserkey() {
        return userkey;
    }

    public void setUserkey(Long userkey) {
        this.userkey = userkey;
    }
}