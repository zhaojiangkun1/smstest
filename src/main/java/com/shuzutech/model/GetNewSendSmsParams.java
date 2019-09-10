package com.shuzutech.model;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.PlaceHolderContent;
import com.shuzutech.bean.SendSmsParams;
import com.shuzutech.cases.NewSendSmsCases;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetNewSendSmsParams {

    public static String getNewSendSmsParams(int id) throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        SendSmsParams sendSmsParams = new SendSmsParams();
        JSONObject jsonObject1 = GetPlaceHolderContent.getPlaceHolderContent();
        sendSmsParams = session.selectOne("getSendSmsParams",id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("enterpriseId",sendSmsParams.getEnterpriseId());
        jsonObject.put("mobiles",sendSmsParams.getMobiles());
        jsonObject.put("templateId",sendSmsParams.getTemplateId());
        jsonObject.put("placeHolderContent",jsonObject1);
        return jsonObject.toString();
    }
}
