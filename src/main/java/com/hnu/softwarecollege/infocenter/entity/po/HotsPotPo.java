package com.hnu.softwarecollege.infocenter.entity.po;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class HotsPotPo {
    @JsonProperty("id")
    private Integer hotspotId;
    @JsonProperty("title")
    private String hotspotTitle;
    @JsonProperty("hotnum")
    private String hotspotHotnum;
    @JsonProperty("hoturl")
    private String hotspotHoturl;

    public HotsPotPo(){}

    public HotsPotPo(String hotspotTitle, String hotspotHotnum, String hotspotHoturl) {
        this.hotspotTitle = hotspotTitle;
        this.hotspotHotnum = hotspotHotnum;
        this.hotspotHoturl = hotspotHoturl;
    }
    public HotsPotPo(){}

    public Integer getHotspotId() {
        return hotspotId;
    }

    public void setHotspotId(Integer hotspotId) {
        this.hotspotId = hotspotId;
    }

    public String getHotspotTitle() {
        return hotspotTitle;
    }

    public void setHotspotTitle(String hotspotTitle) {
        this.hotspotTitle = hotspotTitle == null ? null : hotspotTitle.trim();
    }

    public String getHotspotHotnum() {
        return hotspotHotnum;
    }

    public void setHotspotHotnum(String hotspotHotnum) {
        this.hotspotHotnum = hotspotHotnum == null ? null : hotspotHotnum.trim();
    }

    public String getHotspotHoturl() {
        return hotspotHoturl;
    }

    public void setHotspotHoturl(String hotspotHoturl) {
        this.hotspotHoturl = hotspotHoturl == null ? null : hotspotHoturl.trim();
    }
}