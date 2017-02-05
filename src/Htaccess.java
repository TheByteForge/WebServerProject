import java.io.*;


public class Htaccess {
	//PRIVATE
    private Htpassword userFile;
    private String authType;
    private String authName;
    private String require;
    //PUBLIC
    public void load();
    public boolean isAuthorized(String username, String password);
}

pu