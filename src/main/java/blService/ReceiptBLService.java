package blService;
import PO.ReceiptPO;

import java.util.List;

public interface ReceiptBLService {
    void newReceipt(ReceiptPO po);
    boolean update(ReceiptPO po);
    ReceiptPO findById(String id);
    List<ReceiptPO> findByState();

}
