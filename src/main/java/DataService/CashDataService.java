package DataService;

import java.util.List;

import PO.CashPO;

public interface CashDataService {
	
	public boolean insert(CashPO cashPO);
	public boolean update(CashPO cashPO);
	public CashPO findForListId(String listid);
	public List<CashPO> findForList(String listid);
	
}
