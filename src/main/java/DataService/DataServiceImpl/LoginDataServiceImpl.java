package DataService.DataServiceImpl;

import JDBC.DAO;
import PO.UserPo;
import dataService.LoginDataService;

public class LoginDataServiceImpl implements LoginDataService{

	DAO<UserPo> dao = new DAO<>();
	@Override
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		String sql = "select username, password from User where username = ?";
		UserPo userPo = dao.get(UserPo.class, sql, username);
		return userPo.getPassword();
	}

}
