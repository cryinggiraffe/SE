package blService;

import PO.AccountPO;

public interface AccountBLService {
    boolean newAccount(String name, double balance);
    boolean updateAccount(String name, double balance);
    AccountPO findAccount(String name);
}
