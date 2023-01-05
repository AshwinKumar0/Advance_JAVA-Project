package DBConnecter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBConnect {
    static Connection con;
    static PreparedStatement pst;
    static Statement st;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","L@zy2020");
            System.out.println("DataBase is Connected");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static Connection getCon(){
        return con;
    }
    public static Statement getst() {
        return st;
    }
    public static  PreparedStatement getPst(){
        return pst;
    }


}
