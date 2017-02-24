import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/* COMMON LOG FORMAT IS:
    IP       user                   date/time                   command             version   status bytes
   127.0.0.1 user-identifier frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326 */

public class ServerLogger {
    //private File file;

    private static final Logger logger = Logger.getLogger( ServerLogger.class.getName() );
    FileHandler fh;

    ServerLogger(String fileName) throws IOException {
        String filename = "C:\\Users\\Zack\\IdeaProjects\\HELLOWORLD\\src\\MyLogFile.log";
        FileHandler fh = new FileHandler(filename);
        SimpleFormatter formatter = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(formatter);
        System.out.println("Constructor called to create: " + filename);
    }

    public void write(Request request, Response response){
        //Request Logging
        logger.info("REQUEST LOG WRITE CALLED: ");
        logger.info(String.valueOf(request.getVerb()));
        logger.info(String.valueOf(request.getUri()));
        logger.info(String.valueOf(request.getHttpVersion()));

        //Response Logging
        logger.info("RESPONSE LOG WRITE CALLED: ");
        logger.info(String.valueOf(response.code));
        logger.info(String.valueOf(response.reasonPhrase));
        logger.info(String.valueOf(response.resource));
    }

    public static void main(String[] args) throws IOException {

        String file1 = "C:\\Users\\Zack\\IdeaProjects\\HELLOWORLD\\src\\MyLogFile.log";
        InetAddress addr = InetAddress.getLocalHost();
        //IP for localhost client
        String IPAddr = addr.getHostAddress();
        //Hostname of client
        String Host = addr.getHostName();
        // create date object
        Date date = new Date();
        //Display bytes of returned object
        String s = "some text here"; //REPLACE: bytes of response object returned to client
        byte[] objByteSize = s.getBytes("UTF-8");
        String byteValToStr = String.valueOf(objByteSize.length);

        try {
            ServerLogger sl = new ServerLogger(file1);
            logger.info("ServerLogger Object Created and File1 has been logged at: " + file1 + " with message: \n\n\n");
            logger.info(IPAddr + Host + date.toString());
            //logger.info(String.valueOf(request.getVerb()) + String.valueOf(request.uri) + String.valueOf(request.getHttpVersion()) + String.valueOf(response.code));
            logger.info(byteValToStr);
        } catch (IOException e) {
            logger.info("WARNING IN LOG MAIN: IO EXCEPTION");
            e.printStackTrace();
        }
    }
}
