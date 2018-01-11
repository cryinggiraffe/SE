package blService;
import PO.ReceiptPO;

import java.util.List;

public interface ReceiptBLService {
    void newReceipt(String id, String username, String account, double amount, String remark, double sum);
    boolean update(ReceiptPO po);
    ReceiptPO findById(String id);
    List<ReceiptPO> findByState();

}
