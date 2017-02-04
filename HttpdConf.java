import java.io.*;


public class HttpdConf {
	//PRIVATE
    private Dictionary aliases;
    private Dictionary scriptAliases;
    //-etc ?

    //PUBLIC
    public HttpdConf( String fileName );
    public void load();
}