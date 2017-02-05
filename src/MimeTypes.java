import java.io.*;


public class MimeTypes{

    private Map<String, String> types;

    public MimeTypes(String fileName)
    {
        super(fileName);
        types = new HashMap<String, String>;
    }

    public void load()
    {
        String temp;

        while(hasNextLine()){
            if(skipLine()){
                continue;
            }

            temp = nextLine();
            String[] values = temp.split(" ");

            if(values.length() != 1){
                for(int index = 1; index < values.length(); index++){
                    types.put(values[index] , value[0]);
                }
            }
        }
    }

    public String lookup(String extension)
    {
        if(types.contains(extension)){
            return types.get(extension);
        } else {
            return null;
        }
    }
}