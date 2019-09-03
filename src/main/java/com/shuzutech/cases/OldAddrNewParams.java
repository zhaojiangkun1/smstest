package com.shuzutech.cases;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.SmsInterface;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class OldAddrNewParams {
    @Test
    public void oldAddrNewParams() throws ParseException, NoSuchAlgorithmException, IOException {
        SmsInterface.smsInterface(InterfaceNum.OLDADDRNEWPARAM,2);
    }
}
