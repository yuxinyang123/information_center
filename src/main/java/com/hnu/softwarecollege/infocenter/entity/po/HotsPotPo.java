package com.hnu.softwarecollege.infocenter.entity.po;

public class HotsPotPo {
    private Integer hotspotId;

    private String hotspotTitle;

    private String hotspotHotnum;

    private String hotspotHoturl;

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