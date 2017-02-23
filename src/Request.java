package com.company;

import java.io.*;
import java.util.*;

/**
 * Created by DORIS on 2/17/2017.
 */
public class Request {

    private static String uri;
    private static String verb;
    private static String httpVersion;
    private HashMap <String, List<String>> headers = new HashMap<>();
    private DataInputStream requestIn;
    private InputStream inStream;
    protected String [] currentLine = null;
    private ArrayList<String> strArray = new ArrayList<>();



    public Request(InputStream client)throws IOException{
        inStream = client;
        requestIn = new DataInputStream(inStream);
    }

    public void parse(){
        try {
            String s = null;
            StringBuilder sb = new StringBuilder();
            int strCounter = 0;


            while((s = requestIn.readLine()) != null){

                System.out.print("This is the string : " + s +"\n");
                strArray.add(s);
                System.out.print(strCounter + " : " + strArray.get(strCounter) +"\n");

                sb.append(s+ " ");
                strCounter++;
            }
            for (String e : strArray) {
                System.out.print(e + "\n");
                System.out.print("IN StraArry print loop\n");
            }
//            System.out.print(sb.toString() + "\n");
//            List<String> headerList = new ArrayList<>();
//            int count = 0;
//            String line = brReq.readLine();

//            while (line != null) {
//
//                currentLine = line.split("\\s+");
//                if(count == 0) {
//
//                    verb = currentLine[0];
//                    uri = currentLine[1];
//                    System.out.println("This is the uri in the general Request Class Instance :" + uri);
//                    httpVersion = currentLine[2];
//                    count = 1;
//                }
//                else{
////                    System.out.println(currentLine[0] + currentLine[1] + currentLine[2]);
//
//                    for(int i = 1; i < currentLine.length; i++) {
//                            headerList.add(currentLine[i].replaceAll("\\s+", ""));
//
//                    }
//                    headers.put(currentLine[0], headerList);
//                }
//                line = brReq.readLine();
//                System.out.println(Arrays.asList(headers));
//                headerList = new ArrayList<>();
//
//
//
//            }
            requestIn.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: Request Parsing Issue!");
        }

    }


    public static String getURI(){
        return uri;
    }
    public String getVerb(){
        return verb;
    }
    public String getHttpVersion(){
        return httpVersion;
    }

    public static void main(String [] args){
        try {

            String confPath = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\testhttp.txt";
            File file = new File(confPath);
            InputStream inputStream = new FileInputStream(file);
            Request request = new Request(inputStream);
            request.parse();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Request Test Failed");
        }
    }
}

