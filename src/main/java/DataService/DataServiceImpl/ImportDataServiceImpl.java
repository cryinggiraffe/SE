package DataService.DataServiceImpl;

import java.util.List;

import DataService.ImportDataService;
import JDBC.DAO;
import PO.Commodity;
import PO.ImportFormPO;

public class ImportDataServiceImpl implements ImportDataService{

	DAO<ImportFormPO> dao = new DAO<>();
	ImportCommodityDataServiceImpl importCommodityDataServiceImpl = new ImportCommodityDataServiceImpl();
	
	@Override
	public boolean insert(ImportFormPO importFormPO) {
		// TODO Auto-generated method stub
		String sql = "insert into ImportForm values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, importFormPO.getId(), importFormPO.getProvider(), importFormPO.getHouseware(), 
				          importFormPO.getOperator(), importFormPO.getRemark(), importFormPO.getSum(),
				          importFormPO.getState(),importFormPO.getDate());
	}

	@Override
	public boolean update(ImportFormPO importFormPO) {
		// TODO Auto-generated method stub
		String sql = "update ImportForm set state = ? where id = ?";
		return dao.update(sql, "yes", importFormPO.getId());
	}

	@Override
	public ImportFormPO find(String importformid) {
		// TODO Auto-generated method stub
		List<Commodity> commodities = importCommodityDataServiceImpl.getForImportformId(importformid);
		
		String sql = "select id, provider, houseware, operator, remark, sum, state, date from ImportForm where id = ?";
		ImportFormPO importFormPO = dao.get(ImportFormPO.class, sql, importformid);
		importFormPO.setImportcommoditylist(commodities);
		return importFormPO;
	}

	@Override
	public List<ImportFormPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state,date from ImportForm where state = ?";
		
		return dao.getALL(ImportFormPO.class, sql, "no");
	}

	@Override
	public List<ImportFormPO> findForState_Commities() {
		// TODO Auto-generated method stub
		ImportDataService importDataService = new ImportDataServiceImpl();
		List<ImportFormPO> importFormPOs =  importDataService.findForState();
		
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}
	
	
}
