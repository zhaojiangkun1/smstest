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
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,4);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,4);
    }

    /**
     * 电信号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"电信号码测试"})
    public void sendSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,7);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,7);
    }

    /**
     * 联通号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"联通号码测试"})
    public void sendSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,6);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.PROSEND,6);
    }

    /**
     * 手机号码格式错误的短信
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void sendSmsCase3() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,8);
        System.out.println(result);
    }

}
