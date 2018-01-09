package DataService.DataServiceImpl;

import DataService.LoginDataService;
import JDBC.DAO;
import PO.UserPO;

public class LoginDataServiceImpl implements LoginDataService{

	DAO<UserPO> dao = new DAO<>();
	@Override
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		String sql = "select username, password from User where username = ?";
		UserPO userPo = dao.get(UserPO.class, sql, username);
		return userPo.getPassword();
	}
	
	@Override
	public UserPO getUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select username, password, userclass, type from User where username = ?";
		return dao.get(UserPO.class, sql, username);
	}

}
