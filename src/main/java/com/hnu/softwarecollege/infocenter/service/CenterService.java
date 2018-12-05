package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;

import java.util.List;

public interface CenterService {
    public String getGrade(String number,String password);
    public List<CenterDegreePo> transform(String jsonStr);
    public String getGradeForeast(String studentId,String courseType,String testType,String gainCredit);
    public String getCourseTable();
    public List<HotsPotPo> getHotPot(int pageNum,int pageSize);
    public void updateHotspot(List<HotsPotPo> hotsPotPos);
}
