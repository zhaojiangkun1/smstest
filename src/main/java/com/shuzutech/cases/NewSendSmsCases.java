package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SaveSendSmsResultList;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class NewSendSmsCases {

    /**
     * placeHolderContent 使用json格式发送短信，移动号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test
    public void newSendSmsCase() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSMSSENDV2,5);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,5);
    }

    /**
     * 联通号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test
    public void newSendSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSMSSENDV2,6);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,6);
    }

    /**
     * 电信号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void newSendSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSMSSENDV2,7);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,7);
    }
}
