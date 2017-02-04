import java.io.*;


public class MimeTypes {
	//PRIVATE
    private Dictionary types;
    //-etc ?

    //PUBLIC
    public MimeTypes( String fileName );
    public void load();
    public lookup( String extension );
}