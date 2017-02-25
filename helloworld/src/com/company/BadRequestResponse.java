package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class BadRequestResponse extends Response{

    BadRequestResponse(){
        code = 400;
        reasonPhrase = "Bad Request\n";

    }

    @Override
    void send(OutputStream out) {

    }
}
