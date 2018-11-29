package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;

import java.util.List;

public interface CenterService {
    public String getGrade(String number,String password);
    public List<CenterDegreePo> transform(String jsonStr);

    public String getGradeForeast();
    public String getCourseTable(String number,String password);
    public String getHotPot();
}
