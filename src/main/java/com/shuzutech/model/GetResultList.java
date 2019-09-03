package com.shuzutech.model;

import com.shuzutech.bean.ResultList;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetResultList {
    public static ResultList getResultList() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        ResultList resultList = new ResultList();
        resultList = session.selectOne("sendResult");
        return resultList;
    }
}
