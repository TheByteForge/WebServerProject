import java.io.*;
import java.util.*;

public class HttpdConf extends ConfigurationReader{
    private String serverRoot = null;
    protected Integer listen = 0;
    protected String documentRoot = null;
    protected String logFile = null;
	private HashMap <String, String> alias = new HashMap<>();
    private HashMap <String, String> scriptAliases = new HashMap<>();
    private String accessFileName = null;
    private HashMap <String, String> directoryIndex = new HashMap<>();
    protected String [] currentLine = {""};


    public HttpdConf (){}

	public HttpdConf(String fileName)throws IOException{
		String confPath = "C:\\Users\\Zack\\Desktop\\DZWS\\conf\\";
        file = new File(confPath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));

        try{

            while (hasMoreLines()){
                String tempLine = nextLine();
                currentLine = tempLine.split("\\s+");
                if(currentLine[0] != "#" && currentLine[0] != " ") {

                    for (int i = 1; i < currentLine.length; i++) {
                        switch (currentLine[0]) {
                            case "ServerRoot":
                                serverRoot = currentLine[1];
                                System.out.println(serverRoot);
                                break;
                            case "Listen":
                                listen = Integer.parseInt(currentLine[1]);
                                System.out.println(listen);
                                break;
                            case "DocumentRoot":
                                documentRoot = currentLine[1];
                                System.out.println(documentRoot);
                                break;
                            case "LogFile":
                                logFile = currentLine[1];
                                System.out.println(logFile);
                                break;
                            case "Alias":
                                alias.put(currentLine[1], currentLine[2]);
                                System.out.println(serverRoot);
                                break;
                            case "ScriptAliases":
                                scriptAliases.put(currentLine[1], currentLine[2]);
                                System.out.println(serverRoot);
                                break;
                            case "AccessFilename":
                                accessFileName = currentLine[1];
                                System.out.println(serverRoot);
                                break;
                            case "DirectoryIndex":
                                directoryIndex.put(currentLine[1], currentLine[2]);
                                System.out.println(serverRoot);
                                break;
                            default:
                                break;
                        }

                    }
                }


            }

            br.close();
            if(inputStream!=null){
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){}


    public static void main(String [] args){
        try {
            HttpdConf hc = new HttpdConf("httpd.conf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


