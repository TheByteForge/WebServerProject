import java.io.*;


public class Htpassword {
	//PRIVATE
    private Dictionary users;
    //PUBLIC
    public void load();
    public boolean isAuthorized(String username, String password);
}