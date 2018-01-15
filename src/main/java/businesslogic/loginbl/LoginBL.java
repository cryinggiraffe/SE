package businesslogic.loginbl;

import DataService.DataServiceImpl.LoginDataServiceImpl;
import PO.UserPO;
import blService.LoginBLService;

public class LoginBL implements LoginBLService {
    private LoginDataServiceImpl lds=new LoginDataServiceImpl();
    @Override
    public boolean validatePassword(String id,String password) {
        return lds.getPassword(id).equals(password);
    }
    public String usertype(String id){
        UserPO user = this.getUser(id);
        return user.getType();

    }
    public static void main(String[] agrs){
        LoginBL lg=new LoginBL();
        UserPO po=new UserPO();
        po.setUsername("123456");
        po.setPassword("dasdfas");

        System.out.println(lg.usertype("00123412"));


    }
    public UserPO getUser(String username){
        return lds.getUser(username);
    }
}
