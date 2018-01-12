package DataService.DataServiceImpl;

import java.util.List;

import DataService.ImportReturnDataService;
import JDBC.DAO;
import PO.Commodity;
import PO.ImportFormPO;

public class ImportReturnDataServiceImpl implements ImportReturnDataService{

	DAO<ImportFormPO> dao = new DAO<>();
	ImportReturnCommodityDataServiceImpl importReturnCommodityDataServiceImpl = new ImportReturnCommodityDataServiceImpl();
	@Override
	public boolean insert(ImportFormPO importReturnFormPO) {
		// TODO Auto-generated method stub
		String sql = "insert into ImportReturnForm values(?,?,?,?,?,?,?)";
		return dao.update(sql, importReturnFormPO.getId(), importReturnFormPO.getProvider(), importReturnFormPO.getHouseware(), 
				          importReturnFormPO.getOperator(), importReturnFormPO.getRemark(), importReturnFormPO.getSum(),
				          importReturnFormPO.getState());
		
	}

	@Override
	public boolean update(ImportFormPO importReturnFormPO) {
		// TODO Auto-generated method stub
		String sql = "update ImportReturnForm set state = ? where id = ?";
		return dao.update(sql, "yes", importReturnFormPO.getId());
	}

	@Override
	public ImportFormPO find(String importformid) {
		// TODO Auto-generated method stub
		List<Commodity> commodities = importReturnCommodityDataServiceImpl.getForImportId(importformid);
		
		String sql = "select id, provider, houseware, operator, remark, sum, state from ImportReturnForm where id = ?";
		ImportFormPO importFormPO = dao.get(ImportFormPO.class, sql, importformid);
		importFormPO.setImportcommoditylist(commodities);
		return importFormPO;
		
	}

	@Override
	public List<ImportFormPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state from ImportReturnForm where state = ?";
		
		return dao.getALL(ImportFormPO.class, sql, "no");
	}

	@Override
	public List<ImportFormPO> findForState_Commities() {
		// TODO Auto-generated method stub
		ImportReturnDataService importReturnDataService = new ImportReturnDataServiceImpl();
		List<ImportFormPO> importFormPOs =  importReturnDataService.findForState();
		
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importReturnCommodityDataServiceImpl.getForImportId(importFormPO.getId()));
		}
		return importFormPOs;
	}



}
