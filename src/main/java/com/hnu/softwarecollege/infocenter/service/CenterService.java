package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;

public interface CenterService {
    public String getGrade(String number,String password);
    public CenterDegreePo transform();

    public String getGradeForeast();
    public String getCourseTable(String number,String password);
    public String getHotPot();
}
