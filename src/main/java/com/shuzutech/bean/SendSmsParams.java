package com.shuzutech.bean;

import lombok.Data;

@Data
public class SendSmsParams {
    private String enterpriseId;
    private String mobiles;
    private String templateId;
    private String placeHolderContent;
    private int id;

}
