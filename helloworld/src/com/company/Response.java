package com.company;

import java.io.DataOutputStream;
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
    private HashMap <String, List<String>> responseHeaders = new HashMap<>();


    public Response(){}

    abstract void send(OutputStream out);

    public void getGenHeaders(){
        Date date = new Date();
        List<String> keyValues = new ArrayList<>();
        keyValues.add(date.toString());
        String s = "Date : ";
        responseHeaders.put(s, keyValues);
        keyValues.clear();
        keyValues.add("Derek & Zack");
        responseHeaders.put("Server Owners : ", keyValues);
    }
    public void getGETHeaders(){
        String tempS;
        List<String> tempList = new ArrayList<>();
        String [] tempSArr;
        tempS = "Transfer-Encoding: Chunked";
        tempSArr = tempS.split(" ");
        tempList.add(tempSArr[1]);
//        responseHeaders.put(tempSArr[0], tempList.);




    }
    public void getDELHeaders(){

    }
    public void getHEADHeaders(){

    }
    public void getPUTHeaders(){

    }



    public int getCode(){ return code; }
    public String getReasonPhrase(){ return reasonPhrase; }

}
