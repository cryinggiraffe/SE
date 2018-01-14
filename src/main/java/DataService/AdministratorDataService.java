package DataService;

import PO.UserPO;

import java.util.List;

public interface AdministratorDataService {
	
	public boolean insert(UserPO userPO);
	public boolean delete(String username);
	public boolean update(UserPO userPO);
	public UserPO getUser(String username);
	public List<UserPO> findAll();
}
