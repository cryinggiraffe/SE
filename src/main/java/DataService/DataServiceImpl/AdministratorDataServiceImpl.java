package DataService.DataServiceImpl;

import DataService.AdministratorDataService;
import JDBC.DAO;
import PO.UserPO;
import User.User;

import java.util.List;

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

	@Override
	public boolean update(UserPO userPO) {
		// TODO Auto-generated method stub
		String sql = "update User set username = ?, password = ?, userclass = ?, type = ? where username = ?";
		return dao.update(sql, userPO.getUsername(), userPO.getPassword(), userPO.getUserclass(), userPO.getType(),userPO.getUsername());
	}
	
	@Override
	public UserPO getUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select username, password, userclass, type from User where username = ?";
		return dao.get(UserPO.class, sql, username);
	}

	@Override
	public List<UserPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from User";
		return dao.getALL(UserPO.class, sql);
	}

}
