package exampleClient;

import java.rmi.Naming;

import User.User;
import exampleServer.UserDBServer;

public class RMIClient{
    public static void main(String[] args) {
        try{
            UserDBServer userDBServer = (UserDBServer)Naming.lookup("//120.95.133.79:1111/ds");
            
            User user = new User();
            user.setUsername("root");
            user.setPassword("root");
            
            User user2 = userDBServer.getUser("root");
            
            System.out.println("密码：" + user2.getPassword());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}