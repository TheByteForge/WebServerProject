package com.company;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResponseFactory {

    private Request currentRequest;
    private Resource currentResource;
    private DataOutputStream outputStream;
    private Map<String, List<String>> headerMap = new HashMap();
    private Iterator it = null;

    ResponseFactory(){
        currentRequest = null;
        currentResource = null;
    }

    public Response getResponse(Request request, Resource resource, OutputStream respSocket) {
        currentResource = resource;
        currentRequest = request;
        outputStream = new DataOutputStream(respSocket);
        String [] authenticatioPair = null;
        String authName;
        String authPassHash;
        String userAgent = null;
        ServerLogger sl = new ServerLogger();

        headerMap = request.getHeaders();
        it = headerMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry data = (Map.Entry) it.next();

            if(data.getKey().equals("User-Agent:")){
                userAgent = data.getValue().toString();
            }
            else if(data.getKey().equals("Authorization:")){
                authenticatioPair = data.getValue().toString().split(",");
                authName = authenticatioPair[0];
                authPassHash = authenticatioPair[1];
                System.out.print(authenticatioPair[0].replace("[", "") + "  " + authenticatioPair[1].replace("[", "") + "HEREEE IS THE AUTHNAME AND PASS PAIR\n\n");

            }

        }

        if(request == null && resource == null){
            return new InternalServerErrorResponse();
        }
        if(request.getVerb() == "GET" || request.getVerb() == "GET" ){

            Response okResponse = new OKResponse(currentResource);
            okResponse.send(outputStream);
//            sl.write(currentRequest, okResponse);
            return okResponse;
        }
        else if(request.getVerb() == "PUT"){

        }
        else if(request.getVerb() == "DELETE"){


        }
        else if(request.getVerb() == "HEAD"){

        }
        return new InternalServerErrorResponse();
    }

}
