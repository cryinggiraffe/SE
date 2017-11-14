import java.sql.*;
public class DatabaseTest {
    public static  void main(String[] agrs){
        System.out.print("ok");
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            Driver driver=new com.mysql.jdbc.Driver();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
