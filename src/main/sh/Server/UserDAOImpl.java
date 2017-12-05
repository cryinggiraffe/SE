package Server;

import JDBC.DAO;
import User.User;


//查询数据库，得到账户、密码
public class UserDAOImpl extends DAO<User>{
	
	public User get(String username) {
        String sql = "SELECT username,password,type FROM User WHERE username = ?";
        return get(User.class,sql, username);
    }
}
