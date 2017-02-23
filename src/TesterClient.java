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
            Socket socket = new Socket("localhost", 2110);

            sendMessage(socket, i);
//            readResponse( socket );

            socket.close();
        }

    }

    public static void sendMessage(Socket socket, int counter) throws IOException {


        String confPath = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\testhttp.txt";
        File file = new File(confPath);
        InputStream inputFileStream = new FileInputStream(file);
        DataInputStream is = new DataInputStream(inputFileStream);

        DataOutputStream os = new DataOutputStream(socket.getOutputStream());



        String tempMessage;

        while((tempMessage = is.readLine()) != null){

//            System.out.print(tempMessage + "\n");
            os.writeChars(tempMessage);
            os.flush();

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

