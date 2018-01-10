package DataService;

import PO.UserPO;

public interface AdministratorDataService {
	
	public boolean insert(UserPO userPO);
	public boolean delete(String username);
	
}
