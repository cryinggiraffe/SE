package blService;

import PO.CashPO;

import java.sql.Date;
import java.util.List;

public interface CashBLService {
    void newCash(String listid, String operator, String account, String name, double amount, String remark, double sum,
                    Date date);
    boolean update(CashPO po);
    CashPO findById(String id);
    String newId();

    List<CashPO> findByTime(Date begin, Date end);
    List<CashPO> findByType();
    List<CashPO> findByClient(String client);
}
