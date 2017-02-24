package com.company;

import java.io.DataOutputStream;
import java.io.OutputStream;

/**
 * Created by DORIS on 2/21/2017.
 */
public abstract class Response {
    protected int code = 0;
    protected String reasonPhrase = "";
    protected Resource resource;

    Response(){
        code = 0;
        reasonPhrase = "";
        resource = null;
    }

    Response(Resource resource){}

    void send(OutputStream out){
        try{
            DataOutputStream genStream = new DataOutputStream(out);
            String
        }
        catch(Exception e){
            e.printStackTrace();
        }
    };

    public int getCode(){ return code; }
    public String getReasonPhrase(){ return reasonPhrase; }

}
