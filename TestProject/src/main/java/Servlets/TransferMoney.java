package Servlets;

import DBConnecter.DBConnect;
import DataTransferObject.UserDto;
import Model.TransferLogic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransferMoney", value = "/TransferMoney")
public class TransferMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("TransferMoney.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String RecAccNo = request.getParameter("accno");
      String Amount = request.getParameter("amount");
      int trfAmt = Integer.parseInt(Amount);
        HttpSession session = request.getSession();
//        String CurAcc = (String) session.getAttribute("accno");
//        int CurBAl = (int) session.getAttribute("balance");
        UserDto user = new UserDto();
        String CurAcc = user.getAccountNo();
        int CurBAl = Integer.parseInt(user.getBalance());
        TransferLogic trf = new TransferLogic();
        if (CurBAl>trfAmt){
            if(trf.AccountValidator(RecAccNo)){
               if(trf.TransferAmount(RecAccNo,CurAcc,Amount)){
                   session.setAttribute("balance",CurBAl-trfAmt);
                   user.setBalance(String.valueOf(CurBAl-trfAmt));
                   response.sendRedirect("Home.jsp");
               }
               else {
                   response.sendRedirect("TransferFailure.html");
               }
            }
            else {
                response.sendRedirect("InvalidTransferAccount.html");
            }
        }
        else {
            response.sendRedirect("InsufficientBalance.html");
        }


    }
}
