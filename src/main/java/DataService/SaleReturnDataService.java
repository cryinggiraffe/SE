package DataService;

import java.sql.Date;
import java.util.List;

import PO.SaleFormPO;

public interface SaleReturnDataService {
	
	public boolean insert(SaleFormPO saleFormPO);
	public boolean update(SaleFormPO saleFormPO);
	public SaleFormPO find(String id);
	
	public List<SaleFormPO> findForState();
	public List<SaleFormPO> findForState_Commities();
	
	public List<SaleFormPO> findForTime(Date begin, Date end);
	public List<SaleFormPO>	findForType(); 
	public List<SaleFormPO> findForClient(String client);
	public List<SaleFormPO> findForSalesman(String salesman);
	public List<SaleFormPO> findForHouseWare(String houseware);
	
}
