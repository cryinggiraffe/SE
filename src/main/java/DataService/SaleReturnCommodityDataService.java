package DataService;

import java.util.List;

import PO.Commodity;

public interface SaleReturnCommodityDataService {
	
	public boolean insert(Commodity salecommodity, String saleformid);
	
	public List<Commodity> getForSaleformId(String saleformid);
}
