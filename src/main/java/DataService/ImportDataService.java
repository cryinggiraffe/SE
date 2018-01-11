package DataService;

import java.util.List;

import PO.ImportFormPO;

public interface ImportDataService {
	
	public boolean insert(ImportFormPO importFormPO);
	public boolean update(ImportFormPO importFormPO);
	public ImportFormPO find(String id);
	public List<ImportFormPO> findForState();
	public List<ImportFormPO> findForState_Commities();
	 
}
