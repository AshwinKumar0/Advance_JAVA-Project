<%--
  Created by IntelliJ IDEA.
  User: ASHWANI
  Date: 09-12-2022
  Time: 01:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RegisterMe</title>
    <style>
        *{
            margin: 0%;
            padding: 0%;
            box-sizing: border-box;
        }
        #bdy{
            background-color: rgba(154, 243, 91, 0.599);
        }
        #container{
            height: 500px;
            width: 500px;
            margin-inline:auto;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            background-color: rgba(154, 243, 91, 0.599);
        }
        .info{

            display: flex;

        }
        .title{

            flex-basis: 50%;
            text-align: center;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-size: 1.1rem;
            background-color: black;
            color: white;
        }
        .space{
            background-color: white;
            flex-basis: 50%;
            color: black;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-size: 1.1rem;
            text-align: center;
        }

        h1{
            text-align: center;
            color:rgba(0, 0, 0, 0.752);
            margin-top: 1%;
        }
        .info1{
            border: 2px solid;
            text-align: center;
            background: #000;


        }
        a{
            text-decoration: none;
            color: white;
        }

    </style>
</head>
<body id="bdy">
<div id="container">
    <h1>Welcome to HomePage</h1>

    <div class="info">
        <div class="title">Account-Number : </div>
        <div class="space"><%out.println(session.getAttribute("accno"));%></div>
    </div>
    <div class="info">
        <div class="title">Name : </div>
        <div class="space"><%out.println(session.getAttribute("name"));%></div>
    </div>
    <div class="info">
        <div class="title">Email : </div>
        <div class="space"><%out.println(session.getAttribute("email"));%></div>
    </div>
    <div class="info">
        <div class="title">Mobile : </div>
        <div class="space"><%out.println(session.getAttribute("mobile"));%></div>
    </div>
    <div class="info">
        <div class="title">User-Name : </div>
        <div class="space"><%out.println(session.getAttribute("username"));%></div>
    </div>
    <div class="info1"><a href="AddMoney.html">Add Money</a></div>
    <div class="info1"><a href="TransferMoney.html">Transfer Money</a></div>
    <div class="info">
        <div class="title"><a href="ShowBalance.jsp"> Check-Balance </a></div>
        <div style="background:#000;" class="space"><a href="ChangePassword.html"> Change-Password </a></div>
    </div>


        <div class="info1"><a href="Logout.jsp">Sing Out</a></div>

</div>
</body>

</html>
