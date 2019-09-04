package com.shuzutech.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.ResultList;
import com.shuzutech.config.ConfigFile;
import com.shuzutech.config.DataBaseUtil;
import com.shuzutech.config.InterfaceNum;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveSendSmsResultList {

    public static void saveSendSmsResultList(String result, InterfaceNum num,int iD) throws IOException, ParseException {
        String date = ConfigFile.date;
        String body = GetBody.getBody(num,iD);
        JSONObject jsbody = JSONObject.parseObject(body);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = sdf.parse(date);
        JSONObject jsonObject = JSON.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject jsonObject1 = JSON.parseObject(data);
        String taskId = jsonObject1.getString("taskId");
        ResultList resultList = GetResultList.getResultList();
        int id = resultList.getId();
        SqlSession session = DataBaseUtil.getSqlSession();
        resultList.setId(id+1);
        resultList.setTaskId(taskId);
        resultList.setSendTime(currentTime);
        resultList.setMobiles(jsbody.getString("mobiles"));
        session.insert("saveResult",resultList);
        session.commit();
    }
}
