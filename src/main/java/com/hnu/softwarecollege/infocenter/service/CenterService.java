package com.hnu.softwarecollege.infocenter.service;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;
import com.hnu.softwarecollege.infocenter.entity.vo.CurriculumForm;

import java.util.List;

public interface CenterService {
    public String getGrade(String number,String password);
    public List<CenterDegreePo> transform(String jsonStr);
    public String getGradeForeast(String studentId,String courseType,String testType,String gainCredit);
    public List<SyllabusPo> getCourseTable(Long userkey);
    public void putCurriculum(CurriculumForm curriculumForm);
    public String getHotPot();
}
