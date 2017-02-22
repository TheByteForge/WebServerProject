package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Worker extends Thread {
    private Socket workSocket;
    private MimesTypes workMimes;
    private HttpdConf workConfig;


    public Worker(Socket socket, HttpdConf config, MimesTypes mimes){
//        try {
            workSocket = socket;
            workMimes = mimes;
            workConfig = config;

//        }catch(Exception e){
//            e.printStackTrace();
//            System.out.print("Trying to attempt a buffered reader, instead of worksocket.getInpurtStream()");
//        }
    }

    @Override
    public void run(){
        super.run();
        try{
            byte [] bufferBytes = new byte[10000];
            int n;
            StringBuilder sb = new StringBuilder();
            String s = null;


            //TESTING PURPOSE****************
            System.out.print("(1) Inside the Worker.run() Method!\n");
            //*******************************

//            BufferedReader in = new BufferedReader(new InputStreamReader(workSocket.getInputStream()));
//            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            //TESTING PURPOSE****************
            System.out.print("(2) Also Inside the Worker.run() Method!\n");

            InputStream tempStream = workSocket.getInputStream();
            while((n = tempStream.read(bufferBytes)) > -1 ){

//                sb.append(bufferBytes);
            }
            s = new String(bufferBytes);
            System.out.print("This is what the bufferedreader gets in this line: " + s +"\n");
            //*******************************

            //TESTING PURPOSE****************
            System.out.print("(3) Also Inside the Worker.run() Method!, and am about to Create a Request...\n");
            //*******************************

            Request userReq = new Request(workSocket.getInputStream());
            userReq.parse();
            System.out.print("***This is the userReq uri: " + userReq.getURI() + "\n");
            Resource workerResource = new Resource(userReq.getURI(), workConfig);
            workerResource.isScriptAliased();
            System.out.print("Got into the worker and worked! (Created a new request, and resource classes), but didnt do anything!");


        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Worker fucked up!\n");
        }

    }
}
