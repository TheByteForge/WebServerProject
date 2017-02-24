package com.company;

public class ResponseFactory {

    private Request currentRequest;
    private Resource currentResource;

    ResponseFactory(){
        currentRequest = null;
        currentResource = null;
    }

    public Response getResponse(Request request, Resource resource) {
        if(request == null && resource == null){
            return new InternalServerErrorResponse();
        }
        if(request.getVerb() == "GET"){

        }
        return new InternalServerErrorResponse();
    }

}
