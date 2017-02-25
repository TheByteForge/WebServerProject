package com.company;

import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DORIS on 2/21/2017.
 */
public abstract class Response {
    protected int code = 0;
    protected String reasonPhrase = "";
    protected Resource responseResource;
    protected DataOutputStream responseOut;
    protected File tempLogFile;
    protected File serverFile;
    protected HashMap <String, List<String>> responseHeaders = new HashMap<>();
    protected List<String> keyValues = null;


    public Response(){}

    abstract void send(OutputStream out);

    public void getGeneralHeaders(){

        keyValues = new ArrayList<>();

        Date date = new Date();
        keyValues.add(date.toString());
        responseHeaders.put("Date: ", keyValues);


        keyValues.clear();

        keyValues = new ArrayList<>();

        keyValues.add("Derek & Zack");
        responseHeaders.put("Server Owners: ", keyValues);
        keyValues.add(date.toString());
        responseHeaders.put("Date: ", keyValues);
    }

    public int getCode(){ return code; }
    public String getReasonPhrase(){ return reasonPhrase; }

}
