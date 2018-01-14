package DataService;

import java.sql.Date;
import java.util.List;

import PO.GiftPO;


public interface GiftDataService {
	
	public boolean insert(GiftPO giftPO);
	public boolean delete(String giftlistid);
	public boolean update(GiftPO giftPO);
	
	public List<GiftPO> list(String giftlistid);
	
	public List<GiftPO> findForTime(Date begin, Date end);
	//查找全部
	public List<GiftPO> findForType();
}
