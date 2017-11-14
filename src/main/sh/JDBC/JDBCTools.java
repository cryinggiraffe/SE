package JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTools {
	
	
	public static Connection getConnection() throws Exception {
		
		Properties properties = new Properties();
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc1.properties");
		properties.load(in);
	
		String driverClass = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
	
		Class.forName(driverClass);
	
		return DriverManager.getConnection(jdbcUrl,user,password);
	}
	
	public static void release(ResultSet resultSet,Statement statement, Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(statement != null){
			try{
				statement.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		if(connection != null){
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
