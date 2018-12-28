//package com.hnu.softwarecollege.infocenter.jsontest;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * @ClassName GetGradeTest
// * @Description TODO
// * @Author liu
// * @Date 2018/11/30 17:39
// * @Version 1.0
// **/
//public class GetGradeTest {
//    public static void main(String[] args){
//        String[] arg = new String[]{"python","C:\\Users\\14832\\Desktop\\test1\\Predict_Application_local.py","2016011372","1","1","3"};
//        Process process = null;
//        String result="";
//        try {
//            process = Runtime.getRuntime().exec(arg);
//            InputStreamReader ir = new InputStreamReader(process.getInputStream(),"GBK");
//            BufferedReader bufferedReader = new BufferedReader(ir);
//            String line;
//            while((line=bufferedReader.readLine())!=null){
//                result+=line;
//            }
//            ir.close();
//            int re = process.waitFor();
//            System.out.println(result);
//        }catch(IOException e){
//            e.printStackTrace();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//}
