package Servlets;

import DataTransferObject.UserDto;
import Model.PasswordLogic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePassword", value = "/ChangePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ChangePassword.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String Password = request.getParameter("pass");
      UserDto ud = new UserDto();
      String accno = ud.getAccountNo();
      PasswordLogic pl = new PasswordLogic();
        if (pl.changePass(Password,accno)){
            response.sendRedirect("Login.html");
        }
        else {
            response.sendRedirect("PassChangeFailed.html");
        }




    }
}
