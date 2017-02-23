package com.company;

import javax.xml.ws.Response;
import java.io.*;
import java.security.Timestamp;
import java.util.Date;

/**
 * Created by DORIS on 2/17/2017.
 */
public class Logger {

    private File file = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private Request userReq = null;
    private Response userResp = null;

    public void Logger(String fileName)throws IOException{
        String confPath = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\";
        file = new File(confPath + fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();

            }
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: FileWriter or BufferedWriter broken in log");
        }
    }

    public String Write(Request request, Response response){
        try {

            Date date = new Date();

            bw.write("******************************\n");
            bw.write("*" + "Date/Time: " + date.getTime() + "\n");
            bw.write("*" + request.getVerb() + " " + request.getURI() + " " + request.getHttpVersion() + " " + "\n");
            bw.write("*" );
            bw.write("******************************\n");

        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Error: Logger Issue, most likely the request or response instance!");
        }


        return "True";
    }
}
