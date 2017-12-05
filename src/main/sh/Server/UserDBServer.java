package Server;

import java.rmi.Remote;

import User.User;

public interface UserDBServer extends Remote{
	
	public User getUser(String username);
}
