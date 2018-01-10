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
        String types=id.substring(0,2);
        switch (types){
            case "00":return "总经理";
            case "01":return "财务人员";
            case "02":return  "进货销售人员";
            case "03":return "库存管理人员";
            default:return "unknown user";
        }

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
