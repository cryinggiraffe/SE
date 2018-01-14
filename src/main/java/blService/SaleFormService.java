package blService;

import PO.Commodity;
import PO.SaleFormPO;

import java.util.Date;
import java.util.List;

public interface SaleFormService {
    void newForm(String formtype, String client, String operator, String salesman, String houseware,
                 double tpbfDiscounting, double tpafDiscounting, double discount,
                 double voucher, String remark, java.util.Date date,List<Commodity> list);

    SaleFormPO findById(String id);
    boolean update(SaleFormPO po);
    List<SaleFormPO> findByState();
    List<SaleFormPO> findByTime(java.sql.Date begin, java.sql.Date end);
    List<SaleFormPO> findByType();
    List<SaleFormPO> findByClient(String client);
}
