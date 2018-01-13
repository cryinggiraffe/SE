package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.CashDataService;
import JDBC.DAO;
import PO.CashPO;

public class CashDataServiceImpl implements CashDataService{

	DAO<CashPO> dao = new DAO<>();
	@Override
	public boolean insert(CashPO cashPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Cash(listid, operator, account, name, amount, remark, sum , date) values(?,?,?,?,?,?,?,?)";
		return dao.update(sql, cashPO.getListid(), cashPO.getOperator(), cashPO.getAccount(),
				               cashPO.getName(), cashPO.getAmount(), cashPO.getRemark(), 
				               cashPO.getSum(), cashPO.getDate());
	}

	@Override
	public boolean update(CashPO cashPO) {
		// TODO Auto-generated method stub
		String sql = "update Cash set listid = ? , operator = ? , account = ?, name = ?, amount = ? , remark = ?, sum = ? "
				+ ", date = ? where listid = ?";
		
		return dao.update(sql, cashPO.getOperator(), cashPO.getAccount(),
	               			   cashPO.getName(), cashPO.getAmount(), cashPO.getRemark(), 
	               			   cashPO.getSum(), cashPO.getDate(), cashPO.getListid());
	}

	@Override
	public CashPO findForListId(String listid) {
		// TODO Auto-generated method stub
		String sql = "select listid, operator, account, name, amount, remark, sum , date from Cash where listid = ?";
		return dao.get(CashPO.class, sql, listid);
	}

	@Override
	public List<CashPO> findForList(String listid) {
		// TODO Auto-generated method stub
		String sql = "select listid, operator, account, name, amount, remark, sum , date from Cash where listid = ?";
		return dao.getForList(CashPO.class, sql, listid);
	}

	@Override
	public List<CashPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select listid, operator, account, name, amount, remark, sum , date from Cash where date >= ? and date <= ?";
		return dao.getALL(CashPO.class, sql, begin, end);
	}

	@Override
	public List<CashPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select listid, operator, account, name, amount, remark, sum , date from Cash";
		return dao.getALL(CashPO.class, sql);
	}

}
