package Servlets;

import DataTransferObject.UserDto;
import Model.LoginLogic;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "LoginCheck", value = "/LoginCheck")
public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        UserDto user = new UserDto();
        user.setUserName(Username);
        user.setPassword(Password);

        LoginLogic Login = new LoginLogic();

        if (Login.LoginMatch(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("accno",user.getAccountNo());
            session.setAttribute("username",Username);
            session.setAttribute("name",user.getName());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("mobile",user.getMobile());
            session.setAttribute("balance",user.getBalance());
            response.sendRedirect("Home.jsp");
        }
        else {
            response.sendRedirect("Login.html");
        }


    }
}
