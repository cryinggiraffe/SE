package Login;

public class Login {
	
	private String username;
	private String password;
	private String type;
	
	public boolean login(String username, String password, String type){
		
		boolean flag1 = this.username.equals(username);
		boolean flag2 = this.password.equals(password);
		boolean flag3 = this.type.equals(type);
		
		boolean login_status = false;
		
		if(flag1&&flag2&&flag3){
			login_status = true;
			return login_status;
		}else{
			login_status = false;
			return login_status;
		}
	}
}
