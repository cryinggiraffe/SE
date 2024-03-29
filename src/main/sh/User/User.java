package User;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String type;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String username, String password,String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", type=" + type + "]";
	}
	
	
	
}
