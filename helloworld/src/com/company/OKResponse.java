package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by DORIS on 2/22/2017.
 */
public class OKResponse extends Response{

    OKResponse(Resource okResource){
        code = 200;
        reasonPhrase = "Request Success";
        responseResource = okResource;
        serverFile = new File("C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\public_html\\ab1\\ab2\\index.html");
    }

    public void send(OutputStream out) {
        try {
//            File socketFile = new File(out)
            System.out.print("(1) Here! But what happened?" + "\n");
            Iterator it = null;
            responseOut = new DataOutputStream(out);
            DataInputStream dataFromFile = new DataInputStream(new FileInputStream(serverFile));
            List<String> keyValues = new ArrayList<>();


            String tempHeaderLine = "HTTP/1.1 " + this.getCode() + " " + this.getReasonPhrase() + "\r\n";
            int statusLineByteLength = tempHeaderLine.getBytes("UTF-8").length;
            byte[] statusLineBytes = tempHeaderLine.getBytes("UTF-8");
            responseOut.write(statusLineBytes, 0, statusLineByteLength);

            getGeneralHeaders();

            keyValues.add(String.valueOf(serverFile.length()));
            responseHeaders.put("Content-Length:", keyValues);

            it = responseHeaders.entrySet().iterator();
            System.out.print("(2) Here! But what happened?" + "\n");
            while (it.hasNext()) {
                Map.Entry temp = (Map.Entry) it.next();

                tempHeaderLine = temp.getKey().toString() + temp.getValue().toString() + "\r\n";
//                System.out.print(tempHeaderLine);
                System.out.print("(3) Here! But what happened?" + "\n");
                statusLineByteLength = tempHeaderLine.getBytes("UTF-8").length;
                statusLineBytes = tempHeaderLine.getBytes("UTF-8");
//                responseOut.write(statusLineBytes, 0, statusLineByteLength);
            }
            for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
