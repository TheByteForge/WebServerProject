package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class NotFoundResponse extends Response{

    NotFoundResponse(){
        code = 404;
        reasonPhrase = "File(s) Not Found\n";

    }

    @Override
    void send(OutputStream out) {

    }
}
