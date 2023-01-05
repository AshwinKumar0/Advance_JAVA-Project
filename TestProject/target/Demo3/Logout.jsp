<%--
  Created by IntelliJ IDEA.
  User: ASHWANI
  Date: 09-12-2022
  Time: 01:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  session.invalidate();
  response.sendRedirect("Login.html");
  %>
%>
</body>
</html>
