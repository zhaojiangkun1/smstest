package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SaveSendSmsResultList;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class SendSmsCase {

    /**
     * 移动号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test(groups = {"移动号码测试"})
    public void sendSmsCase() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSEND,4);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.TESTSEND,4);
    }

    /**
     * 电信号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"电信号码测试"})
    public void sendSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSEND,7);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.TESTSEND,7);
    }

    /**
     * 联通号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"联通号码测试"})
    public void sendSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.TESTSEND,6);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.TESTSEND,6);
    }

}