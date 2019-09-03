package com.shuzutech.model;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.SendAllSmsParams;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSendAllSmsParams {

    public static String getSendAllSmsParams(int id) throws IOException {
        JSONObject jsonObject = new JSONObject();
        SqlSession session = DataBaseUtil.getSqlSession();
        SendAllSmsParams sendAllSmsParams = new SendAllSmsParams();
        sendAllSmsParams = session.selectOne("getSendAllSmsParams",id);
        jsonObject.put("enterpriseId",sendAllSmsParams.getEnterpriseId());
        jsonObject.put("mobiles",sendAllSmsParams.getMobiles());
        jsonObject.put("templateId",sendAllSmsParams.getTemplateId());
        jsonObject.put("remark",sendAllSmsParams.getRemark());
        jsonObject.put("amount",sendAllSmsParams.getAmount());
        jsonObject.put("url",sendAllSmsParams.getUrl());
        return jsonObject.toString();
    }

}
