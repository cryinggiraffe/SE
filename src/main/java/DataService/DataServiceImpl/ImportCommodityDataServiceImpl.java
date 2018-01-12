package DataService.DataServiceImpl;

import java.util.List;

import DataService.ImportCommodityDataService;
import JDBC.DAO;
import PO.Commodity;

public class ImportCommodityDataServiceImpl implements ImportCommodityDataService{

	DAO<Commodity> dao = new DAO<>();
	@Override
	public boolean insert(Commodity importcommodity,String importformid) {
		// TODO Auto-generated method stub
		String sql = "insert into ImportCommodity(goodid, name, version, quantity, price, subtotalprice, remark, importformid) "
				   + "values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, importcommodity.getGoodid(), importcommodity.getName(), importcommodity.getVersion(),
				               importcommodity.getQuantity(), importcommodity.getPirce(), importcommodity.getSubtotalprice(),
				               importcommodity.getRemark(), importformid);
	}

	@Override
	public List<Commodity> getForImportformId(String importformid) {
		// TODO Auto-generated method stub
		String sql = "select  goodid, name, version, quantity, price, subtotalprice, remark from ImportCommodity where importformid = ?";
		return dao.getALL(Commodity.class, sql, importformid);
	}

}
