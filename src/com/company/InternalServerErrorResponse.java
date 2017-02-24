package com.company;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class InternalServerErrorResponse extends Response{

    InternalServerErrorResponse(){
        code = 500;
        reasonPhrase = "Internal Server Error\n";
    }

    @Override
    void send(OutputStream out) {
        DataOutputStream dis = new DataOutputStream(out);

    }
}
