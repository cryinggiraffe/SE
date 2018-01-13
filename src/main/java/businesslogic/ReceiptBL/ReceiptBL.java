package businesslogic.ReceiptBL;
import PO.ReceiptPO;
import blService.ReceiptBLService;
import DataService.DataServiceImpl.ReceiptDataServiceImpl;

import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReceiptBL implements ReceiptBLService{
    private ReceiptDataServiceImpl rds=new ReceiptDataServiceImpl();

    @Override
    public void newReceipt(String id, String client, String username, String account, double amount, String remark,
                           double sum, Date date) {
        ReceiptPO po=new ReceiptPO(id,client,username,account,amount,remark,sum,date);
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

    @Override
    public String newId () {
        Calendar now = Calendar.getInstance();
        String Id = "SKD-";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Id = Id +  sdf.format(now.getTime());
        return Id;
    }

    public static void main(String[] agrs){
        ReceiptPO s=new ReceiptPO();
        s.setId("SKD-1234");
        ReceiptBL rs=new ReceiptBL();
        //rs.newReceipt(s);
        //System.out.println(rs.findById(s.getId()));
        System.out.println(rs.newId());
    }
}
