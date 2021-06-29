import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class MimesTypes extends ConfigurationReader{
	private Dictionary <String, String> types = new Hashtable();
	public MimesTypes(){}

    public MimesTypes(String fileName)throws IOException{

        String confPath = "C:\\Users\\Zack\\Desktop\\DZWS\\conf\\";
        file = new File(confPath + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            while (hasMoreLines()) {
                String tempLine = nextLine();
//              System.out.print(tempLine  +" ");
                if (!tempLine.startsWith("#") && !tempLine.startsWith(" ")) {
                    currentLine = tempLine.split("\\s+");
                }


                if (currentLine[0] != "\\s+" && currentLine[0] != "\n" ) {
//
//                    for (int i = 1; i < currentLine.length; i++) {
//
//                        if (currentLine[i] != null) {
//                            types.put(currentLine[0], currentLine[i]);
//                                System.out.print(currentLine[0] + " " + currentLine[i] + "\n");
//                        } else {
//                            types.put(currentLine[0], "default");
//                                System.out.print(currentLine[0] + " " + currentLine[i] + "\n");
//                        }
//                    }
                    System.out.print(currentLine[0] + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        }

	public String lookup(String extension){
		return extension;
	}

	public void load(){

	}
	public static void main(String [] args){
	    try {
            MimesTypes mt = new MimesTypes("mime.types");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}