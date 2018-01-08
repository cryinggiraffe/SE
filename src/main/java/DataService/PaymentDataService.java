package DataService;

import java.util.List;

import PO.PaymentPO;

public interface PaymentDataService {
	
	public boolean insert(PaymentPO paymentPO);
	public PaymentPO findForId(String id);
	public List<PaymentPO> findForState();
	public boolean update(PaymentPO paymentPO);
	
}
