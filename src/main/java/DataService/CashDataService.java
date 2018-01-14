package DataService;

import java.sql.Date;
import java.util.List;

import PO.CashPO;

public interface CashDataService {
	
	public boolean insert(CashPO cashPO);
	public boolean update(CashPO cashPO);
	public CashPO findForListId(String listid);
	public List<CashPO> findForList(String listid);
	
	
	public List<CashPO> findForTime(Date begin, Date end);
	public List<CashPO> findForType();
	public List<CashPO> findForClient(String client);
	
}
