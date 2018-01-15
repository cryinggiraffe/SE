package DataService;

import java.sql.Date;
import java.util.List;

import PO.IncomePO;

public interface IncomeDataService {
	
	public boolean insert(IncomePO incomePO);
	public List<IncomePO> findForTime(Date begin, Date end);
	public List<IncomePO> findAll();
}
