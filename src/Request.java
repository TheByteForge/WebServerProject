import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Request {
    private String uri;
    //private body;
    private String verb;
    private String httpVersion;
    private Dictionary <String, String> directoryIndex = new Hashtable<>();
    private BufferedReader br;

    protected String [] currentLine = {""};

    public Request(InputStream is)throws IOException{

        //Defintes buffered reader from passed in stream (is)
            br = new BufferedReader(new InputStreamReader(is));

            String tempLine;
            tempLine = br.readLine();
            currentLine = tempLine.split("\\\\");

            //Testing to make sure it splits correctly
            System.out.println(currentLine[0] + currentLine[1] + currentLine[2]);
            verb = currentLine[0];
            uri = currentLine[1];
            httpVersion = currentLine[2];

            if(currentLine[0].equals("GET")){
                //GET COMMAND
            }
            else if(currentLine[0].equals("PUT")){
                //PUT COMMAND
            }

    }
    public void parse(){

    }
    public String getUri(){
        return uri;
    }
    public String getVerb(){
        return verb;
    }
    public String getHttpVersion(){
        return httpVersion;
    }
    public static void main(String [] args){
//        try {
//            String test = "GET\\google.com\\http/1.1";
////            Request r = new Request(test);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
