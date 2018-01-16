package businesslogic.cashbl;

import DataService.DataServiceImpl.CashDataServiceImpl;
import PO.AccountPO;
import PO.CashPO;
import blService.CashBLService;
import businesslogic.accountbl.AccountBL;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CashBL implements CashBLService {
    private CashDataServiceImpl rds=new CashDataServiceImpl();

    @Override
    public void newCash(String listid, String operator, String account, String name, double amount, String remark, double sum,
                        Date date) {
        CashPO po=new CashPO(listid,operator,account,name,amount,remark,sum,date);
        AccountBL accountBL = new AccountBL();
        AccountPO accountpo = accountBL.findAccount(account);
        double balance = accountpo.getBalance();
        balance = balance - amount;
        accountBL.updateAccount(account,balance);
        rds.insert(po);
    }

    @Override
    public CashPO findById(String id) {
        return rds.findForListId(id);
    }


    @Override
    public boolean update(CashPO po) {
        rds.update(po);
        return true;
    }

    @Override
    public String newId () {
        Calendar now = Calendar.getInstance();
        String Id = "XJFYD-";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-");
        int length = rds.findForType().size() + 1;
        Id = Id +  sdf.format(now.getTime()) + String.format("%05d",length);
        return Id;
    }

    @Override
    public List<CashPO> findByTime(Date begin, Date end){
        return rds.findForTime(begin,end);
    }
    @Override
    public List<CashPO> findByType(){
        return rds.findForType();
    }
    @Override
    public List<CashPO> findByClient(String client){
        return rds.findForClient(client);
    }

    public static void main(String[] args){
        CashBL rs=new CashBL();
        //rs.newCash(s);
        //System.out.println(rs.findById(s.getId()));
        System.out.println(rs.newId());
    }
}
