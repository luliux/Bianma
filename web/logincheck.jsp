<%--
  Created by IntelliJ IDEA.
  User: 卢柳辛
  Date: 2023/6/23
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username.equals(password)){
        session.setAttribute("username",username);
        response.sendRedirect("ok.jsp");
    }else {
        response.sendRedirect("error.html");
    }
%>
</body>
</html>
