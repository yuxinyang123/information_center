package com.hnu.softwarecollege.infocenter.util;

import com.hnu.softwarecollege.infocenter.entity.po.AvgPo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ScoreUtil
 * @Description TODO
 * @Author liu
 * @Date 2018/12/24 9:21
 * @Version 1.0
 **/
public class ScoreUtil {
    public static List<double[]> transform(List<AvgPo> list){
        List<double[]> lists = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            if(i<8){
                lists.add(new double[]{1,i+1,list.get(i).getFengshu()});
            }else if(i<16&&i>7){
                lists.add(new double[]{2,(i%8)+1,list.get(i).getFengshu()});
            }else if(i<24&&i>16){
                lists.add(new double[]{3,(i%8)+1,list.get(i).getFengshu()});
            }else{
                lists.add(new double[]{4,(i%8)+1,list.get(i).getFengshu()});
            }
        }
        return lists;
    }
}
