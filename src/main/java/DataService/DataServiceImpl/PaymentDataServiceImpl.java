package DataService.DataServiceImpl;

import java.util.List;

import DataService.PaymentDataService;
import JDBC.DAO;
import PO.PaymentPO;

public class PaymentDataServiceImpl implements PaymentDataService{

	DAO<PaymentPO> dao = new DAO<>();
	@Override
	public boolean insert(PaymentPO paymentPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Payment values(?,?,?,?,?,?,?)";
		return dao.update(sql, paymentPO.getId(), paymentPO.getUsername(),
				          paymentPO.getAccount(), paymentPO.getAmount(), paymentPO.getRemark(), 
				          paymentPO.getSum(), paymentPO.getState());
	}

	@Override
	public PaymentPO findForId(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from Payment where id = ?";
		return dao.get(PaymentPO.class, sql, id);
	}

	@Override
	public List<PaymentPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select * from Payment where state = ? ";
		return dao.getALL(PaymentPO.class, sql, "no");
	}

	@Override
	public boolean update(PaymentPO paymentPO) {
		// TODO Auto-generated method stub
		String sql = "update Payment set state = ? where id = ?";
		return dao.update(sql, "yes", paymentPO.getId());
	}

}