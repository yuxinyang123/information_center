package com.hnu.softwarecollege.infocenter.util;

/**
 * @program: infocenter
 * @description: //TODO
 * @author: ying
 * @create: 2018-12-18 15:26
 **/
public class Base64PicUtil {
    public static String handlePic(String base64) {
        return base64.split(",")[1];
    }
}
