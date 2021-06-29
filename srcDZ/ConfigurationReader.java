import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ConfigurationReader {

    protected File file;
    protected BufferedReader br;
    protected String [] currentLine = {""};

    public ConfigurationReader(){

    }

    public boolean hasMoreLines() throws IOException{

        if(currentLine[0] != null){ return true; }

        else{ return false; }
    }

    protected String nextLine() throws IOException{
        try{
            return br.readLine();

        } catch (IOException e) { e.printStackTrace(); }
        return null;
    }

    public abstract void load();

    public ConfigurationReader(String fileName) throws IOException{}


}