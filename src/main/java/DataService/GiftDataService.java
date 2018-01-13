package DataService;

import java.util.List;

import PO.GiftPO;


public interface GiftDataService {
	
	public boolean insert(GiftPO giftPO);
	public boolean delete(String giftlistid);
	public boolean update(GiftPO giftPO);
	
	public List<GiftPO> list(String giftlistid);
}
