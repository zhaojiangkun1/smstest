package com.shuzutech.model;

import com.alibaba.fastjson.JSONObject;
import com.shuzutech.bean.PageModel;
import com.shuzutech.bean.ResultList;

import java.io.IOException;

public class GetResultListParams {

    public static String getResultListParams() throws IOException {
        ResultList resultList = GetResultList.getResultList();
        PageModel pageModel = GetPageModel.getPageModel();
        JSONObject pm = new JSONObject();
        pm.put("pageNum",pageModel.getPageNum());
        pm.put("pageSize",pageModel.getPageSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("taskId",resultList.getTaskId());
        jsonObject.put("pageModel",pm);
        return jsonObject.toString();
    }
}
