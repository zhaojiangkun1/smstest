package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SaveSendSmsResultList;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class SendALlSmsCase {

    /**
     * 移动号码测试
     * @throws IOException
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"移动号码测试"})
    public void sendAllSmsCase() throws IOException, ParseException, NoSuchAlgorithmException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWPROSEND,2);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWPROSEND,2);
    }

    /**
     * 联通号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"联通号码测试"})
    public void sendAllSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWPROSEND,7);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWPROSEND,7);
    }

    /**
     * 电信号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test(groups = {"电信号码测试"})
    public void sendAllSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWPROSEND,6);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWPROSEND,6);
    }

}
