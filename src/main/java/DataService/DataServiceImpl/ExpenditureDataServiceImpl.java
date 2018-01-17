package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.ExpenditureDataService;
import JDBC.DAO;
import PO.ExpenditurePO;

public class ExpenditureDataServiceImpl implements ExpenditureDataService{

	DAO<ExpenditurePO> dao = new DAO<>();
	@Override
	public boolean insert(ExpenditurePO expenditurePO) {
		// TODO Auto-generated method stub
		String sql = "insert into Expenditure (salecost, commoditylostexpenditure, giftexpenditure, sumexpenditure, date) "
				+ " values(?,?,?,?,?)";
		
		return dao.update(sql, expenditurePO.getSalecost(), expenditurePO.getCommoditylostexpenditure(), expenditurePO.getGiftexpenditure(),
				               expenditurePO.getSumexpenditure(), expenditurePO.getDate());
	}

	@Override
	public List<ExpenditurePO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql =  "select salecost, commoditylostexpenditure, giftexpenditure, sumexpenditure, date from Expenditure where date >= ? and date <= ?";
		return dao.getALL(ExpenditurePO.class, sql, begin, end);
	}

	@Override
	public List<ExpenditurePO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select salecost, commoditylostexpenditure, giftexpenditure, sumexpenditure, date from Expenditure";
		return dao.getALL(ExpenditurePO.class, sql);
	}

}
