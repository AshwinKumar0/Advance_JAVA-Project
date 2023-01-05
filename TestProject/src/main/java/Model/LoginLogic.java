package Model;
import DBConnecter.DBConnect;
import DataTransferObject.UserDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginLogic {
    public boolean LoginMatch(UserDto use){

        String Username = use.getUserName();
        String Password = use.getPassword();
        PreparedStatement pst;
        ResultSet res;

        try{

            String query = "Select * from BankApp where username=? and password=?";
            pst = DBConnect.getCon().prepareStatement(query);
            pst.setString(1,Username);
            pst.setString(2,Password);
            res = pst.executeQuery();

            if (res.next()){
                use.setAccountNo(String.valueOf(res.getInt("Accno")));
                use.setName(res.getString("name"));
                use.setEmail(res.getString("email"));
                use.setMobile(String.valueOf(res.getInt("mobile")));
                use.setBalance(String.valueOf(res.getInt("balance")));

                return true;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
