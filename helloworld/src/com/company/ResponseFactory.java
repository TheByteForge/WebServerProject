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
        String[] authenticatioPair = null;
        String authName;
        String authPassHash;
        String userAgent = null;

        headerMap = request.getHeaders();
        it = headerMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry data = (Map.Entry) it.next();

            if (data.getKey().equals("User-Agent:")) {
                userAgent = data.getValue().toString();
            } else if (data.getKey().equals("Authorization:")) {
                authenticatioPair = data.getValue().toString().split(",");
                authName = authenticatioPair[0].replace("[", "");
                authPassHash = authenticatioPair[1].replace("]", "");
                System.out.print(authName + "  " + authPassHash + "\n\n");

            }

        }

        if (currentResource != null && currentRequest != null && respSocket != null) {
            if (request.getVerb().equals("GET") || request.getVerb().equals("POST")) {
                System.out.print(request.getVerb() + "\n");
                Response okResponse = new OKResponse(currentResource);
                okResponse.send(outputStream);
                return okResponse;
            }
//             else if (request.getVerb() == "PUT") {
//
//            } else if (request.getVerb() == "DELETE") {
//
//            } else if (request.getVerb() == "HEAD") {
//
//            }
        }

        return new InternalServerErrorResponse();


    }

}
