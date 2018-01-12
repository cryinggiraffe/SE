package DataService.DataServiceImpl;

import JDBC.DAO;
import PO.AccountPO;
import DataService.AccountDataService;

public class AccountDataServiceImpl implements AccountDataService{

	DAO<AccountPO> dao = new DAO<>();
	@Override
	public boolean insert(AccountPO accountPO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO Account VALUES(?,?)";
		return dao.update(sql, accountPO.getName() , accountPO.getBalance());
	}

	@Override
	public boolean delete(AccountPO accountPO) {
		// TODO Auto-generated method stub
		String sql = "delete from Account where name = ?";
		return dao.update(sql, accountPO.getName());
	}

	@Override
	public boolean update(AccountPO accountPO) {
		// TODO Auto-generated method stub
		String sql = "update Account set balance = ? where name = ?";
		return dao.update(sql, accountPO.getBalance(), accountPO.getName() );
		
	}

	@Override
	public AccountPO find(String name) {
		// TODO Auto-generated method stub
		String sql = "select balance from Account where name = ?";
		return dao.get(AccountPO.class, sql, name);
	}

}
