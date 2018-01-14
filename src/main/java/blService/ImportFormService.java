package blService;

import PO.Commodity;
import PO.ImportFormPO;

import java.util.Date;
import java.util.List;

public interface ImportFormService {
    String newForm(String FormType/*进货单JHD 进货退货单JHTHD*/,String provider, String houseware, String operator,
                  String remark, double sum, String state, Date date,List<Commodity> list);
    ImportFormPO findById(String id);
    boolean update(ImportFormPO po);
    List<ImportFormPO> findByState();
    List<ImportFormPO> findByTime(java.sql.Date begin, java.sql.Date end);
    List<ImportFormPO> findByType();
    List<ImportFormPO> findByClient(String client);
}
