package DataService;

import java.util.List;

import PO.Commodity;

public interface ImportCommodityDataService {
	
	public boolean insert(Commodity Commodity, String importformid);
	
	public List<Commodity> getForImportId(String id);
	
	
}
