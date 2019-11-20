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
     * 移动号码测试  该接口被废弃
     * @throws IOException
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"移动号码测试"})
    public void sendAllSmsCase() throws IOException, ParseException, NoSuchAlgorithmException,NullPointerException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWTESTSEND,2);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWTESTSEND,2);

    }

    /**
     * 联通号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test(groups = {"联通号码测试"})
    public void sendAllSmsCase1() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWTESTSEND,7);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWTESTSEND,7);
    }

    /**
     * 电信号码测试
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test(groups = {"电信号码测试"})
    public void sendAllSmsCase2() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWTESTSEND,6);
        SaveSendSmsResultList.saveSendSmsResultList(result,InterfaceNum.NEWTESTSEND,6);
    }

    /**
     * 手机号码格式错误
     * @throws ParseException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    @Test
    public void sendAllSmsCase3() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.NEWTESTSEND,8);
        System.out.println(result);
    }

}
