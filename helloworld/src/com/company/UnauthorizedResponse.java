package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class UnauthorizedResponse extends Response{

    UnauthorizedResponse(){
        code = 401;
        reasonPhrase = "Unauthorized! WHO YOU IS?!?!?\n";

    }

    @Override
    void send(OutputStream out) {

    }
}
