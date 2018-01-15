package blService;

import PO.UserPO;
import User.User;

import java.util.List;

public interface AdministratorBLService {
    boolean newUser(String username, String password, int userclass, String type);
    boolean deleteUser(String username);
    boolean update(String username, String password, int userclass, String type);
    UserPO findUser(String username);
    List<UserPO> findAllUser();
}
