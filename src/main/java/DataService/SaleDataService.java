package DataService;

import PO.SaleFormPO;

public interface SaleDataService {
	
	public boolean insert(SaleFormPO saleFormPOPO);
	public boolean update(SaleFormPO saleFormPOPO);
	public SaleFormPO find(String id);
}
