package com.company;

import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class ForbiddenResponse extends Response {
    ForbiddenResponse(){
        code = 403;
        reasonPhrase = "FORBIDDEN! YOU SHALL NOT PASS!\n";

    }

    @Override
    void send(OutputStream out) {

    }
}
