package blService;

import PO.UserPO;

public interface AdministratorBLService {
    boolean newUser(String username, String password, int userclass, String type);
    boolean deleteUser(String username);
}
