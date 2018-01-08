package DataService;

import java.util.List;

import PO.ReceiptPO;

public interface ReceiptDataService {
	
	public boolean insert(ReceiptPO receiptPO);
	public ReceiptPO findForId(String id);
	public List<ReceiptPO> findForState();
	public boolean update(ReceiptPO receiptPO);
	
}
