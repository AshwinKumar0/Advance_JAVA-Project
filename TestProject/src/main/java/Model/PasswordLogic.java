package Model;

import DBConnecter.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordLogic {

    public boolean changePass(String pass,String accno) {
        PreparedStatement pst;
        try {
            String query = "update bankapp set password = ? where accno = ?";
            pst = DBConnect.getCon().prepareStatement(query);
            pst.setString(1,pass);
            pst.setString(2, accno);
            int n = pst.executeUpdate();
            System.out.println(n);
            if (n==1){

                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
