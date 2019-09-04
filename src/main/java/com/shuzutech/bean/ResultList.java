package com.shuzutech.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ResultList {

    private int id;
    private String taskId;
    private Date sendTime;
    private String mobiles;

}
