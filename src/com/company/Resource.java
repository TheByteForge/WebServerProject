package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by DORIS on 2/20/2017.
 */
public class Resource {
    private String resourceURI;
    private HttpdConf resourceConf;
    //Experimental Iterator...WATCH OUT
    private Iterator it = null;
    private String [] tempLine;
    private String resolvedString;

    public Resource (String uri, HttpdConf config){
        resourceURI = uri;
        resourceConf = config;
    }

    public String absolutePath(){

        String resolvedPath = null;

        if(this.isScriptAliased()){
            resolvedPath = resourceURI.replaceFirst(tempLine[2], "") + resolvedString.replaceAll("\\\\", "/").replaceFirst("/", "");
            String givenPath = resourceURI +tempLine[2];
            System.out.print(resolvedPath);
        }
        else if(this.isAliased()){
            resolvedPath = resourceURI.replace(tempLine[2], "") + resolvedString.replaceAll("\\\\", "/").replaceFirst("/", "");
            String givenPath = resourceURI +tempLine[2];
            System.out.print(resolvedPath);

        }
//        else if(){
//
//        }




        return resolvedPath;
    }

    public boolean isScriptAliased() {
        it = resourceConf.getScriptAlias().entrySet().iterator();


        if (resourceURI != null) {
            tempLine = resourceURI.split("/");
            if (tempLine.length >= 2) {
                tempLine = resourceURI.split("/");

                while (it.hasNext()) {

                    Map.Entry pair = (Map.Entry) it.next();
//                    System.out.print(tempLine[2] + "            =             " + pair.getKey());
                    if (tempLine[2].equals(pair.getKey())) {

                        resolvedString = pair.getValue().toString().replaceAll("/", "");
                        System.out.print(resolvedString + "\n");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isAliased(){

        it = resourceConf.getAlias().entrySet().iterator();

        int count = 0;
        if (resourceURI != null) {
            tempLine = resourceURI.split("/");
            if (tempLine.length >= 2) {
//                tempLine = resourceURI.split("/");

                while (it.hasNext() || count == 1) {

                    Map.Entry pair = (Map.Entry) it.next();
                    if (tempLine[2].equals(pair.getKey())) {
                        resolvedString = pair.getValue().toString().replaceAll("/", "");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
