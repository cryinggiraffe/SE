package blService;

import PO.Commodity;

import java.util.Date;
import java.util.List;

public interface ImportFormService {
    void newForm(String FormType/*进货单JHD 进货退货单JHTHD*/,String provider, String houseware, String operator,
                 List<Commodity> importcommoditylist, String remark, double sum, String state, Date date,List<Commodity> list);

}
