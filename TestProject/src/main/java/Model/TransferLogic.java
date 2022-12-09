package Model;

import DBConnecter.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class TransferLogic {
    PreparedStatement pst;
    String AccountNo;
    public boolean AccountValidator(String RecAccno) {
        try {
            String query = "SELECT * from bankapp where accno =?";
            pst = DBConnect.getCon().prepareStatement(query);
            pst.setString(1, RecAccno);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                 AccountNo = res.getString("accno");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Objects.equals(RecAccno, AccountNo);
    }

    public boolean TransferAmount(String RecAccNo,String curAcc, String Amt) {
        try {
            String query1 = "update bankapp set balance=balance+? where accno =?";
            pst = DBConnect.getCon().prepareStatement(query1);
            pst.setInt(1,Integer.parseInt(Amt));
            pst.setString(2,RecAccNo);
            int status1 = pst.executeUpdate();
            if (status1 == 1){
                String query2 = "update bankapp set balance=balance-? where accno =?";
                pst = DBConnect.getCon().prepareStatement(query2);
                pst.setInt(1,Integer.parseInt(Amt));
                pst.setString(2,curAcc);
                int status2 = pst.executeUpdate();
                if (status2 == 1) {
                    return true;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
