package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.IncomeDataService;
import JDBC.DAO;
import PO.IncomePO;

public class IncomeDataServiceImpl implements IncomeDataService{

	
	DAO<IncomePO> dao = new DAO<>();
	@Override
	public boolean insert(IncomePO incomePO) {
		// TODO Auto-generated method stub
		String sql = "insert into Income(saleincome, overflowincome, costincome, importreturnincome, vouchersincome, "
				+ " sumincome,discount, date) values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, incomePO.getSaleincome(), incomePO.getOverflowincome(), incomePO.getCostincome(),
				               incomePO.getImportreturnincome(), incomePO.getVouchersincome(), incomePO.getSumincome(),
				               incomePO.getDiscount(), incomePO.getDate());
	}

	@Override
	public List<IncomePO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select saleincome, overflowincome, costincome, importreturnincome, vouchersincome, "
				+ " sumincome,discount, date from Income where date >= ? and date <= ?";
		return dao.getALL(IncomePO.class, sql, begin, end);
	}

	@Override
	public List<IncomePO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select saleincome, overflowincome, costincome, importreturnincome, vouchersincome, "
				+ " sumincome, discount, date from Income";
		return dao.getALL(IncomePO.class, sql);
	}

}
