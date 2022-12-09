import DBConnecter.DBConnect;
import DataTransferObject.UserDto;
import Model.RegisterLogic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(name = "RegisterCheck", value = "/RegisterCheck")
public class RegisterCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = request.getParameter("Name");
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("pass");
        String Email = request.getParameter("Email");
        String Mobile = request.getParameter("Mobile");
        String Balance = request.getParameter("Bal");

        UserDto User = new UserDto();

        User.setName(Name);
        User.setUserName(UserName);
        User.setPassword(Password);
        User.setEmail(Email);
        User.setMobile(Mobile);
        User.setBalance(Balance);

        RegisterLogic reg = new RegisterLogic();
        if (reg.Reg(User)){
            response.sendRedirect("Login.html");
        }
        else {
            response.sendRedirect("RegisterFailed.html");
        }

    }
}
