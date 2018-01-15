package DataService;

import java.sql.Date;
import java.util.List;

import PO.InventoryPO;

public interface InventoryDataService {
	
	public boolean insert(InventoryPO inventoryPO);
	
	public List<InventoryPO> findForTime(Date date);
	public List<InventoryPO> findAll();
}
