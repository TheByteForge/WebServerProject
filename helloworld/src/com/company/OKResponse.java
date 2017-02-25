package com.company;

import java.io.DataOutputStream;
import java.io.OutputStream;

/**
 * Created by DORIS on 2/22/2017.
 */
public class OKResponse extends Response{

    OKResponse(Resource okResource){
        code = 200;
        reasonPhrase = "Request Success";
        responseResource = okResource;
        this.getGenHeaders();
    }

    public void send(OutputStream out) {
        try {
            responseOut = new DataOutputStream(out);

            String statusLine = "HTTP/1.1 " + this.getCode() + " " + this.getReasonPhrase() + "\r\n";
            int statusLineByteLength = statusLine.getBytes("UTF-8").length;
            byte[] statusLineBytes = statusLine.getBytes("UTF-8");
            responseOut.write(statusLineBytes, 0, statusLineByteLength);
            this.getGenHeaders();





            responseOut.write();




        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
