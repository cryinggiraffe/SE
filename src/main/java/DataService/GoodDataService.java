package DataService;

import java.util.List;

import PO.GoodPO;

public interface GoodDataService {
	
	public boolean insert(GoodPO goodPO);
	public boolean delete(GoodPO goodPO);
	public boolean update(GoodPO goodPO);
	public List<GoodPO> list();
	
}
