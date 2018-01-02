package Dataservice;

import PO.ImportFormPO;

public interface ImportDataService {
	
	public boolean insert(ImportFormPO importFormPO);
	public boolean update(ImportFormPO importFormPO);
	public ImportFormPO find(String id);
}
