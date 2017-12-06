package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DeployServer {
	
	public DeployServer(){

	}
	public static void main(String[] args) {
	        try{
	            UserDBServer userDBServer = new UserDBServerImpl();
	            LocateRegistry.createRegistry(1111);
	            Naming.rebind("//localhost:1111/ds",userDBServer);
	            System.out.println("RMI服务器正在运行...");
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}
}
