package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class ResultListCase {
    @Test
    public void resultListCase() throws ParseException, NoSuchAlgorithmException, IOException {
        String result = SmsInterface.smsInterface(InterfaceNum.GETRESULTPRO,1);
        System.out.println(result);
    }
}
