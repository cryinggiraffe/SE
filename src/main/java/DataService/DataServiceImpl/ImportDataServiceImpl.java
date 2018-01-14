package DataService.DataServiceImpl;

import java.sql.Date;
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
		String sql = "update ImportForm set provider = ？, houseware = ？, operator = ？, remark = ？, sum = ？, state = ？, date = ？where id = ?";
		return dao.update(sql, importFormPO.getProvider(), importFormPO.getHouseware(), importFormPO.getOperator(), 
		          			   importFormPO.getRemark(), importFormPO.getSum(),importFormPO.getState(), importFormPO.getDate());
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

	@Override
	public List<ImportFormPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state,date from ImportForm where date >= ? and date <= ?";
		return dao.getALL(ImportFormPO.class, sql, begin, end);
	}

	@Override
	public List<ImportFormPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state,date from ImportForm";
		return dao.getALL(ImportFormPO.class, sql);
	}

	@Override
	public List<ImportFormPO> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state,date from ImportForm where provider = ?";
		return dao.getALL(ImportFormPO.class, sql, client);
	}

//	@Override
//	public List<ImportFormPO> findForSalesman(String salesman) {
//		// TODO Auto-generated method stub
//		String sql = "select id, provider, houseware, operator, remark, sum, state,date from ImportForm "
//		return null;
//	}

	@Override
	public List<ImportFormPO> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		String sql = "select id, provider, houseware, operator, remark, sum, state, date from ImportForm where houseware = ?";
		return dao.getALL(ImportFormPO.class, sql, houseware);
	}
	
	
}
