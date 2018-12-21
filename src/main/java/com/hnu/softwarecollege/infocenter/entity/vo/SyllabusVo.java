package com.hnu.softwarecollege.infocenter.entity.vo;

import com.hnu.softwarecollege.infocenter.entity.po.SyllabusPo;

import java.util.List;

/**
 * @ClassName SyllabusVo
 * @Description TODO
 * @Author liu
 * @Date 2018/12/16 23:24
 * @Version 1.0
 **/
public class SyllabusVo {
    private List<SyllabusPo> 星期一;
    private List<SyllabusPo> 星期二;
    private List<SyllabusPo> 星期三;
    private List<SyllabusPo> 星期四;
    private List<SyllabusPo> 星期五;

    public List<SyllabusPo> get星期一() {
        return 星期一;
    }

    public void set星期一(List<SyllabusPo> 星期一) {
        this.星期一 = 星期一;
    }

    public List<SyllabusPo> get星期二() {
        return 星期二;
    }

    public void set星期二(List<SyllabusPo> 星期二) {
        this.星期二 = 星期二;
    }

    public List<SyllabusPo> get星期三() {
        return 星期三;
    }

    public void set星期三(List<SyllabusPo> 星期三) {
        this.星期三 = 星期三;
    }

    public List<SyllabusPo> get星期四() {
        return 星期四;
    }

    public void set星期四(List<SyllabusPo> 星期四) {
        this.星期四 = 星期四;
    }

    public List<SyllabusPo> get星期五() {
        return 星期五;
    }

    public void set星期五(List<SyllabusPo> 星期五) {
        this.星期五 = 星期五;
    }

    @Override
    public String toString() {
        return "SyllabusVo{" +
                "星期一:" + 星期一 +
                ", 星期二:" + 星期二 +
                ", 星期三:" + 星期三 +
                ", 星期四:" + 星期四 +
                ", 星期五:" + 星期五 +
                '}';
    }
}
