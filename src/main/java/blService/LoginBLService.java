package blService;

public interface LoginBLService {
    boolean validatePassword(String id,String password);
    String usertype(String id);
}
