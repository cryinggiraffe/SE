package blService;

import PO.Commodity;

import java.util.Date;
import java.util.List;

public interface SaleFormService {
    void newForm(String formtype, String client, String operator, String salesman, String houseware,
                 double tpbfDiscounting, double tpafDiscounting, double discount,
                 double voucher, String remark, java.util.Date date,List<Commodity> list);
}
