package com.shuzutech.model;

import com.shuzutech.config.ConfigFile;
import com.shuzutech.config.InterfaceNum;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetAccessToken {

    private static String url;
    private static String appId;
    private static String appSecret;
    private static String access_Token;
    private static Date startTime;


    public static String getAccessToken(InterfaceNum env) throws IOException {
        appId = GetAppInfo.getAppInfo(env).getAppId();
        appSecret = GetAppInfo.getAppInfo(env).getAppSecret();
        System.out.println("请求的appId:"+appId);
        System.out.println("请求的appSecret:"+appSecret);
        url = ConfigFile.getTokenUrl(env) + "?&appId="+appId+"&appSecret="+appSecret;
        System.out.println("获取token的请求地址："+url);
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        String str1 = "<access_token>";
        String str2 = "</access_token>";
        String accessToken = result.substring(result.indexOf(str1)+(str1).length(),
                result.indexOf(str2));
        System.out.println("accessToken:"+accessToken);
        return accessToken;
    }

    public static String getTokenIsExpire(InterfaceNum env) throws IOException, ParseException {
        String date = ConfigFile.date;
        startTime = GetAppInfo.getAppInfo(env).getUpdateTime();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = sdf.parse(date);
        System.out.println("从数据库里取出的accessToken：" + GetAppInfo.getAppInfo(env).getAccessToken());
        long diffsec = (currentTime.getTime()-startTime.getTime())/1000;
        System.out.println("时间差："+diffsec);
        if (diffsec > 7200){
            access_Token = GetAccessToken.getAccessToken(env);
            GetAppInfo.updateAppInfo(currentTime,access_Token,env);
        }
        else {
            access_Token = GetAppInfo.getAppInfo(env).getAccessToken();
        }
        return access_Token;

    }

}
