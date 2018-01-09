package businesslogic.ReceiptBL;
import PO.ReceiptPO;
import blService.ReceiptBLService;
import DataService.DataServiceImpl.ReceiptDataServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ReceiptBL implements ReceiptBLService{
    private ReceiptDataServiceImpl rds=new ReceiptDataServiceImpl();

    @Override
    public void newReceipt(ReceiptPO po) {
        rds.insert(po);
    }

    @Override
    public ReceiptPO findById(String id) {
        return rds.findForId(id);
    }

    @Override
    public List<ReceiptPO> findByState() {
        List<ReceiptPO> pos=rds.findForState();
        return pos;
    }

    @Override
    public boolean update(ReceiptPO po) {
        rds.update(po);
        return true;
    }
    public static void main(String[] agrs){
        ReceiptPO s=new ReceiptPO();
        s.setId("SKD-1234");
        ReceiptBL rs=new ReceiptBL();
        //rs.newReceipt(s);
        System.out.println(rs.findById(s.getId()));
    }
}
