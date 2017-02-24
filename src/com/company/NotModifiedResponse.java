package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class NotModifiedResponse extends Response{

    NotModifiedResponse(){
        code = 304;
        reasonPhrase = "Not Modified\n";

    }

    @Override
    void send(OutputStream out) {

    }
}

