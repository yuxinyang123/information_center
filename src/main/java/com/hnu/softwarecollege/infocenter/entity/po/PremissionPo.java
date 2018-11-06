package com.hnu.softwarecollege.infocenter.entity.po;

public class PremissionPo {
    private Long prmsId;

    private Long roleKey;

    private String prmsPremission;

    public Long getPrmsId() {
        return prmsId;
    }

    public void setPrmsId(Long prmsId) {
        this.prmsId = prmsId;
    }

    public Long getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(Long roleKey) {
        this.roleKey = roleKey;
    }

    public String getPrmsPremission() {
        return prmsPremission;
    }

    public void setPrmsPremission(String prmsPremission) {
        this.prmsPremission = prmsPremission == null ? null : prmsPremission.trim();
    }
}