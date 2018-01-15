package DataService;

import PO.UserPO;

public interface LoginDataService {
	
	public UserPO getUser(String username);
	
	public String getPassword(String username);

	
}
