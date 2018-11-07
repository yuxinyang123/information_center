package com.hnu.softwarecollege.infocenter.entity.vo;

import java.util.Date;

/**
 * @program: infocenter
 * @description: baseresponse
 * @author: yu
 * @create: 2018-11-06 23:13
 **/
public class BaseResponseVo<T> {
    private static final int SUCCESS_CODE=200;
    private static final int FAIL_CODE=404;
    private static final int ERROR_CODE=500;
    private T data;
    private String msg;
    private int code;
    private Date date;
    BaseResponseVo(T data,String msg,int code,Date date){
        this.setData(data);
        this.setMsg(msg);
        this.setCode(code);
        this.setDate(date);
    }


    public static <T> BaseResponseVo<T> success(T data){
        return new BaseResponseVo<T>(data,"success",BaseResponseVo.SUCCESS_CODE,new Date());
    }
    public static <T> BaseResponseVo<T> success(){
        return new BaseResponseVo<T>(null,"success",BaseResponseVo.SUCCESS_CODE,new Date());
    }
    public static <T> BaseResponseVo<T> fail(String msg){
        return new BaseResponseVo<T>(null,msg,BaseResponseVo.FAIL_CODE,new Date());
    }
    public static <T> BaseResponseVo<T> error(String msg){
        return new BaseResponseVo<T>(null,msg,BaseResponseVo.ERROR_CODE,new Date());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
