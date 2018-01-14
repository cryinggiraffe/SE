package blService;

import PO.PaymentPO;

import java.sql.Date;
import java.util.List;

public interface PaymentBLService {
    void newPayment(String id, String client, String username, String account, double amount, String remark,
                    double sum, Date date);
    boolean update(PaymentPO po);
    PaymentPO findById(String id);
    String newId();
    List<PaymentPO> findByState();
    List<PaymentPO> findByTime(Date begin, Date end);
    List<PaymentPO> findByType();
    List<PaymentPO> findByClient(String client);
}
