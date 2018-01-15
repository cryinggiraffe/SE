package businesslogic.userbl;
import PO.UserPO;
import blService.AdministratorBLService;
import DataService.DataServiceImpl.AdministratorDataServiceImpl;

import java.util.List;

public class UserBL implements AdministratorBLService {
    private AdministratorDataServiceImpl ads=new AdministratorDataServiceImpl();
    public boolean newUser(String username, String password, int userclass, String type){
        UserPO po=new UserPO(username,password,userclass,type);
        return ads.insert(po);

    }
    public boolean deleteUser(String name){
        return ads.delete(name);

    }

    public boolean update(String username, String password, int userclass, String type){
        UserPO po=new UserPO(username,password,userclass,type);
        return ads.update(po);
    }

    public UserPO findUser(String name){
        return ads.getUser(name);
    }

    public List<UserPO> findAllUser(){
        return ads.findAll();
    }
    public static void main(String[] agrs){
        UserBL bl=new UserBL();
        bl.newUser("testuser","passw",1,"12345");
    }
}
