package DataService.DataServiceImpl;

import DataService.AdministratorDataService;
import JDBC.DAO;
import PO.UserPO;

public class AdministratorDataServiceImpl implements AdministratorDataService{

	DAO<UserPO> dao = new DAO<>();
	
	@Override
	public boolean insert(UserPO userPO) {
		// TODO Auto-generated method stub
		String sql = "Insert into User values(?,?,?,?)";
		return dao.update(sql, userPO.getUsername(), userPO.getPassword(), userPO.getUserclass(), userPO.getType());
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		String sql = "delete from User where username = ?";
		return dao.update(sql, username);
	}

}
