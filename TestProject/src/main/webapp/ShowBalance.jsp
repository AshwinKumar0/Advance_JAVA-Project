<%--
  Created by IntelliJ IDEA.
  User: ASHWANI
  Date: 09-12-2022
  Time: 04:25 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
  <style>
    body{
      background: rgba(113, 154, 236, 0.99);
    }
    h1,h3{
      color: white;
      text-align: center;
      font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    #container{
      border: 1px solid white;
      margin-top: 5%;
      background: #000;
    }
    p{
       text-align: center;
      font-weight: bolder;
       font-size: 2rem;
      color: red;


    }


    
  </style>
</head>
<body>
<div id="container">
  <h1>Account Balance</h1>
  <h3>Your Current Balance</h3>
   <p><%out.println(session.getAttribute("balance"));%></p>

</div>
</body>
</html>
