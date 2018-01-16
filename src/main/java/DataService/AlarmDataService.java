package DataService;

import java.sql.Date;
import java.util.List;

import PO.AlarmPO;

public interface AlarmDataService {
	
	public boolean insert(AlarmPO alarmPO);
	public boolean update(AlarmPO alarmPO);
	public List<AlarmPO> findForId(String goodid);
	
	public List<AlarmPO> findForTime(Date begin, Date end);
	public List<AlarmPO> findForType();
	
}
