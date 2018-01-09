package PO;

public class UserPO {
	
	private String username;
	private String password;
	private int userclass;
	private String type;
	
	public UserPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public UserPO(String username, String password, int userclass, String type) {
		super();
		this.username = username;
		this.password = password;
		this.userclass = userclass;
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
	public int getUserclass() {
		return userclass;
	}
	public void setUserclass(int userclass) {
		this.userclass = userclass;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "UserPO [username=" + username + ", password=" + password + ", userclass=" + userclass + ", type=" + type
				+ "]";
	}
	
	
	
	
}
