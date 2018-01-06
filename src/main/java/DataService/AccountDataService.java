package DataService;

import PO.AccountPO;

public interface AccountDataService {
	
	public boolean insert(AccountPO accountPO);
	public boolean delete(AccountPO accountPO);
	public boolean update(AccountPO accountPO);
	public AccountPO find(String name);
}
