package DataService;

import java.sql.Date;
import java.util.List;

import PO.LossPO;

public interface LossDataService {
	
	public boolean insert(LossPO lossPO);
	public boolean update(LossPO lossPO);
	public List<LossPO> findForId(String goodid);
	
	public List<LossPO> findForTime(Date begin, Date end);
	public List<LossPO> findForType();
}
