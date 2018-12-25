package com.hnu.softwarecollege.infocenter.mailtest;

import com.hnu.softwarecollege.infocenter.util.DESUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName Md5test
 * @Description TODO
 * @Author wang
 * @Date 2018/12/18 21:53
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Md5test {

    @Test
    public void con() throws Exception {
        Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
//        long date = System.currentTimeMillis();
        long date = outDate.getTime() / 1000 * 1000;
        String code1 = DESUtil.encrypt(date+"-798647567@qq.com");
        String code2 = DESUtil.decrypt("CKF+JZzZeLfZASPPJ2Ii0L6IkjpbsIiivKSPB3pqqHL7F6GzJjcCY0RsAPq72RIQwmGZmdUahlXs\n" +
                "5THem4kdGr51rmMBfRRq");
        System.out.println(code1);
        String delimeter = "-";
        String [] temp = code2.split(delimeter);
        long date2 = Long.parseLong(temp[0]);
        if (date2 <= System.currentTimeMillis()){
            log.error("已过期");
        }else {
            log.info("OK"+temp[0]+"-----"+temp[1]);
        }
//        System.out.println("EA@AE@BEFBDDDPCMLB@CABC4Z");
        System.out.println(code2);
    }

    @Test
    public void url() throws Exception {
        String code2 = DESUtil.decrypt("iQEbzkVbc95TM3PKt6kTwNaCVlKQkqTknTEaKARqYG4XH25ZVLA7t8CTb98SHS76DDm+hw0Z8jx03nOVzYpg3Bc+JRLeVmkW");
        log.info("{}",code2);
    }

}
