package DataService;

import java.sql.Date;
import java.util.List;

import PO.ImportFormPO;

public interface ImportDataService {
	
	public boolean insert(ImportFormPO importFormPO);
	public boolean update(ImportFormPO importFormPO);
	public ImportFormPO find(String id);
	public List<ImportFormPO> findForState();
	public List<ImportFormPO> findForState_Commities();
	
	public List<ImportFormPO> findForTime(Date begin, Date end);
	public List<ImportFormPO> findForType(); 
	public List<ImportFormPO> findForClient(String client);
//	public List<ImportFormPO> findForSalesman(String salesman);
	public List<ImportFormPO> findForHouseWare(String houseware);
	 
}
