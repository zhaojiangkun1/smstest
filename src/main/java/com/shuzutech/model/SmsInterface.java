package com.shuzutech.model;

import com.shuzutech.config.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsInterface {

    private static String url;
    private static String body;
    private static String md5Content;

    public static String smsInterface(InterfaceNum env,int id) throws IOException, ParseException, NoSuchAlgorithmException {

        body = GetBody.getBody(env,id);
        System.out.println("请求的body:"+body);
        url = ConfigFile.getSmsUrl(env);
        System.out.println("请求的url:"+url);
        String appId = GetAppInfo.getAppInfo(env).getAppId();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String accessToken = GetAccessToken.getTokenIsExpire(env);
        System.out.println("请求的accessToken:"+accessToken);
        System.out.println("当前时间：" + date);

        md5Content = Md5.EncoderByMd5(body + date + accessToken);

        System.out.println("加密后的内容："+ md5Content);
        StringEntity entity = new StringEntity(body,"utf-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        post.setHeader("APPID", appId);
        post.setHeader("Date",date);
        post.setHeader("Content-MD5",md5Content);

        HttpResponse response = client.execute(post);

        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(" ");
//        System.out.println(result);
        return result;

    }


}
