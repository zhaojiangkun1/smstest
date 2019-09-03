package com.shuzutech.model;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.SendSmsParams;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSendSmsParams {
    public static String getSendSmsParams(int id) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SendSmsParams sendSmsParams = new SendSmsParams();
        sendSmsParams = session.selectOne("getSendSmsParams",id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterpriseId",sendSmsParams.getEnterpriseId());
        jsonObject.put("mobiles",sendSmsParams.getMobiles());
        jsonObject.put("templateId",sendSmsParams.getTemplateId());
        jsonObject.put("placeHolderContent",sendSmsParams.getPlaceHolderContent());
        return jsonObject.toString();
    }
}
