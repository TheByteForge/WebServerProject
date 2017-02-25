package com.company;

import java.io.*;
import java.util.*;

public class HttpdConf extends ConfigurationReader{
    private String serverRoot = null;
    private Integer listen = 0;
    private String documentRoot = null;
    private String logFile = null;
    private HashMap <String, String> alias = new HashMap<>();
    private HashMap <String, String> scriptAliases = new HashMap<>();
    private String accessFileName = null;
    private HashMap <String, String> directoryIndex = new HashMap<>();

    public HttpdConf (){}

    public HttpdConf(String fileName)throws IOException{

        file = new File(fileName);
        inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));

    }

    //Attempts to load httpdconf file into server memory variables
    public void load() {
        try {

            while (hasMoreLines()) {
                String tempLine = nextLine();
                currentLine = tempLine.split("\\s+");
                if (currentLine[0] != "#" && currentLine[0] != " ") {

                    //Compares first element for correct storage variable
                    //Stores second or more elements into hashtables in applicable
                    for (int i = 1; i < currentLine.length; i++) {
                        switch (currentLine[0]) {
                            case "ServerRoot":
                                serverRoot = currentLine[1].replace("\"", "");
//                                System.out.print(serverRoot + "\n");
                                break;
                            case "Listen":
                                listen = Integer.parseInt(currentLine[1]);
//                                System.out.print(listen + "\n");
                                break;
                            case "DocumentRoot":
                                documentRoot = currentLine[1].replace("\"", "");
//                                System.out.print(documentRoot + "\n");
                                break;
                            case "LogFile":
                                logFile = currentLine[1].replace("\"", "");
//                                System.out.print(logFile + "\n");
                                break;
                            case "Alias":
                                alias.put(currentLine[1].replace("/", ""), currentLine[2].replace("\"", ""));
                                break;
                            case "ScriptAlias":
                                scriptAliases.put(currentLine[1].replace("/", ""), currentLine[2].replace("\"", ""));
                                break;
                            case "AccessFilename":
                                accessFileName = currentLine[1].replace("\"", "");
                                break;
                            case "DirectoryIndex":
                                directoryIndex.put(currentLine[1], currentLine[2]);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
//            for (Map.Entry<String, String> entry : alias.entrySet()) {
//                System.out.println(entry.getKey()+" : "+entry.getValue());
//            }
//            for (Map.Entry<String, String> entry : scriptAliases.entrySet()) {
//                System.out.println(entry.getKey()+" : "+entry.getValue());
//            }
            System.out.println("HttpdConf creation worked!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Httpdconf is not working");
        }
    }

    public String getServerRoot(){ return serverRoot; }
    public Integer getListen(){ return listen; }
    public String getDocumentRoot(){ return documentRoot; }
    public String getLogFile(){ return logFile; }
    public HashMap getAlias(){ return alias; }
    public HashMap getScriptAlias(){ return scriptAliases;}
    public String getAccessFileName(){ return accessFileName; }
    public String getDirectoryIndex() {
        if (directoryIndex.isEmpty()) {
            return "\\index.html";
        }
        else{
            return directoryIndex.get("DirectoryIndex");
        }
    }

//    public static void main(String [] args){
//        try {
//            HttpdConf hc = new HttpdConf("httpd.conf");
//            hc.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}