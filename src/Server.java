package com.company;

import com.company.HttpdConf;
import com.company.MimesTypes;
import com.company.Request;

import java.net.*;
import java.io.*;
import java.util.HashMap;

public class Server{
    private static HttpdConf defaultHttpdConf;
    private static MimesTypes defaultMimeTypes;
    private Socket clientSocket;
    private HashMap<String, String> accessFiles = new HashMap<>();
    private ServerSocket socket;
    private ResponseFactory rf = new ResponseFactory();

    public static void main( String[] args ) throws IOException {
        Server tempServ = new Server();
        tempServ.start();
    }

    public void start(){
        try {
            System.out.print("Server Starting...\n");
            defaultHttpdConf = new HttpdConf("httpd.conf");
            defaultMimeTypes = new MimesTypes("mime.types");
            defaultHttpdConf.load();
            defaultMimeTypes.load();

            socket = new ServerSocket(defaultHttpdConf.getListen().intValue());
            Resource rs = new Resource("/google.com/cgi-bin/", defaultHttpdConf);

            while (true) {

                System.out.print("Listening..\n");
                clientSocket = socket.accept();
                System.out.print("Found Something!\n");
                System.out.print("Starting Worker...\n");

                Thread userThread = new Worker(clientSocket, defaultHttpdConf, defaultMimeTypes);
                System.out.print("Attempting to Run Worker...\n");
                userThread.run();

                clientSocket.close();
                System.out.print("Client Closed\n");

            }
        }catch(Exception e){
            e.printStackTrace();

            System.out.println("Error With Server Socket, or Thread Creation in Server Class...\n");
        }
    }
}