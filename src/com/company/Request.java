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
    protected String [] tempLine = null;
    private ArrayList<String> strArray = new ArrayList<>();



    public Request(InputStream client)throws IOException{
        inStream = client;
        requestIn = new DataInputStream(inStream);
    }

    public void parse(){
        try {
//            StringBuilder sb = new StringBuilder();
//            int strCounter = 0;


//            while((s = requestIn.readLine()) != null){
//
//                System.out.print("This is the string : " + s +"\n");
//                strArray.add(s);
//                System.out.print(strCounter + " : " + strArray.get(strCounter) +"\n");
//
//                sb.append(s+ " ");
//                strCounter++;
//            }
//            for (String e : strArray) {
//                System.out.print(e + "\n");
//                System.out.print("IN StraArry print loop\n");
//            }
//            System.out.print(sb.toString() + "\n");

            String s;
            List<String> headerList = new ArrayList<>();
            int count = 0;


            while ((s = requestIn.readLine()) != null && s.length() !=0) {

//                System.out.print("This is the original StringLine : " + s +"\n");
                currentLine = s.split("\\s");
                if(count == 0) {


                    verb = currentLine[0];

                    uri = currentLine[1];
                    httpVersion = currentLine[2];
                    System.out.println("This is the VERB in the general Request Class Instance : " + verb);
                    System.out.println("This is the URI in the general Request Class Instance : " + uri);
                    System.out.println("This is the HTTP Version in the general Request Class Instance : " + httpVersion);

                    count = 1;
                }
                else{
//                    System.out.println(currentLine[0] + currentLine[1] + currentLine[2]);

                    for(int i = 1; i < currentLine.length; i++) {
                            headerList.add(currentLine[i].replaceAll("\\s+", ""));

                    }
                    headers.put(currentLine[0], headerList);
                }

//                System.out.println(Arrays.asList(headers) + "\n");
                headerList = new ArrayList<>();

            }
            requestIn.close();
            System.out.println("This is the End of the Request!\n");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: Request Parsing Issue!");
        }

    }


    public String getURI(){
        return uri;
    }
    public String getVerb(){
        return verb;
    }
    public String getHttpVersion(){ return httpVersion; }
    public HashMap getHeaders(){ return headers; }

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

