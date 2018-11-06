package com.hnu.softwarecollege.infocenter.mapper;

import com.hnu.softwarecollege.infocenter.entity.po.HotpotPo;

public interface HotpotPoMapper {
    int deleteByPrimaryKey(Long hotpotId);

    int insert(HotpotPo record);

    int insertSelective(HotpotPo record);
}