package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class ResultListCase {
    @Test(groups = {"发送结果测试"})
    public void resultListCase() throws ParseException, NoSuchAlgorithmException, IOException {
        SmsInterface.smsInterface(InterfaceNum.GETRESULTPRO,1);
    }
}
