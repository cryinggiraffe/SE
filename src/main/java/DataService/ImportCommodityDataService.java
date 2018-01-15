package DataService;

import java.util.List;

import PO.Commodity;

public interface ImportCommodityDataService {
	
	public boolean insert(Commodity importcommodity, String importformid);
	
	public List<Commodity> getForImportformId(String importformid);
	
	
}
