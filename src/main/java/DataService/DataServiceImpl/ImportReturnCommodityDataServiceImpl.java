package DataService.DataServiceImpl;

import java.util.List;

import DataService.ImportReturnCommodityDataService;
import JDBC.DAO;
import PO.Commodity;

public class ImportReturnCommodityDataServiceImpl implements ImportReturnCommodityDataService{

	DAO<Commodity> dao = new DAO<>();
	@Override
	public boolean insert(Commodity importreturncommodity, String importreturnformid) {
		// TODO Auto-generated method stub
		String sql =  "insert into ImportReturnCommodity(goodid, name, version, quantity, price, subtotalprice, remark, importformid) "
				   + "values(?,?,?,?,?,?,?,?)";
		
		return dao.update(sql, importreturncommodity.getGoodid(), importreturncommodity.getName(), importreturncommodity.getVersion(),
	               importreturncommodity.getQuantity(), importreturncommodity.getPirce(), importreturncommodity.getSubtotalprice(),
	               importreturncommodity.getRemark(), importreturnformid);
	
	}

	@Override
	public List<Commodity> getForImportId(String importreturnformid) {
		// TODO Auto-generated method stub
		String sql = "select  goodid, name, version, quantity, price, subtotalprice, remark from ImportReturnCommodity where importformid = ?";
		return dao.getALL(Commodity.class, sql, importreturnformid);
	}

}
