package Model;

import DBConnecter.DBConnect;

import java.sql.PreparedStatement;

public class MoneyAddLogic {
    public boolean Balanceupdate(String amt,String accno){
        System.out.println(accno);
        System.out.println(amt);
        PreparedStatement pst;
        try {
            String query = "update BankApp set balance = ? where Accno = ?";
            pst = DBConnect.getCon().prepareStatement(query);
            pst.setString(1,amt);
            pst.setString(2,accno);
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
