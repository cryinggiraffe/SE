package blService;

import PO.UserPO;

public interface LoginBLService {
    boolean validatePassword(String id,String password);
    String usertype(String id);
    UserPO getUser(String username);
}
