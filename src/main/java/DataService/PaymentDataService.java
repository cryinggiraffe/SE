package DataService;

import java.sql.Date;
import java.util.List;

import PO.PaymentPO;

public interface PaymentDataService {
	
	public boolean insert(PaymentPO paymentPO);
	public PaymentPO findForId(String id);
	public List<PaymentPO> findForState();
	public boolean update(PaymentPO paymentPO);
	
	public List<PaymentPO> findForTime(Date begin, Date end);
	public List<PaymentPO> findForType();
	public List<PaymentPO> findForClient(String client);
	
}
