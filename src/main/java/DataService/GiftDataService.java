package DataService;

import java.util.List;

import PO.GiftPO;
import PO.GoodPO;

public interface GiftDataService {
	
	public boolean insert(GoodPO goodPO);
	public boolean delete();
	public boolean update(GiftPO giftPO);
	
	public List<GiftPO> list();
}
