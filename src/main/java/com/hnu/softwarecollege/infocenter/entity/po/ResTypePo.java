package com.hnu.softwarecollege.infocenter.entity.po;

import java.util.List;

public class ResTypePo {
    private Long typeId;

    private String typeName;

    private List<ResourcePo> resourcePos;

    public ResTypePo(Long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public ResTypePo() {
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public List<ResourcePo> getResourcePos() {
        return resourcePos;
    }

    public void setResourcePos(List<ResourcePo> resourcePos) {
        this.resourcePos = resourcePos;
    }
}