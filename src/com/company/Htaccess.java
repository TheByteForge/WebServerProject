package com.company;

import java.io.*;
import java.security.MessageDigest;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Htaccess extends ConfigurationReader {

    Htpassword userFile;
    String authType = null;
    String authName = null;
    String require = null;

    public Htaccess(){}

    public Htaccess(String fileName)throws IOException{
        super(fileName);
        file = new File(fileName);
        inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));

    }

    public void load() {

        try {

            while (hasMoreLines()) {
                String tempLine = nextLine();
                currentLine = tempLine.replaceAll("\"","").split("\\s+");
                if(currentLine[0] != "#" && currentLine[0] != " "){
                    switch (currentLine[0]) {
                        case "AuthUserFile":
                            userFile = new Htpassword(currentLine[1]);
                            userFile.load();
                            System.out.println(currentLine[1]);
                            break;
                        case "AuthType":
                            authType = currentLine[1];
                            System.out.println(currentLine[1]);
                            break;
                        case "AuthName":
                            authName = currentLine[1] + " ";
                            for (int i = 2; i < currentLine.length; i++) {
                                if(i == currentLine.length-1){
                                    authName = authName + currentLine[i];
                                }
                                else{
                                    authName = authName + currentLine[i] + " ";
                                }

                            }
                            System.out.println(authName);
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

    public boolean isAuthorized(String userName, String userPass) {

        System.out.println("AuthInfo: " + authInfo);
        String credentials = new String(Base64.getDecoder().decode(authInfo),
                Charset.forName("UTF-8"));

        String[] tokens = credentials.split(":");

//        String hashPass;
        String[] data = null;
//        if(authName == userFile.getUser() &&  hashPass == userFile.getHashPass())

        try {


        return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void main(String []args){
        try {
            Htaccess ht = new Htaccess("C:\\Users\\DORIS\\Documents\\Programming_WEB_CPP_JAVA\\DZ_WebServer\\WebServerProject-TheByteForge-DZSRC-Testing\\srcDZ\\conf\\public_html\\.htaccess");
            ht.load();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
