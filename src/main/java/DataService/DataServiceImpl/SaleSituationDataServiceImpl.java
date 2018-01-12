package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.SaleSituationDataService;
import JDBC.DAO;
import PO.SaleSituationPo;

public class SaleSituationDataServiceImpl implements SaleSituationDataService{

	
	DAO<SaleSituationPo> dao = new DAO<>();
	@Override
	public List<SaleSituationPo> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "";
		return dao.getALL(SaleSituationPo.class, sql, begin, end);
	}

	@Override
	public List<SaleSituationPo> findForName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleSituationPo> findForClient(String client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleSituationPo> findForSalesman(String salesman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleSituationPo> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		return null;
	}

}
