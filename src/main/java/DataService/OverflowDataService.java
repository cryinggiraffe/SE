package DataService;

import java.sql.Date;
import java.util.List;

import PO.OverflowPO;

public interface OverflowDataService {
	
	public boolean insert(OverflowPO overflowPO);
	public boolean update(OverflowPO overflowPO);
	public List<OverflowPO> findForId(String goodid);
	
	public List<OverflowPO> findForTime(Date begin, Date end);
	public List<OverflowPO> findForType();
}
