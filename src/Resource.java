package com.company;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Resource {
    private String resURI;
    private HttpdConf resConfig;
    //Experimental Iterator...WATCH OUT
    private Iterator it = null;
    private String [] tempLine;

    public Resource (String uri, HttpdConf config){
        resURI = uri;
        System.out.print(resURI);
        resConfig = config;
    }

    public String absolutePath(){
        return resConfig.getDocumentRoot();
    }

    public boolean isScriptAliased(){
        tempLine = resURI.split("/");
        it = resConfig.getScriptAlias().entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.print(tempLine[1] + "            =             " + pair.getKey());
            if (tempLine[1] == pair.getKey());
                System.out.println(tempLine[1] + ":  " + pair.getKey());

        }
        return true;
    }
//    public boolean isAliased(){
//
//    }

    public boolean isProtected(){
        return true;
    }

//    public static void main(String[]args){
//        try{
//            Resource rs = new Resource
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.print("Resource Broken when instatiating!");
//        }
//    }
}
