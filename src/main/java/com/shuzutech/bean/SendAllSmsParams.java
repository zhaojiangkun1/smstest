package com.shuzutech.bean;

import lombok.Data;

@Data
public class SendAllSmsParams {
    private int id;
    private String enterpriseId;
    private String mobiles;
    private String templateId;
    private String remark;
    private String amount;
    private String url;
}
