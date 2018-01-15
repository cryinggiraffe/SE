package DataService;

import java.sql.Date;
import java.util.List;

import PO.ReceiptPO;

public interface ReceiptDataService {
	
	public boolean insert(ReceiptPO receiptPO);
	public ReceiptPO findForId(String id);
	public List<ReceiptPO> findForState();
	public boolean update(ReceiptPO receiptPO);
	
	public List<ReceiptPO> findForTime(Date begin, Date end);
	public List<ReceiptPO> findForType();
	public List<ReceiptPO> findForClient(String client);
}
