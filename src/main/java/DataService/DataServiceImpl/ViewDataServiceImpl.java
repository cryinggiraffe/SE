package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.ViewDataService;
import JDBC.DAO;
import PO.ImportFormPO;
import PO.InventoryPO;
import PO.SaleFormPO;

public class ViewDataServiceImpl implements ViewDataService{

	DAO<InventoryPO> dao = new DAO<>();
	@Override
	public List<InventoryPO> findInventoryForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select * from Inventory where date <= ? and date >= ?";
		return dao.getALL(InventoryPO.class, sql, begin, end);
	}

	
	BusinessProcessDataServiceImpl businessProcessDataServiceImpl = new BusinessProcessDataServiceImpl();
	@Override
	public List<SaleFormPO> findSaleFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return businessProcessDataServiceImpl.findSaleFormForTime(begin, end);
	}

	@Override
	public List<ImportFormPO> findImportFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return businessProcessDataServiceImpl.findImportFormForTime(begin, end);
	}

}
