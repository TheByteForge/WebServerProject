import java.net.*;
import java.io.*;

public class Server{
    private static HttpdConf hc;
    private static MimesTypes mt;

    public static void main( String[] args ) throws IOException {
        hc = new HttpdConf("httpd.conf");
        mt = new MimesTypes("mime.types");

        ServerSocket listenPort = new ServerSocket(hc.listen);

        while( true ) {

            Socket clientSocket = listenPort.accept();
            outputRequest( clientSocket );
            sendResponse( clientSocket );
            clientSocket.close();
        }
    }

    protected static void outputRequest( Socket client ) throws IOException {
        String line;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader( client.getInputStream() )
        );

        while( true ) {
            line = reader.readLine();
            System.out.println( "> " + line );

            // Why do we need to do this?
            if( line.contains( "END" ) ) {
                break;
            }
        }
        outputLineBreak();
        Request newReq = new Request(client.getInputStream());
    }

    protected static void outputLineBreak() {
        System.out.println( "-------------------------" );
    }

    protected static void sendResponse( Socket client ) throws IOException {
        PrintWriter out = new PrintWriter( client.getOutputStream(), true );
        int gift = (int) Math.ceil( Math.random() * 100 );
        String response = "Gee, thanks, this is for you: " + gift;

        out.println( response );

        outputLineBreak();
        System.out.println( "I sent: " + response );
    }
}