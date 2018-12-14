package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;

import com.hnu.softwarecollege.infocenter.entity.po.HotsPotPo;
import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;
import com.hnu.softwarecollege.infocenter.entity.vo.CurriculumForm;
import com.hnu.softwarecollege.infocenter.entity.vo.FourTag;

import java.util.List;

public interface CenterService {
    public void getGrade();
    public List<CenterDegreePo> gradeDB();
    public String getGradeForeast(String studentId,String courseType,String testType,String gainCredit);
    public List<HotsPotPo> getHotPot(int pageNum,int pageSize);
    public void updateHotspot(List<HotsPotPo> hotsPotPos);
    public List<SyllabusPo> getCourseTable(Long userkey);
    public void putCurriculum(CurriculumForm curriculumForm);
    public FourTag selectForFouttag();
}
