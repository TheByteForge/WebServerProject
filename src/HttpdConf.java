

public class HttpdConf extends ConfiguarationReader {

    private Map<String, String> aliases = null;
    private Map<String, String> scriptAliases = null;

    private String serverRoot = null;
    private String documentRoot = null;
    private String logFile = null;
    private String AccessFileName = null;

    private int listen = -1;

    private String documentRoot = null;


    public HttpdConf(String fileName)
    {
        super(fileName);
        aliases = new HashTable<String,String>;
        scriptAliases = new HashTable<String, String>;
    }

    public void load()
    {
        String temp = null;

        while(hasMoreLines()){
            temp = nextLine();

            if(skipLine()){
                continue;
            }

            String[] options = temp.split(" ");

            switch (options[0]) {
                case "ServerRoot":
                    serverRoot = options[1];
                    break;

                case "Listen":
                    listen = (int) options[1];
                    break;

                case "DocumentRoot" :
                    documentRoot = options[1];
                    break;

                case "LogFile":
                    logFile = options[1];
                    break;

                case "Alias":
                    aliases.put(options[1], options[2]);
                    break;

                case "ScriptAlias":
                    scriptAliase.put(options[1], options[2]);
                    break;

                case "AccessFileName":
            }
        }
    }
}