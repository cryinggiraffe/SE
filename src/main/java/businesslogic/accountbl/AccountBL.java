package businesslogic.accountbl;
import PO.AccountPO;
import DataService.DataServiceImpl.AccountDataServiceImpl;
import blService.AccountBLService;

import java.util.List;

public class AccountBL implements AccountBLService{
    private AccountDataServiceImpl ads=new AccountDataServiceImpl();

    @Override
    public boolean newAccount(String name, double balance) {
        AccountPO po=new AccountPO(name,balance);
        return ads.insert(po);
    }

    @Override
    public boolean updateAccount(String name, double balance) {
        AccountPO po=new AccountPO(name,balance);
        return ads.update(po);
    }

    @Override
    public AccountPO findAccount(String name) {
        return ads.find(name);
    }
    public static void main(String[] agrs){
        AccountBL abl=new AccountBL();
        AccountPO apo=new AccountPO();
        apo.setName("addinistrative");

    }
    public List<AccountPO> findAllAccount(){return ads.findAll();}
    public boolean delete(String name){
        AccountPO apo=new AccountPO(name,0);
        return ads.delete(apo);
    }
}
