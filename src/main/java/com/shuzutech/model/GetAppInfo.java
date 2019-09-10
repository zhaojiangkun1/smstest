package com.shuzutech.model;

import com.shuzutech.bean.AppInfo;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.InterfaceNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;

public class GetAppInfo {


    public static AppInfo getAppInfo(InterfaceNum env) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
        if (env == InterfaceNum.TESTSEND || env == InterfaceNum.GETRESULTTEST || env == InterfaceNum.NEWTESTSEND || env == InterfaceNum.TESTSMSSENDV2) {
            appInfo = session.selectOne("getAppInfo", 2);
        }else {
            appInfo = session.selectOne("getAppInfo",1);
        }
        return appInfo;
    }

    public static void updateAppInfo(Date updateTime,String accessToken,InterfaceNum env) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        AppInfo appInfo = new AppInfo();
        appInfo.setAccessToken(accessToken);
        appInfo.setUpdateTime(updateTime);
        if (env == InterfaceNum.TESTSEND || env == InterfaceNum.GETRESULTTEST || env == InterfaceNum.NEWTESTSEND || env==InterfaceNum.TESTSMSSENDV2){
            appInfo.setId(2);
            session.update("updateAppInfo",appInfo);
            session.commit();
        }
        else {
            appInfo.setId(1);
            session.update("updateAppInfo",appInfo);
            session.commit();
        }

    }


}
