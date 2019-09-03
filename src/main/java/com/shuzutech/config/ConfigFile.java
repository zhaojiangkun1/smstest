package com.shuzutech.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String date = sf.format(new Date());
    private static String url;

    public static String getTokenUrl(InterfaceNum env){
        String testUrl;
        String testUri=bundle.getString("testGetUrl");
        if(env == InterfaceNum.NEWTESTSEND || env == InterfaceNum.GETRESULTTEST
            || env == InterfaceNum.TESTSEND){
            testUrl = bundle.getString("testTokenUrl");
            url = testUrl + testUri;
        }else {
            testUrl = bundle.getString("proTokenUrl");
            url = testUrl + testUri;
        }

        return url;
    }

    public static String getSmsUrl(InterfaceNum env){
        String testUrl;
        String testUri;
        if (env == InterfaceNum.TESTSEND){
            testUrl = bundle.getString("testSendUrl");
            testUri = bundle.getString("testSendUri");
            url = testUrl + testUri;
        }
        if (env == InterfaceNum.GETRESULTTEST){
            testUrl = bundle.getString("testSendUrl");
            testUri = bundle.getString("testResultUri");
            url = testUrl + testUri;
        }
        if (env == InterfaceNum.GETRESULTPRO){
            testUrl = bundle.getString("proUrl");
            testUri = bundle.getString("proResultUri");
            url = testUrl + testUri;
        }
        if (env == InterfaceNum.PROSEND || env == InterfaceNum.OLDADDRNEWPARAM){
            testUrl = bundle.getString("proUrl");
            testUri = bundle.getString("proSendUri");
            url = testUrl + testUri;
        }
        if (env == InterfaceNum.NEWPROSEND){
            testUrl = bundle.getString("proUrl");
            testUri = bundle.getString("newProSendUri");
            url = testUrl + testUri;
        }
        if (env == InterfaceNum.NEWTESTSEND){
            testUrl = bundle.getString("testSendUrl");
            testUri = bundle.getString("newTestSendUri");
            url = testUrl + testUri;
        }
        return url;
    }


}
