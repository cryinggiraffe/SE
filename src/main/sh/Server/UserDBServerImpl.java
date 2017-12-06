package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import User.User;

public class UserDBServerImpl extends UnicastRemoteObject implements UserDBServer{

	private static final long serialVersionUID = 1L;

	UserDAOImpl userDAOImpl = new UserDAOImpl();
	
	protected UserDBServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDAOImpl.get(username);
	}

}
