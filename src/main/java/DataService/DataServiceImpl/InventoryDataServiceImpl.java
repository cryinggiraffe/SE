package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.InventoryDataService;
import JDBC.DAO;
import PO.InventoryPO;

public class InventoryDataServiceImpl implements InventoryDataService{

	DAO<InventoryPO> dao = new DAO<>();
	@Override
	public boolean insert(InventoryPO inventoryPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Inventory (goodid, goodname, type, price, batch, batch_num, date) values(?,?,?,?,?,?,?,?)";  
		return dao.update(sql, inventoryPO.getGoodid(), inventoryPO.getGoodname(), inventoryPO.getType(),
				               inventoryPO.getPrice(), inventoryPO.getBatch(), inventoryPO.getBatch_num(),
				               inventoryPO.getDate());
	}

	@Override
	public List<InventoryPO> findForTime(Date date) {
		// TODO Auto-generated method stub
		String sql = "select * from Inventory where date = ? ";
		return dao.getALL(InventoryPO.class, sql, date);
	}

	@Override
	public List<InventoryPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Inventory";
		return dao.getALL(InventoryPO.class, sql);
	}

}
