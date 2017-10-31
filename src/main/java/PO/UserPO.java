package PO;

public class UserPO implements Serializable {
    String username;
    String password;
    int type;

    public UserPO(String username,String password, int type){
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getType(){
        return type;
    }
}