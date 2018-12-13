package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.ResTypePo;
import com.hnu.softwarecollege.infocenter.entity.po.ResourcePo;

import java.util.List;

public interface ResourceService {
    public List<ResTypePo> getListByTypeName(String typename);

    public ResourcePo getResourcePoById(String id);
}
