package com.company;


import java.io.*;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;


public class MimesTypes extends ConfigurationReader {
    private HashMap<String, String> types = new HashMap<>();

    public MimesTypes() {
    }

    public MimesTypes(String fileName) throws IOException {
        super(fileName);

        file = new File (fileName);
        inputStream = new FileInputStream(file);

        br = new BufferedReader(new InputStreamReader(inputStream));

    }

    public String lookup(String extension) {

        if (types.containsKey(extension)) {
            return types.get(extension);
        } else {
            return null;
        }
    }

    public void load() {

        try {
            while (hasMoreLines()) {

                String line = nextLine();

                //Disregard anything after a #
                if (!line.contains("#")) {
                    //Split by spaces
                    currentLine = line.split("\\s+");
                    //If NO EXTENSIONS add path to map, then a "default" string
                    if (currentLine.length == 1) {
                        types.put(currentLine[0], null);
                    }
                    //If there IS AN EXTENSION, add the unique extension then the path
                    else {
                        for (int i = 1; i < currentLine.length; i++) {
                            types.put(currentLine[i], currentLine[0]);
                        }
                    }
                }

            }
            System.out.println("MimeType creation worked!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap getTypes(){
        return types;
    }

    public static void main(String[] args) {
        try {
            MimesTypes mt = new MimesTypes("mime.types");
            mt.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Mimetypes is not working...");
        }

    }

}