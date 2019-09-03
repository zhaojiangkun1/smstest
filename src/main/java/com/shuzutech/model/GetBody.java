package com.shuzutech.model;

import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.GetSendAllSmsParams;
import com.shuzutech.model.GetSendSmsParams;

import java.io.IOException;

public class GetBody {

    public static String getBody(InterfaceNum env, int id) throws IOException {
        String body="";
        if(env == InterfaceNum.NEWPROSEND || env == InterfaceNum.NEWTESTSEND || env==InterfaceNum.OLDADDRNEWPARAM){
            body = GetSendAllSmsParams.getSendAllSmsParams(id);
        }
        if (env == InterfaceNum.TESTSEND||env == InterfaceNum.PROSEND){
            body = GetSendSmsParams.getSendSmsParams(id);
        }
        if (env == InterfaceNum.GETRESULTTEST || env == InterfaceNum.GETRESULTPRO){
            body = GetResultListParams.getResultListParams();
        }

        return body;
    }

}
