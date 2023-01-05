package Servlets;

import DataTransferObject.UserDto;
import Model.MoneyAddLogic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddMoney", value = "/AddMoney")
public class AddMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.sendRedirect("AddMoney.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Amount = request.getParameter("amt");
        UserDto user = new UserDto();
        String oldAmount = user.getBalance();
        String newAmount = Integer.toString(Integer.parseInt(Amount)+Integer.parseInt(oldAmount));
        String accno = user.getAccountNo();
        MoneyAddLogic Mnyadd = new MoneyAddLogic();
        if (Mnyadd.Balanceupdate(newAmount,accno)){
            user.setBalance(newAmount);
            HttpSession session = request.getSession();
            session.setAttribute("balance",newAmount);

            response.sendRedirect("Home.jsp");
        }
        else {
            response.sendRedirect("MoneyAddFailure.html");
        }

    }
}
