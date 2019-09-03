package com.shuzutech.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.ResultList;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class SaveSendSmsResultList {

    public static void saveSendSmsResultList(String result) throws IOException {
        JSONObject jsonObject = JSON.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject jsonObject1 = JSON.parseObject(data);
        String taskId = jsonObject1.getString("taskId");
        ResultList resultList = GetResultList.getResultList();
        int id = resultList.getId();
        SqlSession session = DataBaseUtil.getSqlSession();
        resultList.setId(id+1);
        resultList.setTaskId(taskId);
        session.insert("saveResult",resultList);
        session.commit();
    }
}
