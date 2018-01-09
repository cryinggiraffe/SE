package businesslogic.loginbl;

import DataService.DataServiceImpl.LoginDataServiceImpl;
import blService.LoginBLService;

public class LoginBL implements LoginBLService {
    private LoginDataServiceImpl lds=new LoginDataServiceImpl();
    @Override
    public boolean validatePassword(String id,String password) {
        return lds.getPassword(id).equals(password);
    }
}
