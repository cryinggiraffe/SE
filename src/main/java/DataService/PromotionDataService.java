package Dataservice;

import java.util.List;

import PO.PromotionPO;

public interface PromotionDataService {
	
	public boolean insert(PromotionPO promotionPO);
	public boolean delete(PromotionPO promotionPO);
	public boolean update(PromotionPO promotionPO);
	public List<PromotionPO> findAll();
}
