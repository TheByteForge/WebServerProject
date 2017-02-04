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

}
