package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.ReceiptDataService;
import JDBC.DAO;
import PO.ReceiptPO;

public class ReceiptDataServiceImpl implements ReceiptDataService{

	DAO<ReceiptPO> dao = new DAO<>();
	@Override
	public boolean insert(ReceiptPO receiptPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Receipt values(?,?,?,?,?,?,?)";
		return dao.update(sql, receiptPO.getId(), receiptPO.getUsername(), 
				               receiptPO.getAccount(), receiptPO.getAmount(), receiptPO.getRemark(),
				               receiptPO.getSum(), receiptPO.getState());
	}


	//审批单据，修改单据审批状态
	@Override
	public boolean update(ReceiptPO receiptPO) {
		// TODO Auto-generated method stub
		String sql = "update Receipt set state = ? where id = ?";
		return dao.update(sql, "yes", receiptPO.getId());
	}


	//得到制定单据
	@Override
	public ReceiptPO findForId(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where id = ?";
		return dao.get(ReceiptPO.class, sql, id);
	}


	//查找所有未审批单据
	@Override
	public List<ReceiptPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where state = ? ";
		return dao.getALL(ReceiptPO.class, sql, "no");
	}


	@Override
	public List<ReceiptPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where date >= ? and date <= ?";
		return dao.getALL(ReceiptPO.class, sql, begin, end);
		
	}


	@Override
	public List<ReceiptPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt";
		return dao.getALL(ReceiptPO.class, sql);
	}


	@Override
	public List<ReceiptPO> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where client = ?";
		return dao.getALL(ReceiptPO.class, sql, client);
	}

}
