package businesslogic.paymentbl;

import DataService.DataServiceImpl.PaymentDataServiceImpl;
import PO.PaymentPO;
import blService.PaymentBLService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PaymentBL implements PaymentBLService {
    private PaymentDataServiceImpl pds=new PaymentDataServiceImpl();

    @Override
    public void newPayment(String id, String client, String username, String account, double amount, String remark,
                           double sum, Date date) {
        PaymentPO po=new PaymentPO(id,client,username,account,amount,remark,sum,date);
        pds.insert(po);
    }

    @Override
    public PaymentPO findById(String id) {
        return pds.findForId(id);
    }

    @Override
    public List<PaymentPO> findByState() {
        List<PaymentPO> pos=pds.findForState();
        return pos;
    }

    @Override
    public boolean update(PaymentPO po) {
        pds.update(po);
        return true;
    }

    @Override
    public String newId () {
        Calendar now = Calendar.getInstance();
        String Id = "FKD-";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-");
        int length = pds.findForType().size() + 1;
        Id = Id +  sdf.format(now.getTime()) + String.format("%05d",length);
        return Id;
    }

    @Override
    public List<PaymentPO> findByTime(Date begin, Date end){
        return pds.findForTime(begin,end);
    }
    @Override
    public List<PaymentPO> findByType(){
        return pds.findForType();
    }
    @Override
    public List<PaymentPO> findByClient(String client){
        return pds.findForClient(client);
    }

    public static void main(String[] agrs){
        PaymentBL rs=new PaymentBL();
        //rs.newPayment(s);
        //System.out.println(rs.findById(s.getId()));
        System.out.println(rs.newId());
    }
}
