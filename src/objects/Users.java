package objects;

import java.io.Serializable;

public class Users implements Serializable{

	private String username, password;
		
	public Users (String username, String password) {
		this.username = username;
		this.password = password;
	}

	// gets
	public String getusername() {
		return username;
	}
	
	public String getpassword() {
		return password;
	}
	
	// sets
	public void setusername(String username) {
		this.username = username;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
}
