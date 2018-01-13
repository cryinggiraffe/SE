package blService;
import PO.ReceiptPO;

import java.sql.Date;
import java.util.List;

public interface ReceiptBLService {
    void newReceipt(String id, String client, String username, String account, double amount, String remark,
                    double sum, Date date);
    boolean update(ReceiptPO po);
    ReceiptPO findById(String id);
    String newId();
    List<ReceiptPO> findByState();

}
