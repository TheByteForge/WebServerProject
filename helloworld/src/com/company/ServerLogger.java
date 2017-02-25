package com.company;

import javax.xml.ws.Response;
import java.io.*;
import java.net.InetAddress;
import java.security.Timestamp;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by DORIS on 2/17/2017.
 */
public class ServerLogger {

    /* COMMON LOG FORMAT IS:
    IP       user                   date/time                   command             version   status bytes
   127.0.0.1 user-identifier frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326 */

    private File file = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private Request userReq = null;
    private Response userResp = null;

    private static final Logger logger = Logger.getLogger( ServerLogger.class.getName() );
    FileHandler fh;

    public void ServerLogger(String fileName)throws IOException{
        String tempFile = fileName;
        fh = new FileHandler(tempFile);
        SimpleFormatter formatter = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(formatter);
        System.out.println("Constructor called to create: " + tempFile);
    }


    public String write(Request request, com.company.Response response){
        try {

            InetAddress addr = InetAddress.getLocalHost();
            //IP for localhost client
            String IPAddr = addr.getHostAddress();
            //Hostname of client
            String Host = addr.getHostName();
            // create date object
            Date date = new Date();
            //Display bytes of returned object
            String s = "some text here"; //REPLACE: bytes of response object returned to client
//            byte[] objByteSize = s.getBytes(response.getReasonPhrase());
//            String byteValToStr = String.valueOf(objByteSize.length);

            logger.info("REQUEST LOG WRITE CALLED: ");
            logger.info(String.valueOf(request.getVerb()));
            logger.info(String.valueOf(request.getURI()));
            logger.info(String.valueOf(request.getHttpVersion()));

            //Response Logging
            logger.info("RESPONSE LOG WRITE CALLED: ");
            logger.info(String.valueOf(response.getCode()));
            logger.info(String.valueOf(response.getReasonPhrase()));
//            logger.info(String.valueOf(response.getResource()));

//                logger.info("ServerLogger Object Created and File1 has been logged at: " + file1 + " with message: \n\n\n");
            logger.info(IPAddr + Host + date.toString());
            //logger.info(String.valueOf(request.getVerb()) + String.valueOf(request.uri) + String.valueOf(request.getHttpVersion()) + String.valueOf(response.code));
//                logger.info(byteValToStr);
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Error: Logger Issue, most likely the request or response instance!");
        }
        return "True";
    }
}
