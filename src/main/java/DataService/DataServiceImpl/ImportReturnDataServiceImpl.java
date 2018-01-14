package DataService.DataServiceImpl;

import java.sql.Date;
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
		String sql = "insert into ImportReturnForm values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, importReturnFormPO.getId(), importReturnFormPO.getClient(), importReturnFormPO.getHouseware(),
				          importReturnFormPO.getOperator(), importReturnFormPO.getRemark(), importReturnFormPO.getSum(),
				          importReturnFormPO.getState(),importReturnFormPO.getDate());
		
	}

	@Override
	public boolean update(ImportFormPO importReturnFormPO) {
		// TODO Auto-generated method stub
		String sql = "update ImportReturnForm set client = ?, houseware = ?, operator = ?, remark = ?, sum = ?, state = ?, date = ? where id = ?";
		return dao.update(sql, importReturnFormPO.getClient(), importReturnFormPO.getHouseware(), importReturnFormPO.getOperator(),
		          			   importReturnFormPO.getRemark(), importReturnFormPO.getSum(),importReturnFormPO.getState(), importReturnFormPO.getDate(),importReturnFormPO.getId());
	}

	@Override
	public ImportFormPO find(String importformid) {
		// TODO Auto-generated method stub
		List<Commodity> commodities = importReturnCommodityDataServiceImpl.getForImportId(importformid);
		
		String sql = "select id, client, houseware, operator, remark, sum, state, date from ImportReturnForm where id = ?";
		ImportFormPO importFormPO = dao.get(ImportFormPO.class, sql, importformid);
		importFormPO.setImportcommoditylist(commodities);
		return importFormPO;
		
	}

	@Override
	public List<ImportFormPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select id, client, houseware, operator, remark, sum, state, date from ImportReturnForm where state = ?";
		
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

	@Override
	public List<ImportFormPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select id, client, houseware, operator, remark, sum, state,date from ImportReturnForm where date >= ? and date <= ?";
		return dao.getALL(ImportFormPO.class, sql, begin, end);
	}

	@Override
	public List<ImportFormPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select id, client, houseware, operator, remark, sum, state, date from ImportReturnForm";
		return dao.getALL(ImportFormPO.class, sql);
	}

	@Override
	public List<ImportFormPO> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select id, client, houseware, operator, remark, sum, state, date from ImportReturnForm where client = ?";
		return dao.getALL(ImportFormPO.class, sql, client);
	}

//	@Override
//	public List<ImportFormPO> findForSalesman(String salesman) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<ImportFormPO> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		String sql = "select id, client, houseware, operator, remark, sum, state, date from ImportReturnForm where houseware = ?";
		return dao.getALL(ImportFormPO.class, sql, houseware);
	}



}
