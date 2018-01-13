package DataService;

import java.util.List;

import PO.Commodity;

public interface SaleCommodityDataService {
	
	public boolean insert(Commodity salecommodity, String saleformid);
	
	public List<Commodity> getForSaleformId(String saleformid);
}
