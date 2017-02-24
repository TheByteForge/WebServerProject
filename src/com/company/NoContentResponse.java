package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class NoContentResponse extends Response{
    NoContentResponse(){
        code = 204;
        reasonPhrase = "No Content\n";

    }

    @Override
    void send(OutputStream out) {

    }
}
