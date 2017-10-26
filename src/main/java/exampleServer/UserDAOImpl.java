package exampleServer;

import JDBC.DAO;
import User.User;

public class UserDAOImpl extends DAO<User>{
	
	public User get(String username) {
        String sql = "SELECT username,password FROM User WHERE username = ?";
        return get(User.class,sql, username);
    }
}
