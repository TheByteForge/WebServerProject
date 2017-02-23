package com.company;

import java.io.*;
import java.security.MessageDigest;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Htaccess extends ConfigurationReader {

//    Htpassword userFile;
    String authType = null;
    String authName = null;
    String require = null;

    public Htaccess(){}

    public Htaccess(String fileName)throws IOException{
        super(fileName);
        String confPath = "C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\";
        file = new File(confPath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));

    }

    public void load() {

        try {

            while (hasMoreLines()) {
                String tempLine = nextLine();
                currentLine = tempLine.split("\\s+");
                if(currentLine[0] != "#" && currentLine[0] != " "){
                    switch (currentLine[0]) {
                        case "AuthUserFile":
//                            userFile = new Htpassword(currentLine[1]);
                            System.out.println(currentLine[1]);
                            break;
                        case "AuthType":
                            authType = currentLine[1];
                            System.out.println(currentLine[1]);
                            break;
                            //AUTHNAME Is flawed... "I Challenge You" is delimited by the first space "I_
                            //Need Fix!
                        case "AuthName":
                            authName = currentLine[1];
                            System.out.println(currentLine[1]);
                            break;
                        case "Require":
                            require = currentLine[1];
                            System.out.println(currentLine[1]);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    boolean isAuthorized(String username, String password) {

        try {

        return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void main(String []args){
        try {
            Htaccess ht = new Htaccess("_.htaccess");
            ht.load();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
