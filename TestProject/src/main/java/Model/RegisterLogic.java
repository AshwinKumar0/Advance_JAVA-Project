package Model;

import DBConnecter.DBConnect;
import DataTransferObject.UserDto;

import java.sql.PreparedStatement;

public class RegisterLogic {
    public Boolean Reg(UserDto use){
        boolean flag = false;
        PreparedStatement pst;
        String Name = use.getName();
        String UserName = use.getUserName();
        String Email = use.getEmail();
        String Mobile = use.getMobile();
        String Balance = use.getBalance();
        String Password = use.getPassword();

        try{
            String query = "insert into BankApp (name, username, email, mobile, balance, password) values(?,?,?,?,?,?)";
            pst = DBConnect.getCon().prepareStatement(query);
            pst.setString(1,Name);
            pst.setString(2,UserName);
            pst.setString(3,Email);
            pst.setString(4,Mobile);
            pst.setString(5,Balance);
            pst.setString(6,Password);
            int n = pst.executeUpdate();
            if (n==1){
                System.out.println("Data Inserted");
                flag =  true;
            }
            else {
                System.out.println("Data insertion failed");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
