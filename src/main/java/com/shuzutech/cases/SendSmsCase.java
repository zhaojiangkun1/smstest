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
    @Test
    public void sendSmsCase() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,4);
        SaveSendSmsResultList.saveSendSmsResultList(result);
    }

    /**
     * 电信号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test
    public void sendSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,2);
        SaveSendSmsResultList.saveSendSmsResultList(result);
    }

    /**
     * 联通号码发送
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test
    public void sendSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.PROSEND,3);
        SaveSendSmsResultList.saveSendSmsResultList(result);
    }

}
