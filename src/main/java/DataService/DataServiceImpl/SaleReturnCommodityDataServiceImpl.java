package DataService.DataServiceImpl;

import java.util.List;

import DataService.SaleReturnCommodityDataService;
import JDBC.DAO;
import PO.Commodity;

public class SaleReturnCommodityDataServiceImpl implements SaleReturnCommodityDataService{

	DAO<Commodity> dao = new DAO<>();
	@Override
	public boolean insert(Commodity salecommodity, String saleformid) {
		// TODO Auto-generated method stub
		String sql = "insert into SaleReturnCommodity(goodid, name, version, quantity, price, subtotalprice, remark, saleformid) "
				   + "values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, salecommodity.getGoodid(), salecommodity.getName(), salecommodity.getVersion(), 
	               salecommodity.getQuantity(), salecommodity.getPirce(), salecommodity.getSubtotalprice(),
	               salecommodity.getRemark(), saleformid);
	}

	@Override
	public List<Commodity> getForSaleformId(String saleformid) {
		// TODO Auto-generated method stub
		String sql = "select  goodid, name, version, quantity, price, subtotalprice, remark from SaleCommodity where saleformid = ?";
		return dao.getALL(Commodity.class, sql, saleformid);
	}

}
