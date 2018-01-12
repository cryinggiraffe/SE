package DataService;

import java.util.List;

import PO.SaleFormPO;

public interface SaleReturnDataService {
	
	public boolean insert(SaleFormPO saleFormPO);
	public boolean update(SaleFormPO saleFormPO);
	public SaleFormPO find(String id);
	
	public List<SaleFormPO> findForState();
	public List<SaleFormPO> findForState_Commities();
	
}
