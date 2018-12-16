package com.hnu.softwarecollege.infocenter.entity.po;

import java.util.Date;

public class ResourcePo {
    private Long resId;

    private Long typeKey;

    private String resTitle;

    private String resAuthor;

    public ResourcePo() {
    }

    private String resSource;

    private Date resDate;

    private String resContext;

    public ResourcePo(Long typeKey, String resTitle, String resAuthor, String resSource, Date resDate, String resContext) {
        this.typeKey = typeKey;
        this.resTitle = resTitle;
        this.resAuthor = resAuthor;
        this.resSource = resSource;
        this.resDate = resDate;
        this.resContext = resContext;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public Long getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(Long typeKey) {
        this.typeKey = typeKey;
    }

    public String getResTitle() {
        return resTitle;
    }

    public void setResTitle(String resTitle) {
        this.resTitle = resTitle == null ? null : resTitle.trim();
    }

    public String getResAuthor() {
        return resAuthor;
    }

    public void setResAuthor(String resAuthor) {
        this.resAuthor = resAuthor == null ? null : resAuthor.trim();
    }

    public String getResSource() {
        return resSource;
    }

    public void setResSource(String resSource) {
        this.resSource = resSource == null ? null : resSource.trim();
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public String getResContext() {
        return resContext;
    }

    public void setResContext(String resContext) {
        this.resContext = resContext == null ? null : resContext.trim();
    }
}