package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class Htpassword extends ConfigurationReader {
    private HashMap<String, String> passwords;
    private String line;
    private String user;
    private String hashPass;

    public Htpassword(String fileName) throws IOException {
        super(fileName);
        file = new File(fileName);
        inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("Password file: " + fileName);

        this.passwords = new HashMap<String, String>();
        this.load();
    }

    public void load() {
        try {
            String[] splitStr = null;

            while (hasMoreLines()) {

                line = nextLine();
                if(line != null) {
                    splitStr = line.split(":");
                    user = splitStr[0].trim();
                    hashPass = splitStr[1].trim().replace("{SHA}", "");
                    passwords.put(user, hashPass);
                }
            }
            for (Map.Entry<String, String> entry : passwords.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("ERROR: Htpassword not working!\n\n");
        }
    }

    public String getUser(){ return user; }
    public String getHashPass(){ return hashPass; }
}