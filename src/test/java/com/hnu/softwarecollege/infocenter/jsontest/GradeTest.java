package com.hnu.softwarecollege.infocenter.jsontest;

import java.io.IOException;

/**
 * @ClassName GradeTest
 * @Description TODO
 * @Author liu
 * @Date 2018/11/26 23:31
 * @Version 1.0
 **/
public class GradeTest {
    public static void main(String args[]) {
        //String a ="2016011372 liu1996.";
        String id = "2016011346";
        String password = "919919niao";
        String[] arg = new String[]{"python", "C:\\Users\\14832\\Desktop\\information_center-feature-spider\\spider\\main.py", id, password};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(arg);
            /*InputStreamReader ir = new InputStreamReader(process.getInputStream(),"GBK");
            BufferedReader bufferedReader = new BufferedReader(ir);
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            ir.close();
            int re = process.waitFor();*/
            //System.out.println(re);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
