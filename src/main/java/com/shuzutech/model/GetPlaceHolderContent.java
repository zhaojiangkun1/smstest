package com.shuzutech.model;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.PlaceHolderContent;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetPlaceHolderContent {

    public static JSONObject getPlaceHolderContent() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        PlaceHolderContent placeHolderContent = new PlaceHolderContent();
        placeHolderContent = session.selectOne("getPlaceHolderContent",1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("{[placeholder:remark]}",placeHolderContent.getRemark());
        jsonObject.put("{[placeholder:amount]}",placeHolderContent.getAmount());
        jsonObject.put("{[placeholder:url]}",placeHolderContent.getUrl());
        return jsonObject;
    }
}
