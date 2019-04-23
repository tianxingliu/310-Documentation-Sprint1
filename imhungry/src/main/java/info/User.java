package info;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class User {
	public String password;
	public String uname;
	
	public User(String uname,String password) {
		this.uname = uname;
		this.password = password;
	}
	
}
