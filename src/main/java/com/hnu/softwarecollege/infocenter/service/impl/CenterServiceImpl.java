package com.hnu.softwarecollege.infocenter.service.impl;

import com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo;
import com.hnu.softwarecollege.infocenter.service.CenterService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName CenterServiceImpl
 * @Description TODO
 * @Author liu
 * @Date 2018/11/26 8:55
 * @Version 1.0
 **/
public class CenterServiceImpl implements CenterService {
    /*
     * @Author 刘亚双
     * @Description //TODO 执行 python 脚本 获取输入流，
     * @Date 2018/11/28 14:19
     * @Param [Id, password]
     * @return java.lang.String
     **/
    @Override
    public String getGrade(String Id, String password) {
        String[] arg = new String[]{"python", "C:\\Users\\14832\\Desktop\\information_center-feature-spider\\spider\\main.py",Id,password};
        Process process =null;
        try {
            process = Runtime.getRuntime().exec(arg);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(ir);
            String s;
            while((s=bufferedReader.readLine())!=null){
                System.out.println(s);
            }
            ir.close();
            process.waitFor();
        }catch(IOException e ){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
    /*
     * @Author 刘亚双
     * @Description //TODO  解析json 格式的数据，转化为实体类存入数据库
     * @Date 2018/11/28 14:24
     * @Param []
     * @return com.hnu.softwarecollege.infocenter.entity.po.CenterDegreePo
     **/
    @Override
    public CenterDegreePo transform() {
        return null;
    }

    @Override
    public String getGradeForeast() {
        return null;
    }

    @Override
    public String getCourseTable(String number, String password) {
        return null;
    }

    @Override
    public String getHotPot() {
        return null;
    }
}
