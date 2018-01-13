package blService;

import PO.AccountPO;

public interface AccountBLService {
    boolean newAccount(AccountPO po);
    boolean updateAccount(AccountPO po);
    AccountPO findAccount(String name);
}
