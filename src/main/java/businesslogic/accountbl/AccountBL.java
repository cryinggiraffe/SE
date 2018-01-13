package businesslogic.accountbl;
import PO.AccountPO;
import DataService.DataServiceImpl.AccountDataServiceImpl;
import blService.AccountBLService;

public class AccountBL implements AccountBLService{
    private AccountDataServiceImpl ads=new AccountDataServiceImpl();

    @Override
    public boolean newAccount(AccountPO po) {
        return ads.insert(po);
    }

    @Override
    public boolean updateAccount(AccountPO po) {
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
        abl.newAccount(apo);
        System.out.println(abl.findAccount(apo.getName()));
    }
}
