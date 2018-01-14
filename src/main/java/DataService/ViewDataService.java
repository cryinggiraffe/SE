package DataService;

import java.sql.Date;
import java.util.List;

import PO.ImportFormPO;
import PO.InventoryPO;
import PO.SaleFormPO;

public interface ViewDataService {
	
	public List<InventoryPO> findInventoryForTime(Date begin, Date end);
	
	public List<SaleFormPO> findSaleFormForTime(Date begin, Date end);
	public List<ImportFormPO> findImportFormForTime(Date begin, Date end);
	
}
