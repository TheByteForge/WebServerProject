package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/21/2017.
 */
public abstract class Response {
    public int code = 0;
    public String reasonPhrase = "";
    public Resource resource;
//
//    Response(Resource resource){
//
//    }
//    send(OutputStream out){
//
//    }
//
//    @Override
//    public Response getResponse(Request request, Resource resource) {
//        return null;
//    }

    public int getCode(){ return code; }
    public String getReasonPhrase(){ return reasonPhrase; }

}
