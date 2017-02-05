/**
 * Created by euphoric on 2/4/17.
 */

import java.io.*;


public abstract class ConfigurationReader {

    private File file;
    private BufferedReader bufferedReader = null;

    public ConfigurationReader(String fileName)
    {
        String path = "~/WebServerProject/config/" + fileName;
        file = new File(path);
        bufferedReader = new BufferReader(new FileReader(file));
    }

    public boolean hasMoreLines()
    {
        if(bufferedReader.nextLine() != -1){
            return true;
        } else {
            return false;
        }
    }

    public String nextLine()
    {
        return bufferedReader.nextLine();
    }


    public abstract void load();

    protected boolean skipLine(String line) {
        String firstCharacter = line.substring(0,1);

        if(line.isEmpty()){
            return true;

        } else if(firstCharacter == "#") {
            return true;

        } else {
            return false;
        }
    }
}
