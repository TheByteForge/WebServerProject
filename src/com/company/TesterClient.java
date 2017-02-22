package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DORIS on 2/21/2017.
 */


public class TesterClient {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 1; i++) {
            Socket socket = new Socket("localhost", 2050);

            sendMessage(socket, i);
//            readResponse( socket );

            socket.close();
        }

    }

    public static void sendMessage(Socket socket, int counter) throws IOException {
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        String confPath = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\testhttp.txt";
        File file = new File(confPath);
        InputStream inputStream = new FileInputStream(file);
        BufferedReader tempBR = new BufferedReader(new InputStreamReader(inputStream));

        String tempMessage;

        while((tempMessage = tempBR.readLine()) != null){

//            System.out.print(tempMessage + "\n");
            outSocket.print(tempMessage);
            outSocket.flush();

        }

    }
}

//    public static void readResponse( Socket socket ) throws IOException {
//        BufferedReader response = new BufferedReader(
//                new InputStreamReader( socket.getInputStream() )
//        );
//
//        String line;
//        while( ( line = response.readLine() ) != null ) {
//            System.out.println( "** " + line );
//        }
//    }

