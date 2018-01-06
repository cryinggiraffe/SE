package PO;

public class UserPO {
	
	private String username;
	private String password;
	
	public UserPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserPo [username=" + username + ", password=" + password + "]";
	}
	
	
}
