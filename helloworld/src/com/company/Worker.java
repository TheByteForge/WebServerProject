package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Worker extends Thread {
    private Socket workSocket;
    private MimesTypes workMimes;
    private HttpdConf workConfig;
    public String passLogFile;

//    private static byte [] bufferBytes = new byte[84*1024];
    private ResponseFactory rf = new ResponseFactory();

    public Worker(Socket socket, HttpdConf config, MimesTypes mimes){
            workSocket = socket;
            workMimes = mimes;
            workConfig = config;
            passLogFile = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\logfile";
    }

    @Override
    public void run(){
        super.run();
        try{
//            System.out.print("(1) Inside the Worker.run() Method!\n");
            Request userReq = new Request(workSocket.getInputStream());
            userReq.parse();
            Resource workerResource = new Resource(userReq.getURI(), workConfig);
            Response newResp = rf.getResponse(userReq, workerResource, workSocket.getOutputStream());
            System.out.print("Does it make the response ocrectly?\n");
            newResp.send(workSocket.getOutputStream());
//            ServerLogger sl = new ServerLogger(passLogFile);
//            sl.write(userReq, newResp);

            System.out.print("Is This Request a SCRIPTALIASED : " + workerResource.isScriptAliased() + "\n");
            System.out.print("Is This Request a ALIASED? : " + workerResource.isAliased() + "\n");
            System.out.print("This is the ABSOLUTE PATH : " + workerResource.absolutePath() + "\n");
            System.out.print("Created a new request, and resource classes, but didnt do anything with them yet\n");


        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Worker fucked up!\n");
        }

    }
}
