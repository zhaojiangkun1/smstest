package com.shuzutech.model;

import com.shuzutech.bean.PageModel;
import com.shuzutech.config.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetPageModel {

    public static PageModel getPageModel() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        PageModel pageModel = new PageModel();
        pageModel = session.selectOne("pageModel",1);
        return pageModel;
    }
}
