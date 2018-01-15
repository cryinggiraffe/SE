package DataService;

import java.util.List;

import PO.Commodity;

public interface ImportReturnCommodityDataService {
	
	public boolean insert(Commodity importreturncommodity, String importreturnformid);
	
	public List<Commodity> getForImportId(String id);
	
}
